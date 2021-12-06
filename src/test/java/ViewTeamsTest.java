import controllers.QueryController;
import driver.commands.ViewTeams;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.QueryUseCases;
import usecases.managers.UserList;

/**
 * This class is a test for class ViewTeams
 */
class ViewTeamsTest {
    private final ViewTeams viewTeamsCommand = new ViewTeams();

    @BeforeEach
    void setUp() {
        UserList userList = TestingSystemSetUp.SetUp();
        QueryController.getInstance().setInputBoundary(new QueryUseCases(userList));
    }

    /**
     * This test case tests if ViewTeams shows all teams of the user
     * This test case executes the viewTeams command: show all teams that the user is in
     * @result The returned string will be
     * "You are in the following teams:\nGoats Club\n", assertion will be true
     */
    @Test
    public void testSuccessfullyShowedProjects() {
        try {
            String[] args = {};
            String result = viewTeamsCommand.execute("Roge", args);
            String actual = "You are in the following teams:\nGoats Club\n";
            // Check that the returned String is correct
            Assertions.assertEquals(result, actual,
                    "Failure: Failed to show teams successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

}