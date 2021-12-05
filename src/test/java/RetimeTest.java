import controllers.DataMemoryController;
import controllers.TaskController;
import driver.commands.Retime;
import entities.User;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.TaskUseCases;
import usecases.managers.UserList;

/**
 * This class is a test for class Retime
 */
class RetimeTest {
    private final Retime retimeCommand = new Retime();
    private UserList userList;

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        TaskController.getInstance().setInputBoundary(new TaskUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    // test if user has the task and retimed it.
    /**
     * This test case tests if the due-date of an existing task can be modified
     * This test case executes the retime command: change the due date of a task
     * @result The due-date of task "Practice" will be changed to "2021-12-20"
     */
    @Test
    public void testSuccessfullyChangedDueDate() {
        try {
            String[] args = {"Practice", "2021-12-20"};
            retimeCommand.execute("Rafa", args);
            // Check that the due date has been changed
            User user = userList.getUser("Rafa");
            Assertions.assertEquals("2021-12-20", user.getTaskList().getTask("Practice").getDueDate(),
                    "Failure: Due date has not been changed successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    // test if user does not have the task.
    /**
     * This test case tests if the due-date of a non-existing task can be modified
     * This test case executes the retime command: change the due date of a task
     * @result This action will not be performed since task "Exercise" does not exist, there's no due-date to work with
     */
    @Test
    public void testTaskNotExist() {
        try {
            String[] args = {"Exercise", "2021-12-20"};
            retimeCommand.execute("Rafa", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    // test if due date format is incorrect
    /**
     * This test case tests if the due-date of an existing task can be modified when the due-date format is incorrect
     * This test case executes the retime command: change the due date of a task
     * @result This action will not be performed since task "Exercise" the due-date format is incorrect
     */
    @Test
    public void testWrongDueDateFormat() {
        try {
            String[] args = {"Practice", "2021.12.18"};
            retimeCommand.execute("Rafa", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    // test if due date is an invalid date
    /**
     * This test case tests if the name of an overdue task can be modified
     * This test case executes the retime command: change the due date of a task
     * @result This action will not be performed since task "Practice" is already overdue
     */
    @Test
    public void testOverdueTask() {
        try {
            String[] args = {"Practice", "2012-12-15"};
            retimeCommand.execute("Rafa", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }
}