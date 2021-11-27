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


class StarTest {
    private final Star starCommand = new Star();
    private UserList userList;

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        TaskController.getInstance().setInputBoundary(new TaskUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

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

}