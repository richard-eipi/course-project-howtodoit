package usecases.managers;

import entities.Project;
import entities.Task;

import java.io.Serializable;
import java.util.*;

/**
 * This class represents a list of projects.
 */
public class ProjectManager implements ProjectList, Serializable {
    /**
     * A collection of projects.
     */
    private final List<Project> projects = new ArrayList<>();

    /**
     * Checks whether this user has the given project.
     *
     * @param name project name
     * @return true if has project
     */
    @Override
    public boolean hasProject(String name) {
        for (Project project : this.projects) {
            if (project.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return a project by name.
     *
     * @param name project name
     * @return the project
     */
    @Override
    public Project getProject(String name) {
        for (Project project : this.projects) {
            if (project.getName().equals(name)) {
                return project;
            }
        }
        return null;
    }

    /**
     * Let the user have this project.
     *
     * @param project the project object
     */
    @Override
    public void addProject(Project project) {
        if (!this.hasProject(project.getName())) {
            this.projects.add(project);
        }
    }

    /**
     * Remove a project.
     *
     * @param project the project object
     */
    @Override
    public void delProject(Project project) {
        this.projects.remove(project);
    }

    /**
     * Return a String showing all project names.
     *
     * @return a String showing all project names
     */
    @Override
    public String toString() {
        Collections.sort(projects);
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
        return this.projects.iterator();
    }
}
