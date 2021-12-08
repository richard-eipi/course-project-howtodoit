import controllers.DataMemoryController;
import controllers.TeamController;
import driver.commands.ModTeam;
import entities.User;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.TeamUseCases;
import usecases.managers.UserList;

/**
 * This class is a test for class ModTeam
 */
class ModTeamTest {
    private final ModTeam modTeamCommand = new ModTeam();
    private UserList userList;

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        TeamController.getInstance().setInputBoundary(new TeamUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    /**
     * This test case tests if a team's name can be modified
     * This test case executes the modTeam command: rename the team from <name1> to <name2>
     *
     * @result Team "Goats Club" will be changed to "The Holy Trinity"
     */
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

    /**
     * This test case tests if a non-existing team's name can be modified
     * This test case executes the modTeam command: rename the team from <name1> to <name2>
     *
     * @result This action will not be performed since the team "The Holt Trinity" does not exist
     */
    @Test
    public void testTeamNotExist() {
        try {
            String[] args = {"The Holy Trinity", "The Big 3"};
            modTeamCommand.execute("Roge", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    /**
     * This test case tests if a non-admin team member can change the team's name
     * This test case executes the modTeam command: rename the team from <name1> to <name2>
     *
     * @result This action will not be performed since the member "Rafa" is not an admin of the team,
     * only admins of the team can perform this action.
     */
    @Test
    public void testMemNotAdmin() {
        try {
            String[] args = {"Goats Club", "The Holy Trinity"};
            modTeamCommand.execute("Rafa", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    /**
     * This test case tests if a same team name can be repetitively used
     * This test case executes the modTeam command: rename the team from <name1> to <name2>
     *
     * @result This action will not be performed since team "Goats Club" already exists
     */
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