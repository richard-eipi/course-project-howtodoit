package todoSystem;
import java.util.HashMap;
/**
 * This class represents a User.
 */
public class User {
    protected String name;
    protected String password;
    private HashMap<String, Task> task;
    private HashMap<String, Project> project;
    private HashMap<String, Team> team;

    /**
     * Constructor for user with given name and password.
     * Generate empty map.
     * @param name the username
     * @param password password of the new user
     */
    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.task = new HashMap<>();
        this.project = new HashMap<>();
        this.team = new HashMap<>();
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

    public HashMap<String, Project> getProject() {
        return project;
    }

    public HashMap<String, Team> getTeam() {
        return team;
    }

    public HashMap<String, Task> getTask() {
        return task;
    }
}