package driver.commands;

import controllers.DataMemoryController;
import controllers.TeamController;
import entities.User;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.TeamUseCases;
import usecases.managers.UserList;


class ModTeamTest {
    private final ModTeam modTeamCommand = new ModTeam();
    private UserList userList;

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        TeamController.getInstance().setInputBoundary(new TeamUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    @Test
    public void testSuccessfullyRenamedTeam() {
        try {
            String[] args = {"Goats Club", "The Holy Trinity"};
            modTeamCommand.execute("Roge", args);
            // Check that the team has been renamed
            User user = userList.getUser("Roge");
            Assertions.assertTrue(user.getTeamList().hasTeam("The Holy Trinity"),
                    "Failure: Team has not been renamed successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testTeamDoesNotExist() {
        try {
            String[] args = {"The Holy Trinity", "The Big 3"};
            modTeamCommand.execute("Roge", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    @Test
    public void testMemNotAdmin() {
        try {
            String[] args = {"Goats Club", "The Holy Trinity"};
            modTeamCommand.execute("Rafa", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    @Test
    public void testRepetitiveTeam() {
        try {
            String[] args = {"Goats Club", "Goats Club"};
            modTeamCommand.execute("Rafa", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }
}