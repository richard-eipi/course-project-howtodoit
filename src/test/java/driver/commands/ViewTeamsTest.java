package driver.commands;

import controllers.DataMemoryController;
import controllers.QueryController;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.QueryUseCases;
import usecases.managers.UserList;

import static org.junit.jupiter.api.Assertions.*;

class ViewTeamsTest {
    private final ViewTeams viewTeamsCommand = new ViewTeams();

    @BeforeEach
    void setUp() {
        UserList userList = TestingSystemSetUp.SetUp();
        QueryController.getInstance().setInputBoundary(new QueryUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

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