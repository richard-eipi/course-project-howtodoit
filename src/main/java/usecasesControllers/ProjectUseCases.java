package usecasesControllers;

public class ProjectUseCases implements ProjectInputBoundary {
    private final UserList userList;

    public ProjectUseCases(UserList userList) {
        this.userList = userList;
    }

    /**
     * Create a new project.
     * @param username current username
     * @param projName name of the new project you want to create
     * @param teamName name of the team this project belongs to, leave as "" if personal project
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean newProj(String username, String projName, String teamName) {
        return false;
    }

    /**
     * Delete a project, move all its tasks to "General".
     * @param username current username
     * @param projName name of the project you want to delete
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean delProj(String username, String projName) {
        return false;
    }

    /**
     * Change the name of a project.
     * @param username current username
     * @param name1 name of the project you want to change
     * @param name2 the new name
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean modProj(String username, String name1, String name2) {
        return false;
    }
}
