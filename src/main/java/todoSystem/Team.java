package todoSystem;

import java.util.HashMap;

/**
 * This class represents a Team.
 * A team stores a collection of team members and team admins,
 */
public class Team {

    private String name;
    private HashMap<String, User> members;
    private HashMap<String, User> admin;

    public Team(String name) {
        this.name = name;
        this.members = new HashMap<>();
        this.admin = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, User> getMembers() {
        return members;
    }

    public HashMap<String, User> getAdmin() {
        return admin;
    }

    public boolean isAdmin(String name) {
        return this.admin.containsKey(name);
    }
}