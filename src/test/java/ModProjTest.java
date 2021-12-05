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

/**
 * This class is a test for class ModProj
 */
class ModProjTest {
    private final ModProj modProjCommand = new ModProj();
    private UserList userList = new UserList();

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        ProjectController.getInstance().setInputBoundary(new ProjectUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    /**
     * This test case tests if an existing project can be renamed
     * This test case executes the modproj command: change a project’s name from <name1> to <name2>
     * @result The project "Take Over" will be renamed to "Join Goats Club"
     */
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

    /**
     * This test case tests if "General" project can be renamed
     * This test case executes the modproj command: change a project’s name from <name1> to <name2>
     * @result This action will not be performed since "General" project is a default project, and it cannot be modified
     * or deleted
     */
    @Test
    public void testRenameGeneral() {
        try {
            String[] args = {"General", "Else"};
            modProjCommand.execute("Nole", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    /**
     * This test case tests if "Assigned to me" project can be renamed
     * This test case executes the modproj command: change a project’s name from <name1> to <name2>
     * @result This action will not be performed since "Assigned to me" project is a default project,
     * and it cannot be modified or deleted
     */
    @Test
    public void testRenameAssignedtome() {
        try {
            String[] args = {"Assigned to me", "Else"};
            modProjCommand.execute("Nole", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    /**
     * This test case tests if a non-existing project can be renamed
     * This test case executes the modproj command: change a project’s name from <name1> to <name2>
     * @result This action will not be performed since the project "NotExist" does not exist
     */
    @Test
    public void testProjNotExist() {
        try {
            String[] args = {"NotExist", "Else"};
            modProjCommand.execute("Nole", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    /**
     * This test case tests if a same project name can be repetitively used
     * This test case executes the modproj command: change a project’s name from <name1> to <name2>
     * @result This action will not be performed since "General" project already exists, same name cannot be used
     * for more than one project
     */
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