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

class NewTeamTest {
    private final NewTeam newteamCommand = new NewTeam();
    private UserList userList;
    private final String username = "Jiayang";

    @BeforeEach
    void setUp() {
        userList = new UserList();
        User user = new User(username, "+1=0");
        userList.addUser(user);
        TeamController.getInstance().setInputBoundary(new TeamUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    @Test
    public void testSuccessfullyAddedTeam() {
        try {
            String teamName = "howtodoit";
            String[] args = {teamName};
            newteamCommand.execute(username, args);
            // Check that the system has the team
            User user = userList.getUser(username);
            Team team = user.getTeam(teamName);
            Assertions.assertTrue(user.hasTeam(teamName) && team.isAdmin(username),
                    "Failure: Team has not been added successfully");
        } catch (Exception e) {
            Assertions.fail("Failure: an unexpected Exception was thrown.");
        }
    }
}