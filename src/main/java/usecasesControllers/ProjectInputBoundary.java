package usecasesControllers;

public interface ProjectInputBoundary {
    /**
     * Create a new project.
     * @param username current username
     * @param projName name of the new project you want to create
     * @param teamName name of the team this project belongs to, leave as "" if personal project
     * @return boolean indicating whether success or failure
     */
    boolean newProj(String username, String projName, String teamName);

    /**
     * Delete a project; if personal, move all its tasks to the "General" project, otherwise delete all tasks.
     * @param username current username
     * @param projName name of the project you want to delete
     * @return boolean indicating whether success or failure
     */
    boolean delProj(String username, String projName);

    /**
     * Change the name of a project.
     * @param username current username
     * @param name1 name of the project you want to change
     * @param name2 the new name
     * @return boolean indicating whether success or failure
     */
    boolean modProj(String username, String name1, String name2);
}
