import controllers.DataMemoryController;
import controllers.TaskController;
import driver.commands.CompleteTask;
import entities.User;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.TaskUseCases;
import usecases.managers.UserList;


class CompleteTaskTest {
    private final CompleteTask completeTaskCommand = new CompleteTask();
    private UserList userList;

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        TaskController.getInstance().setInputBoundary(new TaskUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    // test if user has the task and completes it.
    @Test
    public void testSuccessfullyCompletedTask() {
        try {
            String[] args = {"Practice"};
            completeTaskCommand.execute("Rafa", args);
            // Check that the system no longer has this task
            User user = userList.getUser("Rafa");
            Assertions.assertFalse(user.getTaskList().hasTask("Practice") ||
                            user.getProjectList().getProject("General").hasTask("Practice"),
                    "Failure: Task has not been completed successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    // test if user does not have the task.
    @Test
    public void testTaskExist() {
        try {
            String[] args = {"Exercise"};
            completeTaskCommand.execute("Rafa", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }
}