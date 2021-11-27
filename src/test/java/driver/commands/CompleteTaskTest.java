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


class CompleteTaskTest {
    private final CompleteTask completeTaskCommand = new CompleteTask();
    private UserList userList;

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        TaskController.getInstance().setInputBoundary(new TaskUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

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

}