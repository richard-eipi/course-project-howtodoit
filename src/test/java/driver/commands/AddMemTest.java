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

class AddMemTest {
    private final AddMem addmemCommand = new AddMem();
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
        team.addMem(user);
        team.addAdmin(user);
        TeamController.getInstance().setInputBoundary(new TeamUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    @Test
    public void testSuccessfullyAddedMem() {
        try {
            String[] args = {teamName, username2};
            addmemCommand.execute(username, args);
            // Check that user2 is added to the team
            User user2 = userList.getUser(username2);
            Team team = user2.getTeam(teamName);
            Assertions.assertTrue(team.isMem(username2) && user2.hasTeam(teamName),
                    "Failure: Member has not been added successfully");
        } catch (Exception e) {
            Assertions.fail("Failure: an unexpected Exception was thrown.");
        }
    }
}