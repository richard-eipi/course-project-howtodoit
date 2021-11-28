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


class DelTeamTest {
    private final DelTeam delTeamCommand = new DelTeam();
    private UserList userList;

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        TeamController.getInstance().setInputBoundary(new TeamUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    @Test
    public void testSuccessfullyDeletedTeam() {
        try {
            String[] args = {"Goats Club"};
            delTeamCommand.execute("Roge", args);
            // Check that the system no longer has the team
            User user = userList.getUser("Roge");
            Assertions.assertFalse(user.getTeamList().hasTeam("Goats Club"),
                    "Failure: Team has not been added successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testTeamDoesNotExist() {
        try {
            String[] args = {"Baseline Gang"};
            delTeamCommand.execute("Rafa", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    @Test
    public void testMemNotAdmin() {
        try {
            String[] args = {"Goats Club"};
            delTeamCommand.execute("Rafa", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }
}