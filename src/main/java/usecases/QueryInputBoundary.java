package usecases;

public interface QueryInputBoundary {
    /**
     * Show all teams that the user is in.
     * @param username current username
     * @return String showing all teams that the user is in
     */
    String viewTeams(String username);

    /**
     * Show all members in a team.
     * @param username current username
     * @param teamName name of the team
     * @return String showing all members in a team
     */
    String viewMemsIn(String username, String teamName);

    /**
     * Show all projects for the user.
     * @param username current username
     * @return String showing all projects for the user
     */
    String viewProjs(String username);

    /**
     * Show all tasks for the user.
     * @param username current username
     * @return String showing all tasks for the user
     */
    String viewTasks(String username);

    /**
     * Show all tasks in a project.
     * @param username current username
     * @param projName name of the project
     * @return String showing all tasks in a project
     */
    String viewTasksInProj(String username, String projName);
}
