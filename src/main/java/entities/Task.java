package entities;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * This class represents a task, which has name, due date, description, project, and labels.
 */
public class Task implements Serializable, Comparable<Task> {
    private String name;
    private String dueDate;
    private String description;
    private final Project project;
    private boolean isStarred;

    public Task(String name, String dueDate, Project project) {
        this.name = name;
        this.dueDate = dueDate;
        this.project = project;
        this.description = "";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getProject() {
        return project;
    }

    public boolean getIsStarred() {
        return this.isStarred;
    }

    public void setStarred(boolean starred) {
        this.isStarred = starred;
    }

    @Override
    public String toString() {
        String star = this.isStarred ? "*STARRED* " : "";
        return star + this.name + ": due on " + this.dueDate + "; in project <" + this.project.getName() + ">; description: " + this.description;
    }

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