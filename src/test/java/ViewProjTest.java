import controllers.DataMemoryController;
import controllers.QueryController;
import driver.commands.ViewProj;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.QueryUseCases;
import usecases.managers.UserList;

/**
 * This class is a test for class ViewProj
 */
class ViewProjTest {
    private final ViewProj viewProjCommand = new ViewProj();

    @BeforeEach
    void setUp() {
        UserList userList = TestingSystemSetUp.SetUp();
        QueryController.getInstance().setInputBoundary(new QueryUseCases(userList));
    }

    /**
     * This test case tests if ViewMemsInTeam shows all members in the team
     * This test case executes the viewMemsIn command: show all members in the team called <name>.
     * @result The returned string will be
     * "This team <Goats Club> consists of the following members:\nRafa\n*ADMIN* Roge\n", assertion will be true
     */
    @Test
    public void testSuccessfullyShowedProjects() {
        try {
            String[] args = {};
            String result = viewProjCommand.execute("Nole", args);
            String actual = "You have the following projects:\nAssigned to me\nGeneral\nTake Over\n";
            // Check that the returned String is correct
            Assertions.assertEquals(result, actual,
                    "Failure: Failed to show projects successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

}