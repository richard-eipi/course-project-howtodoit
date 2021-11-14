package driver.commands;

import controllers.DataMemoryController;
import controllers.TeamController;
import entities.Team;
import entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.TeamUseCases;
import usecases.UserList;

class AddAdminTest {
    private final AddAdmin addadminCommand = new AddAdmin();
    private UserList userList = new UserList();
    private final String username = "Jiayang";
    private final String username2 = "Krystal";
    private final String teamName = "howtodoit";

    @BeforeEach
    void setUp() {
        userList = new UserList();
        User user = new User(username, "+1=0");
        User user2 = new User(username2, "1111");
        userList.addUser(user);
        userList.addUser(user2);
        Team team = new Team(teamName);
        user.addTeam(team);
        user2.addTeam(team);
        team.addMem(user);
        team.addMem(user2);
        team.addAdmin(user);
        TeamController.getInstance().setInputBoundary(new TeamUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    @Test
    public void testSuccessfullyAddedAdmin() {
        try {
            String[] args = {teamName, username2};
            addadminCommand.execute(username, args);
            // Check that the user is a new administrator
            User user2 = userList.getUser(username2);
            Team team = user2.getTeam(teamName);
            Assertions.assertTrue(team.isAdmin(username2),
                    "Failure: Administrator has not been added successfully");

        } catch (Exception e) {
            Assertions.fail("Failure: an unexpected Exception was thrown.");
        }
    }
}