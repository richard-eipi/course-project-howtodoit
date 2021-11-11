package entities;
import java.io.Serializable;
import java.util.HashMap;
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

    public Project getProject(String name) {
        return this.projects.getOrDefault(name, null);
    }

    public Team getTeam(String name) {
        return this.teams.getOrDefault(name, null);
    }

    public Task getTask(String name) {
        return this.tasks.getOrDefault(name, null);
    }

    public boolean addProject(Project project) {
        return this.projects.putIfAbsent(project.getName(), project) == null;
    }

    public boolean addTeam(Team team) {
        return this.teams.putIfAbsent(team.getName(), team) == null;
    }

    public boolean addTask(Task task) {
        task.getProject().addTask(task);
        return this.tasks.putIfAbsent(task.getName(), task) == null;
    }

    public void delProject(Project project) {
        this.projects.remove(project.getName());
    }

    public void delTeam(Team team) {
        this.teams.remove(team.getName());
    }

    public void delTask(Task task) {
        task.getProject().delTask(task);
        this.tasks.remove(task.getName());
    }
}