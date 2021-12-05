import controllers.DataMemoryController;
import controllers.TeamController;
import driver.commands.NewTeam;
import entities.Team;
import entities.User;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.TeamUseCases;
import usecases.managers.UserList;

/**
 * This class is a test for class NewTeam
 */
class NewTeamTest {
    private final NewTeam newTeamCommand = new NewTeam();
    private UserList userList;

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        TeamController.getInstance().setInputBoundary(new TeamUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    /**
     * This test case tests if a new team can be created and will the creator join the team automatically
     * as an admin.
     * This test case executes the newTeam command: create a new team called <name> and join the team automatically
     * as an admin.
     * @result A new team called "Baseline Gang" will be created, the user "Rafa" will automatically be promoted as an
     * admin of "Baseline Gang"
     */
    @Test
    public void testSuccessfullyAddedTeam() {
        try {
            String[] args = {"Baseline Gang"};
            newTeamCommand.execute("Rafa", args);
            // Check that the system has the team
            User user = userList.getUser("Rafa");
            Team team = user.getTeamList().getTeam("Baseline Gang");
            Assertions.assertTrue(user.getTeamList().hasTeam("Baseline Gang") && team.isAdmin("Rafa"),
                    "Failure: Team has not been added successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }
    /**
     * This test case tests if a same team name can be repetitively used
     * This test case executes the newTeam command: create a new team called <name> and join the team automatically
     * as an admin.
     * @result This action will not be performed since team "Goats Club" already exists
     */
    @Test
    public void testTeamAlreadyExists() {
        try {
            String[] args = {"Goats Club"};
            newTeamCommand.execute("Rafa", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }
}