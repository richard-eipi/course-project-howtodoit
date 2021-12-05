import controllers.DataMemoryController;
import controllers.TaskController;
import driver.commands.Star;
import entities.User;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.TaskUseCases;
import usecases.managers.UserList;

/**
 * This class is a test for class Star
 */
class StarTest {
    private final Star starCommand = new Star();
    private UserList userList;

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        TaskController.getInstance().setInputBoundary(new TaskUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    // test if user has the task and stars it.
    /**
     * This test case tests if an existing task can be starred
     * This test case executes the star command: Add a task called <name> to Starred label
     * @result The task "Practice" will be starred
     */
    @Test
    public void testSuccessfullyStarredTask() {
        try {
            String[] args = {"Practice"};
            starCommand.execute("Rafa", args);
            // Check that the task has been starred
            User user = userList.getUser("Rafa");
            Assertions.assertTrue(user.getTaskList().getTask("Practice").isStarred(),
                    "Failure: Task has not been starred successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    // test if user does not have the task.
    /**
     * This test case tests if a non-existing task can be starred
     * This test case executes the star command: Add a task called <name> to Starred label
     * @result This action will not be performed since task "Exercise" does not exist
     */
    @Test
    public void testTaskExist() {
        try {
            String[] args = {"Exercise"};
            starCommand.execute("Rafa", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }
}