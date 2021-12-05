import controllers.DataMemoryController;
import controllers.ProjectController;
import driver.commands.DelProj;
import entities.User;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.ProjectUseCases;
import usecases.managers.UserList;

/**
 * This class is a test for class DelProj
 */
class DelProjTest {
    private final DelProj delProjCommand = new DelProj();
    private UserList userList = new UserList();

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        ProjectController.getInstance().setInputBoundary(new ProjectUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    /**
     * This test case tests if an existing project other than "General" can be deleted
     * This test case executes the DelProj command: Delete the project called <name> and delete all its tasks.
     * @result The project "Take Over" will be deleted from the user "Nole"
     */
    @Test
    public void testSuccessfullyDeletedProj() {
        try {
            String[] args = {"Take Over"};
            delProjCommand.execute("Nole", args);
            // Check that the system no longer has this project
            User user = userList.getUser("Nole");
            Assertions.assertFalse(user.getProjectList().hasProject("Take Over"),
                    "Failure: Project has not been deleted successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    /**
     * This test case tests if "General" project can be deleted
     * This test case executes the DelProj command: Delete the project called <name> and delete all its tasks.
     * @result This action will not be performed since "General" project is a default project, and it cannot be modified
     * or deleted
     */
    @Test
    public void testRemoveGeneralProj() {
        try {
            String[] args = {"General"};
            delProjCommand.execute("Nole", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    /**
     * This test case tests if a non-existing project can be deleted
     * This test case executes the DelProj command: Delete the project called <name> and delete all its tasks.
     * @result This action will not be performed since the user "Rafa" does not have project "Take Over" to delete
     */
    @Test
    public void testProjNotExist() {
        try {
            String[] args = {"Take Over"};
            delProjCommand.execute("Rafa", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }
}