package todoSystem;

import java.util.HashMap;
/**
 * This class represents a project.
 * A project stores a collection of tasks, but those tasks must be in exactly one project.
 */
public class Project {
    private String name;
    private HashMap<String, Task> task;
    private String team;

    public Project(String name, String teamName) {
        this.name = name;
        this.task = new HashMap<>();
        this.team = teamName;
    }

    public String getName() {
        return this.name;
    }

    public HashMap<String, Task> getTaskList() {
        return this.task;
    }

    public Task getTask(String name) {
        return this.task.get(name);
    }

    public String getTeam(String name) {
        return this.team;
    }

    public void setName(String name) {
        this.name = name;
    }
}