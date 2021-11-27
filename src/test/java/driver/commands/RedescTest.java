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


class RedescTest {
    private final Redesc redescCommand = new Redesc();
    private UserList userList;

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        TaskController.getInstance().setInputBoundary(new TaskUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

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

}