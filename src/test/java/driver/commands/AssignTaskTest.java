package driver.commands;

import controllers.DataMemoryController;
import controllers.TaskController;
import entities.Team;
import entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.TaskUseCases;
import usecases.UserList;


class AssignTaskTest {
    private final AssignTask assignTaskCommand = new AssignTask();
    private UserList userList;
    private final String username = "Jiayang";
    private final String username2 = "Krystal";
    private final String teamName = "howtodoit";

    @BeforeEach
    void setUp() {
        userList = new UserList();
        User user = new User(username, "+1=0");
        User user2 = new User(username2, "+1=0");
        userList.addUser(user);
        userList.addUser(user2);
        Team team = new Team(teamName);
        user.addTeam(team);
        user2.addTeam(team);
        team.addMem(user);
        team.addMem(user2);
        team.addAdmin(user);
        TaskController.getInstance().setInputBoundary(new TaskUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    @Test
    public void testSuccessfullyAssignedTask() {
        try {
            String taskName = "Phase 1";
            String dueDate = "2021-11-15";
            String[] args = {teamName, username2, taskName, dueDate};
            assignTaskCommand.execute(username, args);
            // Check that the system has the task and the task has been assigned to user2
            User user2 = userList.getUser(username2);
            Assertions.assertTrue(user2.hasTask(taskName) &&
                            user2.getTask(taskName).getDueDate().equals(dueDate) &&
                            user2.getProject("Assigned to me").hasTask(taskName),
                    "Failure: Task has not been assigned successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}