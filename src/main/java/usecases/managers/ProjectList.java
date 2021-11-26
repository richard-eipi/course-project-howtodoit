package usecases.managers;

import entities.Project;


/**
 * This interface represents a list of projects.
 */
public interface ProjectList extends Iterable<Project> {
    /**
     * Checks whether this user has the given project.
     *
     * @param name project name
     * @return true if has project
     */
    boolean hasProject(String name);

    /**
     * Return a project by name.
     *
     * @param name project name
     * @return the project
     */
    Project getProject(String name);

    /**
     * Let the user have this project.
     *
     * @param project the project object
     */
    void addProject(Project project);

    /**
     * Remove a project.
     *
     * @param project the project object
     */
    void delProject(Project project);
}
