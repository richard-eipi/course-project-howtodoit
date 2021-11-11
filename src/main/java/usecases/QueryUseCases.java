package usecases;

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
        return null;
    }

    /**
     * Show all members in a team.
     * @param username current username
     * @param teamName name of the team
     * @return String showing all members in a team
     */
    @Override
    public String viewMemsIn(String username, String teamName) {
        return null;
    }

    /**
     * Show all projects for the user.
     * @param username current username
     * @return String showing all projects for the user
     */
    @Override
    public String viewProjs(String username) {
        return null;
    }

    /**
     * Show all tasks for the user.
     * @param username current username
     * @return String showing all tasks for the user
     */
    @Override
    public String viewTasks(String username) {
        return null;
    }

    /**
     * Show all tasks in a project.
     * @param username current username
     * @param projName name of the project
     * @return String showing all tasks in a project
     */
    @Override
    public String viewTasksInProj(String username, String projName) {
        return null;
    }
}
