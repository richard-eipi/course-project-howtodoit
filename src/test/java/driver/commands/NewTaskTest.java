package driver.commands;

import entities.Project;
import entities.User;
import org.junit.jupiter.api.*;
import usecases.UserList;

class NewTaskTest {
    private final NewTask newtaskCommand = new NewTask();
    private UserList userList;
    private final String username = "Eipi";

    @BeforeEach
    void setUp() {
        userList = new UserList();
        User user = new User(username, "+1=0");
        userList.addUser(user);
        user.addProject(new Project("CSC207"));
    }

    @Test
    public void testSuccessfullyAddedTask() {
        try {
            String taskName = "Phase 1";
            String dueDate = "2021-11-15";
            String[] args = {taskName, dueDate};
            newtaskCommand.execute(username, args);
            // Check that the system has this task
            User user = userList.getUser(username);
            Assertions.assertTrue(user.hasTask(taskName) &&
                            user.getTask(taskName).getDueDate().equals(dueDate) &&
                            user.getProject("General").hasTask(taskName),
                    "Failure: Task has not been added successfully");
        } catch (Exception e) {
            Assertions.fail("Failure: An unexpected Exception was thrown.");
        }
    }

    @Test
    public void testSuccessfullyAddedTaskOptionalArgument() {
        try {
            String taskName = "Phase 1";
            String dueDate = "2021-11-15";
            String projName = "CSC207";
            String[] args = {taskName, dueDate, projName};
            newtaskCommand.execute(username, args);
            // Check that the system has this task
            User user = userList.getUser(username);
            Assertions.assertTrue(user.hasTask(taskName) &&
                            user.getTask(taskName).getDueDate().equals(dueDate) &&
                            user.getProject(projName).hasTask(taskName),
                    "Failure: Task has not been added successfully");
        } catch (Exception e) {
            Assertions.fail("Failure: An unexpected Exception was thrown.");
        }
    }
}

