package driver.commands;

import controllers.DataMemoryController;
import controllers.TeamController;
import entities.Team;
import entities.User;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.TeamUseCases;
import usecases.managers.UserList;

class AddAdminTest {
    private final AddAdmin addadminCommand = new AddAdmin();
    private UserList userList = new UserList();

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        TeamController.getInstance().setInputBoundary(new TeamUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    @Test
    public void testSuccessfullyAddedAdmin() {
        try {
            String[] args = {"Goats Club", "Rafa"};
            addadminCommand.execute("Roge", args);
            // Check that the user is a new administrator
            User user2 = userList.getUser("Rafa");
            Team team = user2.getTeamList().getTeam("Goats Club");
            Assertions.assertTrue(team.isAdmin("Rafa"),
                    "Failure: Administrator has not been added successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }
}