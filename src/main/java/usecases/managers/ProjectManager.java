package usecases.managers;

import entities.Project;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 * This class represents a list of projects.
 */
public class ProjectManager implements ProjectList, Serializable {
    /**
     * A collection of projects.
     */
    private final HashMap<String, Project> projects = new HashMap<>();

    /**
     * Checks whether this user has the given project.
     *
     * @param name project name
     * @return true if has project
     */
    @Override
    public boolean hasProject(String name) {
        return this.projects.containsKey(name);
    }

    /**
     * Return a project by name.
     *
     * @param name project name
     * @return the project
     */
    @Override
    public Project getProject(String name) {
        return this.projects.getOrDefault(name, null);
    }

    /**
     * Let the user have this project.
     *
     * @param project the project object
     */
    @Override
    public void addProject(Project project) {
        this.projects.putIfAbsent(project.getName(), project);
    }

    /**
     * Remove a project.
     *
     * @param project the project object
     */
    @Override
    public void delProject(Project project) {
        this.projects.remove(project.getName());
    }

    /**
     * Return a String showing all project names.
     *
     * @return a String showing all project names
     */
    @Override
    public String toString() {
        Project[] projects = this.projects.values().toArray(new Project[0]);
        Arrays.sort(projects); // Sort them
        StringBuilder output = new StringBuilder("You have the following projects:\n");
        for (Project project : projects) {
            output.append(project.getName()).append('\n'); // Each line will be a task
        }

        return output.toString();
    }

    /**
     * Return an Iterator object required by the Iterator Design Pattern.
     *
     * @return an Iterator object
     */
    @Override
    public Iterator<Project> iterator() {
        return this.projects.values().iterator();
    }
}
