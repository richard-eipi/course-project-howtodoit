import controllers.DataMemoryController;
import controllers.TeamController;
import driver.commands.DelTeam;
import entities.User;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.TeamUseCases;
import usecases.managers.UserList;

/**
 * This class is a test for class DelTeam
 */
class DelTeamTest {
    private final DelTeam delTeamCommand = new DelTeam();
    private UserList userList;

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        TeamController.getInstance().setInputBoundary(new TeamUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    /**
     * This test case tests if an existing team can be deleted
     * This test case executes the DelTeam command: Delete the team called <name>.
     * @result The team "Goat Club" will be deleted
     */
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

    /**
     * This test case tests if a non-existing team can be deleted
     * This test case executes the DelTeam command: Delete the team called <name>.
     * @result This action will not be performed since the team "Baseline Gang" does not exist
     */
    @Test
    public void testTeamNotExist() {
        try {
            String[] args = {"Baseline Gang"};
            delTeamCommand.execute("Rafa", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    /**
     * This test case tests if a non-admin member can delete the team
     * This test case executes the DelTeam command: Delete the team called <name>.
     * @result This action will not be performed since the user "Rafa" is not an admin of the team "Goats Club",
     * only admins of the team can perform this action.
     */
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