package usecases;

import entities.Memento;
import entities.Team;
import entities.User;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;

/**
 * This class stores a collection of Users.
 */
public class UserList implements Serializable {
    private HashMap<String, User> users = new HashMap<>();

    public User getUser(String name) {
        return this.users.getOrDefault(name, null);
    }

    public void addUser(User user) {
        this.users.put(user.getName(), user);
    }

    /**
     * Create a timestamp of the current system, so we can restore it later.
     *
     * @return a memento object that stores the current state of the system
     */
    public Memento createMemento() {
        Memento memento = new Memento();
        memento.setState(this);
        return memento;
    }

    /**
     * Restore the state of the system.
     *
     * @param memento the object that stores the state of the system we want to return to
     */
    public void restore(Memento memento) {
        this.users = memento.getState();
    }

    /**
     * Copy the entire system of users.
     *
     * @return a copy of users
     */
    public HashMap<String, User> copy() {
        HashMap<String, User> userListCopy = new HashMap<>();
        HashMap<String, Team> visitedTeams = new HashMap<>();
        for (User user : this.users.values()) {
            User userCopy = user.copy();
            userListCopy.put(user.getName(), userCopy);
            copyTeams(visitedTeams, user, userCopy);
        }

        return userListCopy;
    }

    /**
     * Copy the teams each user is in.
     *
     * @param visitedTeams Already visited teams, do not want to add them twice
     * @param user         the user
     * @param userCopy     the clone of the user
     */
    private void copyTeams(HashMap<String, Team> visitedTeams, User user, User userCopy) {
        String[] teams = user.getTeams().split("\n");
        for (String teamName : Arrays.copyOfRange(teams, 1, teams.length)) {
            Team teamCopy = getTeamCopy(visitedTeams, teamName);
            userCopy.addTeam(teamCopy);
            teamCopy.addMem(userCopy);
            if (user.getTeam(teamName).isAdmin(user.getName())) teamCopy.addAdmin(userCopy);
        }
    }

    /**
     * Get the clone of a team from visitedTeams or create a new one.
     *
     * @param visitedTeams the collection of visited teams
     * @param teamName     name of the team
     * @return the cloned team
     */
    private Team getTeamCopy(HashMap<String, Team> visitedTeams, String teamName) {
        Team teamCopy;
        if (!visitedTeams.containsKey(teamName)) {
            teamCopy = new Team(teamName);
            visitedTeams.put(teamName, teamCopy);
        } else {
            teamCopy = visitedTeams.get(teamName);
        }
        return teamCopy;
    }
}
