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

class NewTaskTest {
    private final NewTask newTaskCommand = new NewTask();
    private UserList userList;

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        TaskController.getInstance().setInputBoundary(new TaskUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }
    // test if task added successfully
    @Test
    public void testSuccessfullyAddedTask() {
        try {
            String[] args = {"Practice", "2021-12-15"};
            newTaskCommand.execute("Roge", args);
            // Check that the system has this task
            User user = userList.getUser("Roge");
            Assertions.assertTrue(user.getTaskList().hasTask("Practice") &&
                            user.getTaskList().getTask("Practice").getDueDate().equals("2021-12-15") &&
                            user.getProjectList().getProject("General").hasTask("Practice"),
                    "Failure: Task has not been added successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    // test if task with optional argument added successfully
    @Test
    public void testSuccessfullyAddedTaskOptionalArgument() {
        try {
            String[] args = {"Practice", "2021-12-15", "Take Over"};
            newTaskCommand.execute("Nole", args);
            // Check that the system has this task
            User user = userList.getUser("Nole");
            Assertions.assertTrue(user.getTaskList().hasTask("Practice") &&
                            user.getTaskList().getTask("Practice").getDueDate().equals("2021-12-15") &&
                            user.getProjectList().getProject("Take Over").hasTask("Practice"),
                    "Failure: Task has not been added successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    // test if current user already has the task
    @Test
    public void testTaskAlreadyExists() {
        try {
            String[] args = {"Practice", "2021-12-15", "General"};
            newTaskCommand.execute("Rafa", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    // test if due date format is incorrect
    @Test
    public void testWrongDueDateFormat() {
        try {
            String[] args = {"Practice", "2021.12.15", "General"};
            newTaskCommand.execute("Rafa", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    // test if due date is an invalid date
    @Test
    public void testOverdueTask() {
        try {
            String[] args = {"Practice", "2012-12-15", "General"};
            newTaskCommand.execute("Rafa", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }
}

