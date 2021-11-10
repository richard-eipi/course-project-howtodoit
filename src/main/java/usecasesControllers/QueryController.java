package usecasesControllers;

public class QueryController {
    private static final QueryController instance = new QueryController();
    private QueryInputBoundary inputBoundary;

    public QueryController() {

    }

    public static QueryController getInstance(){
        return instance;
    }

    public void setInputBoundary(QueryInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Show all teams that the user is in.
     * @param username current username
     * @return String showing all teams that the user is in
     */
    public String viewTeams(String username) {
        return this.inputBoundary.viewTeams(username);
    }

    /**
     * Show all members in a team.
     * @param username current username
     * @param teamName name of the team
     * @return String showing all members in a team
     */
    public String viewMemsIn(String username, String teamName) {
        return this.inputBoundary.viewMemsIn(username, teamName);
    }

    /**
     * Show all projects for the user.
     * @param username current username
     * @return String showing all projects for the user
     */
    public String viewProjs(String username) {
        return this.inputBoundary.viewProjs(username);
    }

    /**
     * Show all tasks for the user.
     * @param username current username
     * @return String showing all tasks for the user
     */
    public String viewTasks(String username) {
        return this.inputBoundary.viewTasks(username);
    }

    /**
     * Show all tasks in a project.
     * @param username current username
     * @param projName name of the project
     * @return String showing all tasks in a project
     */
    public String viewTasksInProj(String username, String projName) {
        return this.inputBoundary.viewTasksInProj(username, projName);
    }
}
