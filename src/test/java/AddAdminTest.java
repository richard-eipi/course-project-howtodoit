import controllers.DataMemoryController;
import controllers.TeamController;
import driver.commands.AddAdmin;
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
 * This class is a test for class AddAdmin
 */
class AddAdminTest {

    private final AddAdmin addAdminCommand = new AddAdmin();
    private UserList userList = new UserList();

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        TeamController.getInstance().setInputBoundary(new TeamUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    /**
     * This test case tests if an existing member of an existing team can be promoted to an admin of the team
     * This test case executes the addAdmin command: promote the user called <username> to an admin of <team name>
     *
     * @result The user "Rafa" will be promoted to an admin of the team "Goats Club"
     */
    @Test
    public void testSuccessfullyAddedAdmin() {
        try {
            String[] args = {"Goats Club", "Rafa"};
            addAdminCommand.execute("Roge", args);
            // Check that the user is a new administrator
            User user2 = userList.getUser("Rafa");
            Team team = user2.getTeamList().getTeam("Goats Club");
            Assertions.assertTrue(team.isAdmin("Rafa"),
                    "Failure: Administrator has not been added successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    /**
     * This test case tests if an existing user can be promoted to an admin of a non-existing team
     * This test case executes the addAdmin command: promote the user called <username> to an admin of <team name>
     *
     * @result The action will not be performed since team "Serve & Volley Gang" does not exist,
     * the user "Nole" will not be promoted to an admin
     */
    @Test
    public void testTeamNotExist() {
        try {
            String[] args = {"Serve & Volley Gang", "Nole"};
            addAdminCommand.execute("Roge", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    /**
     * This test case tests if a non-existent member can get added to the team
     * This test case executes the addAdmin command: promote the user called <username> to an admin of <team name>
     *
     * @result The action will not be performed since user "Andy" doesn't exist
     */
    @Test
    public void testMemNotExist() {
        try {
            String[] args = {"Goats Club", "Andy"};
            addAdminCommand.execute("Roge", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    /**
     * This test case tests if a non-admin user can promote another existing user to an admin of an existing team
     * This test case executes the addAdmin command: promote the user called <username> to an admin of <team name>
     *
     * @result The action will not be performed since the user "Rafa" is not an admin of the team,
     * only admins of the team can perform this action
     */
    @Test
    public void testMemNotAdmin() {
        try {
            String[] args = {"Goats Club", "Roge"};
            addAdminCommand.execute("Rafa", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    /**
     * This test case tests if the admin of the team can promote a user that is not in the team to an admin
     * This test case executes the addAdmin command: promote the user called <username> to an admin of <team name>
     *
     * @result The action will not be performed since the user "Nole" is not a member of team "Goats Club"
     */
    @Test
    public void testMemNotInTeam() {
        try {
            String[] args = {"Goats Club", "Nole"};
            addAdminCommand.execute("Roge", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }
}