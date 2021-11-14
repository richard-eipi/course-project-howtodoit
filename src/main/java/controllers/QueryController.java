package controllers;

import usecases.QueryInputBoundary;

/**
 * This class allows user to view all projects and all tasks in projects, all teams and all members in a team.
 */
public class QueryController {
    /**
     * The singleton instance.
     */
    private static final QueryController instance = new QueryController();
    /**
     * The input boundary.
     */
    private QueryInputBoundary inputBoundary;

    /**
     * Private to prevent anyone else from instantiating.
     */
    private QueryController() {

    }

    /**
     * Provides access to the singleton instance.
     *
     * @return the instance
     */
    public static QueryController getInstance() {
        return instance;
    }

    /**
     * Sets input boundary.
     *
     * @param inputBoundary the use case interface
     */
    public void setInputBoundary(QueryInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Show all teams that the user is in.
     *
     * @param username current username
     * @return String showing all teams that the user is in
     */
    public String viewTeams(String username) {
        return this.inputBoundary.viewTeams(username);
    }

    /**
     * Show all members in a team.
     *
     * @param username current username
     * @param teamName name of the team
     * @return String showing all members in a team
     */
    public String viewMemsInTeam(String username, String teamName) {
        return this.inputBoundary.viewMemsInTeam(username, teamName);
    }

    /**
     * Show all projects for the user.
     *
     * @param username current username
     * @return String showing all projects for the user
     */
    public String viewProjs(String username) {
        return this.inputBoundary.viewProjs(username);
    }

    /**
     * Show all tasks for the user.
     *
     * @param username current username
     * @return String showing all tasks for the user
     */
    public String viewTasks(String username) {
        return this.inputBoundary.viewTasks(username);
    }

    /**
     * Show all tasks in a project.
     *
     * @param username current username
     * @param projName name of the project
     * @return String showing all tasks in a project
     */
    public String viewTasksInProj(String username, String projName) {
        return this.inputBoundary.viewTasksInProj(username, projName);
    }
}
