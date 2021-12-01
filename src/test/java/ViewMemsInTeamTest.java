import controllers.DataMemoryController;
import controllers.QueryController;
import driver.commands.ViewMemsInTeam;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.QueryUseCases;
import usecases.managers.UserList;


class ViewMemsInTeamTest {
    private final ViewMemsInTeam viewMemsInTeamCommand = new ViewMemsInTeam();

    @BeforeEach
    void setUp() {
        UserList userList = TestingSystemSetUp.SetUp();
        QueryController.getInstance().setInputBoundary(new QueryUseCases(userList));
    }

    @Test
    public void testSuccessfullyShowedMems() {
        try {
            String[] args = {"Goats Club"};
            String result = viewMemsInTeamCommand.execute("Roge", args);
            String actual = "This team <Goats Club> consists of the following members:\nRafa\n*ADMIN* Roge\n";
            // Check that the returned String is correct
            Assertions.assertEquals(result, actual,
                    "Failure: Failed to show team members successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

}