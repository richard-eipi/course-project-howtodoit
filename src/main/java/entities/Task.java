package entities;

import java.io.Serializable;

/**
 * This class represents a task, which has name, due date, description, project, and labels.
 */
public class Task implements Serializable {
    private String name;
    private String dueDate;
    private String description;
    private Project project;
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

    public String getDueDate() {
        return this.dueDate;
    }

    public String getDescription() {
        return description;
    }

    public Project getProject() {
        return project;
    }

    public boolean getStarred() {
        return this.isStarred;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setStarred(boolean starred) {
        this.isStarred = starred;
    }

    @Override
    public String toString() {
        String star = this.isStarred ? "*STARRED* " : "";
        return star + this.name + ": due on " + this.dueDate + "; in project <" + this.project.getName() + ">; description: "  + this.description;
    }
}