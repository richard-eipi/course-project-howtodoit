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

    public HashMap<String, Project> getProjects() {
        return this.projects;
    }

    public HashMap<String, Team> getTeams() {
        return this.teams;
    }

    public HashMap<String, Task> getTasks() {
        return this.tasks;
    }
}