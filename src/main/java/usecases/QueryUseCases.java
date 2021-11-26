package usecases;

import entities.Project;
import entities.Team;
import entities.User;
import usecases.managers.ProjectList;
import usecases.managers.TeamList;
import usecases.managers.UserList;

/**
 * This class deals with query use cases.
 */
public class QueryUseCases implements QueryInputBoundary {
    /**
     * The list of users.
     */
    private final UserList userList;

    /**
     * Constructor.
     *
     * @param userList the list of users
     */
    public QueryUseCases(UserList userList) {
        this.userList = userList;
    }

    /**
     * Show all teams that the user is in.
     *
     * @param username current username
     * @return String showing all teams that the user is in
     */
    @Override
    public String viewTeams(String username) {
        User user = this.userList.getUser(username);
        return user.getTeamList().toString();
    }

    /**
     * Show all members in a team.
     *
     * @param username current username
     * @param teamName name of the team
     * @return String showing all members in a team
     */
    @Override
    public String viewMemsInTeam(String username, String teamName) {
        User user = this.userList.getUser(username);
        TeamList teamList = user.getTeamList();
        if (!teamList.hasTeam(teamName)) {
            return "Team does not exist.";
        } else {
            Team team = teamList.getTeam(teamName);
            return team.toString();
        }
    }

    /**
     * Show all projects for the user.
     *
     * @param username current username
     * @return String showing all projects for the user
     */
    @Override
    public String viewProjs(String username) {
        User user = this.userList.getUser(username);
        return user.getProjectList().toString();
    }

    /**
     * Show all tasks for the user.
     *
     * @param username current username
     * @return String showing all tasks for the user
     */
    @Override
    public String viewTasks(String username) {
        User user = this.userList.getUser(username);
        return user.getTaskList().toString();
    }

    /**
     * Show all tasks in a project.
     *
     * @param username current username
     * @param projName name of the project
     * @return String showing all tasks in a project
     */
    @Override
    public String viewTasksInProj(String username, String projName) {
        User user = this.userList.getUser(username);
        ProjectList projectList = user.getProjectList();
        if (!projectList.hasProject(projName)) {
            return "Project does not exist.";
        } else {
            Project project = projectList.getProject(projName);
            return project.toString();
        }
    }
}
