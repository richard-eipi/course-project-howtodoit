package entities;

import java.io.Serializable;
import java.util.HashMap;

/**
 * This class represents a Team.
 * A team stores a collection of team members and team admins,
 */
public class Team implements Serializable {

    private String name;
    private final HashMap<String, User> members;
    private final HashMap<String, User> admins;

    /**
     * @param name name of the team
     */
    public Team(String name) {
        this.name = name;
        this.members = new HashMap<>();
        this.admins = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMem(String name) { return this.members.containsKey(name); }

    public boolean isAdmin(String name) {
        return this.admins.containsKey(name);
    }

    public User getMem(String name) { return this.members.getOrDefault(name, null); }

    public void addMem(User user) {
        this.members.putIfAbsent(user.getName(), user);
    }

    public void addAdmin(User user) {
        this.admins.putIfAbsent(user.getName(), user);
    }

    public void delMem(User user) {
        this.members.remove(user.getName());
        this.admins.remove(user.getName());
    }
}