import controllers.DataMemoryController;
import controllers.ProjectController;
import driver.commands.ModProj;
import entities.User;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.ProjectUseCases;
import usecases.managers.UserList;


class ModProjTest {
    private final ModProj modProjCommand = new ModProj();
    private UserList userList = new UserList();

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        ProjectController.getInstance().setInputBoundary(new ProjectUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    @Test
    public void testSuccessfullyRenamedProj() {
        try {
            String[] args = {"Take Over", "Join Goats Club"};
            modProjCommand.execute("Nole", args);
            // Check that the project has been renamed
            User user = userList.getUser("Nole");
            Assertions.assertTrue(user.getProjectList().hasProject("Join Goats Club"),
                    "Failure: Project has not been renamed successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testRenameGeneral() {
        try {
            String[] args = {"General", "Else"};
            modProjCommand.execute("Nole", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    @Test
    public void testRenameAssignedtome() {
        try {
            String[] args = {"Assigned to me", "Else"};
            modProjCommand.execute("Nole", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    @Test
    public void testProjNotExist() {
        try {
            String[] args = {"NotExist", "Else"};
            modProjCommand.execute("Nole", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    @Test
    public void testNewNameAlreadyExists() {
        try {
            String[] args = {"Take Over", "General"};
            modProjCommand.execute("Nole", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }
}