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


class LeaveTeamTest {
    private final LeaveTeam leaveTeamCommand = new LeaveTeam();
    private UserList userList = new UserList();

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        TeamController.getInstance().setInputBoundary(new TeamUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

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
}