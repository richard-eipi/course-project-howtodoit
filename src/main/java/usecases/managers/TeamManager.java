package usecases.managers;

import entities.Team;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class represents a list of teams.
 */
public class TeamManager implements TeamList, Serializable {
    /**
     * A collection of teams.
     */
    private final List<Team> teams = new ArrayList<>();

    /**
     * Checks whether this user is in the given team.
     *
     * @param name team name
     * @return true if the hashmap has teams
     */
    @Override
    public boolean hasTeam(String name) {
        for (Team team : this.teams) {
            if (team.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return a team by name.
     *
     * @param name team name
     * @return the team
     */
    @Override
    public Team getTeam(String name) {
        for (Team team : this.teams) {
            if (team.getName().equals(name)) {
                return team;
            }
        }
        return null;
    }

    /**
     * Let the user join this team.
     *
     * @param team the team object
     */
    @Override
    public void addTeam(Team team) {
        if (!this.hasTeam(team.getName())) {
            this.teams.add(team);
        }
    }

    /**
     * Leave a team.
     *
     * @param team the team object
     */
    @Override
    public void delTeam(Team team) {
        this.teams.remove(team);
    }

    /**
     * Return a String showing all team names.
     *
     * @return a String showing all team names
     */
    @Override
    public String toString() {
        Collections.sort(teams);
        StringBuilder output = new StringBuilder("You are in the following teams:\n");
        for (Team team : teams) {
            output.append(team.getName()).append('\n'); // Each line will be a team
        }

        return output.toString();
    }
}
