package entities;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * This class represents a task.
 */
public class Task implements Serializable, Comparable<Task> {
    /**
     * Task name.
     */
    private String name;
    /**
     * Task due date.
     */
    private String dueDate;
    /**
     * Task description.
     */
    private String description;
    /**
     * The project this task is stored in.
     */
    private final Project project;
    /**
     * Whether this task is starred.
     */
    private boolean isStarred;

    /**
     * Create a task with given name, due date, and project.
     *
     * @param name    task name
     * @param dueDate task due date
     * @param project project that stores this task
     */
    public Task(String name, String dueDate, Project project) {
        this.name = name;
        this.dueDate = dueDate;
        this.project = project;
        this.description = "";
    }

    /**
     * Return the name of the task.
     *
     * @return task name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the task
     *
     * @param name task name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the due date of the task.
     *
     * @return task due date
     */
    public String getDueDate() {
        return this.dueDate;
    }

    /**
     * Sets the due date of the task
     *
     * @param dueDate task due date
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Return the description of the task.
     *
     * @return task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the task
     *
     * @param description task description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Return the project that stores this task.
     *
     * @return the project that stores this task
     */
    public Project getProject() {
        return project;
    }

    /**
     * Return whether this task is starred.
     *
     * @return true if starred
     */
    public boolean isStarred() {
        return this.isStarred;
    }

    /**
     * Sets whether this task is starred.
     *
     * @param starred true if we want to star it, false otherwise
     */
    public void setStarred(boolean starred) {
        this.isStarred = starred;
    }

    /**
     * Return a String representation of this task.
     *
     * @return task information
     */
    @Override
    public String toString() {
        String star = this.isStarred ? "*STARRED* " : "";
        return star + this.name + ": due on " + this.dueDate + "; in project <" + this.project.getName() + ">; description: " + this.description;
    }

    /**
     * Lets this task be compared to another task based on due date.
     *
     * @param o another task
     * @return negative number for <, positive number for >, 0 for =
     */
    @Override
    public int compareTo(Task o) {
        LocalDate thisDueDate = LocalDate.parse(this.dueDate);
        LocalDate otherDueDate = LocalDate.parse(o.getDueDate());
        if (thisDueDate.isBefore(otherDueDate)) {
            return -1;
        } else if (otherDueDate.isBefore(thisDueDate)) {
            return 1;
        } else {
            return 0;
        }

    }
}