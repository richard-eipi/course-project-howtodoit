package entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 * This class represents a Team.
 * A team stores a collection of team members and team admins,
 */
public class Team implements Serializable, Iterable<User>, Comparable<Team> {

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

    @Override
    public String toString() {
        User[] members = this.members.values().toArray(new User[0]);
        Arrays.sort(members); // Sort them
        StringBuilder output = new StringBuilder("This team <" + this.name + "> consists of the following members:\n");
        for (User user: members) {
            String admin = this.isAdmin(user.getName()) ? "*ADMIN* " : "";
            output.append(admin).append(user.getName()).append('\n'); // Each line will be a member
        }
        return output.toString();
    }

    @Override
    public Iterator<User> iterator() {
        return this.members.values().iterator();
    }

    @Override
    public int compareTo(Team o) {
        return this.name.compareToIgnoreCase(o.getName());
    }
}