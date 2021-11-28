package driver.commands;

import controllers.DataMemoryController;
import controllers.TaskController;
import entities.Task;
import entities.User;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.TaskUseCases;
import usecases.managers.UserList;


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
    @Test
    public void testTaskExist() {
        try {
            String[] args = {"Exercise", "TaskDNE"};
            renameCommand.execute("Rafa", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

}