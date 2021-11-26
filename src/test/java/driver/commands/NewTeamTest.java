package driver.commands;

import controllers.DataMemoryController;
import controllers.TeamController;
import entities.Team;
import entities.User;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.TeamUseCases;
import usecases.managers.UserList;

class NewTeamTest {
    private final NewTeam newteamCommand = new NewTeam();
    private UserList userList;

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        TeamController.getInstance().setInputBoundary(new TeamUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    @Test
    public void testSuccessfullyAddedTeam() {
        try {
            String[] args = {"Baseline Gang"};
            newteamCommand.execute("Rafa", args);
            // Check that the system has the team
            User user = userList.getUser("Rafa");
            Team team = user.getTeamList().getTeam("Baseline Gang");
            Assertions.assertTrue(user.getTeamList().hasTeam("Baseline Gang") && team.isAdmin("Rafa"),
                    "Failure: Team has not been added successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }
}