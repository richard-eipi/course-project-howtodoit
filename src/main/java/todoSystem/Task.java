package todoSystem;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents a task, which has name, due date, description, project, and labels.
 */
public class Task implements Serializable {
    private String name;
    private String dueDate;
    private String description;
    private Project project;
    private boolean isStarred = false;

    public Task(String name, String dueDate, String description, Project project) {
        this.name = name;
        this.dueDate = dueDate;
        this.description = description;
        this.project = project;
        this.isStarred = false;
    }

    public String getName() {
        return this.name;
    }

    public String getDueDate() {
        return this.dueDate;
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

    /* @Override
    public String toString() {
        StringBuilder labelNames = new StringBuilder();
        for (Label label : this.labels) {
            labelNames.append(label.getName()).append(", ");
        }
        return this.name + ": due on " + this.dueDate + "; in project <" + this.project.getName() + "> with labels <"
                + labelNames + ">; description: "  + this.description;
    } */
}