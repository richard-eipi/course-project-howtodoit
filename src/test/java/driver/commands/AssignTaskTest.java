package driver.commands;

import controllers.DataMemoryController;
import controllers.TaskController;
import entities.Team;
import entities.User;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.TaskUseCases;
import usecases.managers.UserList;


class AssignTaskTest {
    private final AssignTask assignTaskCommand = new AssignTask();
    private UserList userList;

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        TaskController.getInstance().setInputBoundary(new TaskUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    @Test
    public void testSuccessfullyAssignedTask() {
        try {
            String[] args = {"Goats Club", "Rafa", "Practice", "2021-12-15"};
            assignTaskCommand.execute("Roge", args);
            // Check that the system has the task and the task has been assigned to user2
            User user2 = userList.getUser("Rafa");
            Assertions.assertTrue(user2.getTaskList().hasTask("Practice") &&
                            user2.getTaskList().getTask("Practice").getDueDate().equals("2021-12-15") &&
                            user2.getProjectList().getProject("Assigned to me").hasTask("Practice"),
                    "Failure: Task has not been assigned successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }
}