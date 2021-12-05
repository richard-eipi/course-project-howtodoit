import controllers.DataMemoryController;
import controllers.TeamController;
import driver.commands.LeaveTeam;
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
 * This class is a test for class LeaveTeam
 */
class LeaveTeamTest {
    private final LeaveTeam leaveTeamCommand = new LeaveTeam();
    private UserList userList = new UserList();

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        TeamController.getInstance().setInputBoundary(new TeamUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    /**
     * This test case tests if a team member can leave the team
     * This test case executes the leaveTeam command: remove the current user from the team <team name>
     * @result The team "Goats Club" will no longer have team member "Rafa"
     */
    @Test
    public void testSuccessfullyLeftTeam() {
        try {
            String[] args = {"Goats Club"};
            leaveTeamCommand.execute("Rafa", args);
            // Check that rafa has left the team
            User rafa = userList.getUser("Rafa");
            User roge = userList.getUser("Roge");
            Team team = roge.getTeamList().getTeam("Goats Club");
            Assertions.assertFalse(team.isMem("Rafa") || rafa.getTeamList().hasTeam("Goats Club"),
                    "Failure: Member has not left team successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    /**
     * This test case tests if a user can leave a non-existing team
     * This test case executes the leaveTeam command: remove the current user from the team <team name>
     * @result This action will not be performed since the team "The Holy Trinity" does not exist
     */
    @Test
    public void testTeamNotExist() {
        try {
            String[] args = {"The Holy Trinity"};
            leaveTeamCommand.execute("Roge", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }
}