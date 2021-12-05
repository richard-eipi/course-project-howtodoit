import controllers.DataMemoryController;
import controllers.TeamController;
import driver.commands.AddMem;
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
 * This class is a test for class AddMem
 */
class AddMemTest {
    private final AddMem addMemCommand = new AddMem();
    private UserList userList = new UserList();

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        TeamController.getInstance().setInputBoundary(new TeamUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    /**
     * This test case tests if an existing user can be added to an existing team
     * This test case executes the addMem command: add a user called <username> to the team called <teamname>
     * @result The user "Nole" will be added to the team "Goats Club"
     */
    @Test
    public void testSuccessfullyAddedMem() {
        try {
            String[] args = {"Goats Club", "Nole"};
            addMemCommand.execute("Roge", args);
            // Check that user2 is added to the team
            User user2 = userList.getUser("Nole");
            Team team = user2.getTeamList().getTeam("Goats Club");
            Assertions.assertTrue(team.isMem("Nole") && user2.getTeamList().hasTeam("Goats Club"),
                    "Failure: Member has not been added successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    /**
     * This test case tests if an existing user can be added to a non-existing team
     * This test case executes the addMem command: add a user called <username> to the team called <teamname>
     * @result The action will not be performed since the team "Serve & Volley Gang" does not exist
     */
    @Test
    public void testTeamNotExist() {
        try {
            String[] args = {"Serve & Volley Gang", "Nole"};
            addMemCommand.execute("Roge", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    /**
     * This test case tests if a non-admin user can add an existing user to an existing team
     * This test case executes the addMem command: add a user called <username> to the team called <teamname>
     * @result The action will not be performed since the user "Rafa" is not an admin,
     * only admins of the team can perform this action.
     */
    @Test
    public void testMemNotAdmin() {
        try {
            String[] args = {"Goats Club", "Nole"};
            addMemCommand.execute("Rafa", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    /**
     * This test case tests if a team member can be re-added to the same team
     * This test case executes the addMem command: add a user called <username> to the team called <teamname>
     * @result The action will not be performed since the user "Rafa" is already in the team "Goats Club"
     */
    @Test
    public void testMemHasSameTeam() {
        try {
            String[] args = {"Goats Club", "Rafa"};
            addMemCommand.execute("Roge", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }
}