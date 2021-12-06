import controllers.DataMemoryController;
import controllers.TaskController;
import driver.commands.Rename;
import entities.User;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.TaskUseCases;
import usecases.managers.UserList;

/**
 * This class is a test for class Rename
 */
class RenameTest {
    private final Rename renameCommand = new Rename();
    private UserList userList;

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        TaskController.getInstance().setInputBoundary(new TaskUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    // test if user has the task and renames it.

    /**
     * This test case tests if the name of an existing task can be modified
     * This test case executes the rename command: Change the name of a task from <name1> to <name2>
     *
     * @result Name of task "Practice" will be changed to "Work out"
     */
    @Test
    public void testSuccessfullyRenamedTask() {
        try {
            String[] args = {"Practice", "Work out"};
            renameCommand.execute("Rafa", args);
            // Check that the task name has been changed
            User user = userList.getUser("Rafa");
            Assertions.assertTrue(user.getTaskList().hasTask("Work out"),
                    "Failure: Task name has not been changed successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    // test if user does not have the task.

    /**
     * This test case tests if the name of a non-existing task can be modified
     * This test case executes the rename command: Change the name of a task from <name1> to <name2>
     *
     * @result This action will not be performed since the task "Exercise" does not exist
     */
    @Test
    public void testTaskNotExist() {
        try {
            String[] args = {"Exercise", "TaskDNE"};
            renameCommand.execute("Rafa", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    // test if new task name already exists.

    /**
     * This test case tests if a same task name can be repetitively used
     * This test case executes the rename command: Change the name of a task from <name1> to <name2>
     *
     * @result This action will not be performed since the task "Practice" already exists
     */
    @Test
    public void testNewNameAlreadyExists() {
        try {
            String[] args = {"Practice", "Practice"};
            renameCommand.execute("Rafa", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

}