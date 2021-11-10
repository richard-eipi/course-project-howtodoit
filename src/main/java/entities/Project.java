package entities;

import java.util.HashMap;
/**
 * This class represents a project.
 * A project stores a collection of tasks, but those tasks must be in exactly one project.
 */
public class Project {

    private String name;
    private final HashMap<String, Task> tasks = new HashMap<>();
    private Team team;

    /**
     * Create a team project with project name and team.
     */
    public Project(String name, Team team) {
        this.name = name;
        this.team = team;
    }

    /**
    * Create a personal project with name only
    */
    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Task> getTasks() {
        return this.tasks;
    }

    public Task getTask(String name) {
        return this.tasks.get(name);
    }

    public Team getTeam() {
        return this.team;
    }
}