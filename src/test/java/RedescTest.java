import controllers.DataMemoryController;
import controllers.TaskController;
import driver.commands.Redesc;
import entities.Task;
import entities.User;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.TaskUseCases;
import usecases.managers.UserList;

/**
 * This class is a test for class Redesc
 */
class RedescTest {
    private final Redesc redescCommand = new Redesc();
    private UserList userList;

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        TaskController.getInstance().setInputBoundary(new TaskUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    // test if user has the task and changes the description.

    /**
     * This test case tests if the description of an existing task can be modified
     * This test case executes the redesc command: change the description of a task
     *
     * @result The description of task "Practice" will be changed to "Hit 100 passing shots."
     */
    @Test
    public void testSuccessfullyChangedDesc() {
        try {
            String[] args = {"Practice", "Hit 100 passing shots."};
            redescCommand.execute("Rafa", args);
            // Check that the description has been changed
            User user = userList.getUser("Rafa");
            Task task = user.getTaskList().getTask("Practice");
            Assertions.assertEquals("Hit 100 passing shots.", task.getDescription(),
                    "Failure: Description has not been changed successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    // test if user does not have the task.

    /**
     * This test case tests if the description of a non-existing task can be modified
     * This test case executes the redesc command: change the description of a task
     *
     * @result This action will not be performed since the task "Exercise" does not exist
     */
    @Test
    public void testTaskExist() {
        try {
            String[] args = {"Exercise", "This task should not exist."};
            redescCommand.execute("Rafa", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

}