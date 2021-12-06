import controllers.DataMemoryController;
import controllers.TaskController;
import driver.commands.AssignTask;
import entities.User;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.TaskUseCases;
import usecases.managers.UserList;

/**
 * This class is a test for class AssignTask
 */
class AssignTaskTest {
    private final AssignTask assignTaskCommand = new AssignTask();
    private UserList userList;

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        TaskController.getInstance().setInputBoundary(new TaskUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    /**
     * This test case tests if an admin of the team can assign task to a team member
     * This test case executes the assignTask command: create a new task called <task name> for a teammate called
     * <username> in a team called <team name> with <due date>
     *
     * @result The user "Rafa" will be assigned a task called "Practice" with due date on "2021-12-15"
     */
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

    // test if the current user is not in this team.

    /**
     * This test case tests if a non-existing team member can assign task to another team member
     * This test case executes the assignTask command: create a new task called <task name> for a teammate called
     * <username> in a team called <team name> with <due date>
     *
     * @result The action will not be performed since the user "Nole" is not either a member or an admin
     * of the team "Goats Club", only admins of the team can perform this action
     */
    @Test
    public void testCurrentUserNotExist() {
        try {
            String[] args = {"Goats Club", "Rafa", "Practice", "2021-12-15"};
            assignTaskCommand.execute("Nole", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    // test if the user is not an admin.

    /**
     * This test case tests if a non-admin member of the team can assign task to another team member
     * This test case executes the assignTask command: create a new task called <task name> for a teammate called
     * <username> in a team called <team name> with <due date>
     *
     * @result The action will not be performed since the user "Rafa" is not an admin of the team "Goats Club",
     * only admins of the team can perform this action
     */
    @Test
    public void testUserNotAdmin() {
        try {
            String[] args = {"Goats Club", "Roge", "Practice", "2021-12-15"};
            assignTaskCommand.execute("Rafa", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    // test if the user is not in this team.

    /**
     * This test case tests if an admin of the team can assign task to a non-existing team member
     * This test case executes the assignTask command: create a new task called <task name> for a teammate called
     * <username> in a team called <team name> with <due date>
     *
     * @result The action will not be performed since the user "Nole" is not a member of the team "Goats Club"
     */
    @Test
    public void testUserNotMem() {
        try {
            String[] args = {"Goats Club", "Nole", "Practice", "2021-12-15"};
            assignTaskCommand.execute("Roge", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    // test if date format is not correct

    /**
     * This test case tests if an admin of the team can assign task with a different due date format to a team member
     * This test case executes the assignTask command: create a new task called <task name> for a teammate called
     * <username> in a team called <team name> with <due date>
     *
     * @result The action will not be performed since the format of the task due date is incorrect
     */
    @Test
    public void testWrongDueDateFormat() {
        try {
            String[] args = {"Goats Club", "Rafa", "Practice", "2021.12.15"};
            assignTaskCommand.execute("Roge", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    // test if due date is valid

    /**
     * This test case tests if an admin of the team can assign task that is already overdue to a team member
     * This test case executes the assignTask command: create a new task called <task name> for a teammate called
     * <username> in a team called <team name> with <due date>
     *
     * @result The action will not be performed since the task is already overdue
     */
    @Test
    public void testOverdueTask() {
        try {
            String[] args = {"Goats Club", "Rafa", "Practice", "2012-12-15"};
            assignTaskCommand.execute("Roge", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }
}