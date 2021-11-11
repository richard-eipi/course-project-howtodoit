package usecases;

import entities.Project;
import entities.Team;
import entities.User;

public class QueryUseCases implements QueryInputBoundary {
    private final UserList userList;

    public QueryUseCases(UserList userList) {
        this.userList = userList;
    }

    /**
     * Show all teams that the user is in.
     * @param username current username
     * @return String showing all teams that the user is in
     */
    @Override
    public String viewTeams(String username) {
        User user = this.userList.getUser(username);
        return user.getTeams();
    }

    /**
     * Show all members in a team.
     * @param username current username
     * @param teamName name of the team
     * @return String showing all members in a team
     */
    @Override
    public String viewMemsInTeam(String username, String teamName) {
        User user = this.userList.getUser(username);
        if (!user.hasTeam(teamName)) {
            return "Team does not exist.";
        } else {
            Team team = user.getTeam(teamName);
            return team.toString();
        }
    }

    /**
     * Show all projects for the user.
     * @param username current username
     * @return String showing all projects for the user
     */
    @Override
    public String viewProjs(String username) {
        User user = this.userList.getUser(username);
        return user.getProjects();
    }

    /**
     * Show all tasks for the user.
     * @param username current username
     * @return String showing all tasks for the user
     */
    @Override
    public String viewTasks(String username) {
        User user = this.userList.getUser(username);
        return user.getTasks();
    }

    /**
     * Show all tasks in a project.
     * @param username current username
     * @param projName name of the project
     * @return String showing all tasks in a project
     */
    @Override
    public String viewTasksInProj(String username, String projName) {
        User user = this.userList.getUser(username);
        if (!user.hasProject(projName)) {
            return "Project does not exist.";
        } else {
            Project project = user.getProject(projName);
            return project.toString();
        }
    }
}
