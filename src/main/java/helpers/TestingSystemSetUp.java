package helpers;

import controllers.DataMemoryController;
import controllers.TeamController;
import entities.Project;
import entities.Task;
import entities.Team;
import entities.User;
import usecases.DataMemoryUseCases;
import usecases.TeamUseCases;
import usecases.managers.ProjectManager;
import usecases.managers.TaskManager;
import usecases.managers.TeamManager;
import usecases.managers.UserList;

/**
 * This class helps testing classes set up a basic system before testing
 */
public class TestingSystemSetUp {
    /***
     * Set up for test cases.
     * @return the user list
     */
    public static UserList SetUp() {
        UserList userList = new UserList();
        // Create 3 users
        User roge = new User("Roge", "1981", new TaskManager(), new ProjectManager(), new TeamManager());
        User rafa = new User("Rafa", "1986", new TaskManager(), new ProjectManager(), new TeamManager());
        User nole = new User("Nole", "1987", new TaskManager(), new ProjectManager(), new TeamManager());

        // Create a team "Goats Club" and add Roge and Rafa, Roge being the admin
        Team team = new Team("Goats Club");
        roge.getTeamList().addTeam(team);
        rafa.getTeamList().addTeam(team);
        team.addMem(roge);
        team.addMem(rafa);
        team.addAdmin(roge);

        // Create a project "Take Over" for Nole
        nole.getProjectList().addProject(new Project("Take Over"));

        userList.addUser(roge);
        userList.addUser(rafa);
        userList.addUser(nole);
        return userList;
    }
}
