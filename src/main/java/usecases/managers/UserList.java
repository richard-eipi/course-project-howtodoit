package usecases.managers;

import entities.Memento;
import entities.Team;
import entities.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * This class represents a list of users.
 */
public class UserList implements Serializable {
    /**
     * A collection of users.
     */
    private List<User> users = new ArrayList<>();

    /**
     * Return a user by username.
     *
     * @param name username
     * @return the user
     */
    public User getUser(String name) {
        for (User user : this.users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Add a user to the list.
     *
     * @param user the user object
     */
    public void addUser(User user) {
        if (this.getUser(user.getName()) == null) {
            this.users.add(user);
        }
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
    public List<User> copy() {
        List<User> userListCopy = new ArrayList<>();
        HashMap<String, Team> visitedTeams = new HashMap<>();
        for (User user : this.users) {
            User userCopy = user.copy(new TaskManager(), new ProjectManager(), new TeamManager());
            userListCopy.add(userCopy);
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
        String[] teams = user.getTeamList().toString().split("\n");
        for (String teamName : Arrays.copyOfRange(teams, 1, teams.length)) {
            Team teamCopy = getTeamCopy(visitedTeams, teamName);
            userCopy.getTeamList().addTeam(teamCopy);
            teamCopy.addMem(userCopy);
            if (user.getTeamList().getTeam(teamName).isAdmin(user.getName())) teamCopy.addAdmin(userCopy);
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
