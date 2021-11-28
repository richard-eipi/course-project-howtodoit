package driver.commands;

import controllers.DataMemoryController;
import controllers.TaskController;
import entities.User;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.TaskUseCases;
import usecases.managers.UserList;


class UnstarTest {
    private final Unstar unstarCommand = new Unstar();
    private UserList userList;

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        TaskController.getInstance().setInputBoundary(new TaskUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    // test if user has the task and unstars it.
    @Test
    public void testSuccessfullyUnstarredTask() {
        try {
            String[] args = {"Practice"};
            new Star().execute("Rafa", args); // star the task first, assuming Star works
            unstarCommand.execute("Rafa", args);
            // Check that the task has been unstarred
            User user = userList.getUser("Rafa");
            Assertions.assertFalse(user.getTaskList().getTask("Practice").isStarred(),
                    "Failure: Task has not been unstarred successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    // test if user does not have the task.
    @Test
    public void testTaskExist() {
        try {
            String[] args = {"Exercise"};
            unstarCommand.execute("Rafa", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }
}