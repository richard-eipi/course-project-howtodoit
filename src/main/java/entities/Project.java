package entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 * This class represents a project.
 * A project stores a collection of tasks, but those tasks must be in exactly one project.
 */
public class Project implements Serializable, Iterable<Task>, Comparable<Project> {
    /**
     * The collection of tasks.
     */
    private final HashMap<String, Task> tasks;
    /**
     * Project name.
     */
    private String name;

    /**
     * Create a personal project with given name
     *
     * @param name project name
     */
    public Project(String name) {
        this.name = name;
        this.tasks = new HashMap<>();
    }

    /**
     * Return the name of the project.
     *
     * @return project name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the project
     *
     * @param name project name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Checks if this project has the given task.
     *
     * @param name task name
     * @return true if has task
     */
    public boolean hasTask(String name) {
        return this.tasks.containsKey(name);
    }

    /**
     * Adds a task to this project.
     *
     * @param task the task object
     */
    public void addTask(Task task) {
        this.tasks.putIfAbsent(task.getName(), task);
    }

    /**
     * Delete a task from this project.
     *
     * @param task the task object
     */
    public void delTask(Task task) {
        this.tasks.remove(task.getName());
    }

    /**
     * Return a String representation of this project.
     *
     * @return project name and all its tasks
     */
    @Override
    public String toString() {
        Task[] tasks = this.tasks.values().toArray(new Task[0]);
        Arrays.sort(tasks); // Sort them
        StringBuilder output = new StringBuilder("This project <" + this.name + "> contains the following tasks:\n");
        for (Task task : tasks) {
            output.append(task.toString()).append('\n'); // Each line will be a task
        }

        return output.toString();
    }

    /**
     * Return an Iterator object required by the Iterator Design Pattern.
     *
     * @return an Iterator object
     */
    @Override
    public Iterator<Task> iterator() {
        return this.tasks.values().iterator();
    }

    /**
     * Let this project be compared to another project based on project name.
     *
     * @param o another project
     * @return negative number for <, positive number for >, 0 for =
     */
    @Override
    public int compareTo(Project o) {
        return this.name.compareToIgnoreCase(o.getName());
    }
}