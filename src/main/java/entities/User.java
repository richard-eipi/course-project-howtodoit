package entities;
import helpers.SortTasksChronologically;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * This class represents a User.
 */
public class User implements Serializable {
    protected String name;
    protected String password;
    private final HashMap<String, Task> tasks;
    private final HashMap<String, Project> projects;
    private final HashMap<String, Team> teams;

    /**
     * Constructor for user with given name and password.
     * Generate empty map.
     * @param name the username
     * @param password password of the new user
     */
    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.tasks = new HashMap<>();
        this.projects = new HashMap<>();
        this.teams = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean passwordMatches(String password) {
        return this.password.equals(password);
    }

    public boolean hasProject(String name) { return this.projects.containsKey(name); }

    public boolean hasTeam(String name) { return this.teams.containsKey(name); }

    public boolean hasTask(String name) { return this.tasks.containsKey(name); }

    public Project getProject(String name) {
        return this.projects.getOrDefault(name, null);
    }

    public Team getTeam(String name) {
        return this.teams.getOrDefault(name, null);
    }

    public Task getTask(String name) {
        return this.tasks.getOrDefault(name, null);
    }

    public void addProject(Project project) {
        this.projects.putIfAbsent(project.getName(), project);
    }

    public void addTeam(Team team) {
        this.teams.putIfAbsent(team.getName(), team);
    }

    public void addTask(Task task) {
        this.tasks.putIfAbsent(task.getName(), task);
    }

    public void delProject(Project project) {
        this.projects.remove(project.getName());
    }

    public void delTeam(Team team) {
        this.teams.remove(team.getName());
    }

    public void delTask(Task task) {
        this.tasks.remove(task.getName());
    }

    public String getProjects() {
        StringBuilder output = new StringBuilder("You have the following projects:\n");
        for (Project project: this.projects.values()) {
            output.append(project.getName()).append('\n'); // Each line will be a task
        }

        return output.toString();
    }

    public String getTeams() {
        StringBuilder output = new StringBuilder("You are in the following teams:\n");
        for (Team team: this.teams.values()) {
            output.append(team.getName()).append('\n'); // Each line will be a team
        }

        return output.toString();
    }

    public String getTasks() {
        List<Task> sortedTasks = SortTasksChronologically.sortTasks(this.tasks); // Sort them
        StringBuilder output = new StringBuilder("You have the following upcoming tasks:\n");
        for (Task task: sortedTasks) {
            output.append(task.toString()).append('\n'); // Each line will be a project
        }

        return output.toString();
    }
}