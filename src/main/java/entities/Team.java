package entities;

import java.io.Serializable;
import java.util.*;

/**
 * This class represents a Team.
 * A team stores a collection of team members and team admins.
 */
public class Team implements Serializable, Iterable<User>, Comparable<Team> {
    /**
     * A collection of members.
     */
    private final List<User> members;
    /**
     * A collection of admins.
     */
    private final List<User> admins;
    /**
     * Team name.
     */
    private String name;

    /**
     * Create a team with given name.
     *
     * @param name name of the team
     */
    public Team(String name) {
        this.name = name;
        this.members = new ArrayList<>();
        this.admins = new ArrayList<>();
    }

    /**
     * Return the name of the team.
     *
     * @return team name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the team.
     *
     * @param name team name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return whether the given user is a member.
     *
     * @param name username
     * @return whether the given user is a member
     */
    public boolean isMem(String name) {
        for (User mem : this.members) {
            if (mem.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return whether the given user is an admin.
     *
     * @param name username
     * @return whether the given user is an admin
     */
    public boolean isAdmin(String name) {
        for (User mem : this.admins) {
            if (mem.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return a member by name.
     *
     * @param name username
     * @return the member
     */
    public User getMem(String name) {
        for (User mem : this.members) {
            if (mem.getName().equals(name)) {
                return mem;
            }
        }
        return null;
    }

    /**
     * Let the given user become a member.
     *
     * @param user the user object
     */
    public void addMem(User user) {
        if (!this.isMem(user.getName())) {
            this.members.add(user);
        }
    }

    /**
     * Let the given user become an admin.
     * They must already be a member.
     *
     * @param user the user object
     */
    public void addAdmin(User user) {
        if (!this.isAdmin(user.getName())) {
            this.admins.add(user);
        }
    }

    /**
     * Remove a user from the collection of members.
     *
     * @param user the user object
     */
    public void delMem(User user) {
        this.members.remove(user);
        this.admins.remove(user);
    }

    /**
     * Return a String representation of this team.
     *
     * @return team name and all its members
     */
    @Override
    public String toString() {
        Collections.sort(members);
        StringBuilder output = new StringBuilder("This team <" + this.name + "> consists of the following members:\n");
        for (User user : members) {
            String admin = this.isAdmin(user.getName()) ? "*ADMIN* " : "";
            output.append(admin).append(user.getName()).append('\n'); // Each line will be a member
        }
        return output.toString();
    }

    /**
     * Return an Iterator object required by the Iterator Design Pattern.
     *
     * @return an Iterator object
     */
    @Override
    public Iterator<User> iterator() {
        return this.members.iterator();
    }

    /**
     * Let this team be compared to another team based on team name.
     *
     * @param o another team
     * @return negative number for <, positive number for >, 0 for =
     */
    @Override
    public int compareTo(Team o) {
        return this.name.compareToIgnoreCase(o.getName());
    }
}