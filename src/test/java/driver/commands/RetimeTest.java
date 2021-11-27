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


class RetimeTest {
    private final Retime retimeCommand = new Retime();
    private UserList userList;

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        TaskController.getInstance().setInputBoundary(new TaskUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

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

}