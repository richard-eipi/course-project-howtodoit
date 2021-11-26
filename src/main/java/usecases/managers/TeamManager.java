package usecases.managers;

import entities.Team;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;

/**
 * This class represents a list of teams.
 */
public class TeamManager implements TeamList, Serializable {
    /**
     * A collection of teams.
     */
    private final HashMap<String, Team> teams = new HashMap<>();

    /**
     * Checks whether this user is in the given team.
     *
     * @param name team name
     * @return true if has team
     */
    @Override
    public boolean hasTeam(String name) {
        return this.teams.containsKey(name);
    }

    /**
     * Return a team by name.
     *
     * @param name team name
     * @return the team
     */
    @Override
    public Team getTeam(String name) {
        return this.teams.getOrDefault(name, null);
    }

    /**
     * Let the user join this team.
     *
     * @param team the team object
     */
    @Override
    public void addTeam(Team team) {
        this.teams.putIfAbsent(team.getName(), team);
    }

    /**
     * Leave a team.
     *
     * @param team the team object
     */
    @Override
    public void delTeam(Team team) {
        this.teams.remove(team.getName());
    }

    /**
     * Return a String showing all team names.
     *
     * @return a String showing all team names
     */
    @Override
    public String toString() {
        Team[] teams = this.teams.values().toArray(new Team[0]);
        Arrays.sort(teams); // Sort them
        StringBuilder output = new StringBuilder("You are in the following teams:\n");
        for (Team team : teams) {
            output.append(team.getName()).append('\n'); // Each line will be a team
        }

        return output.toString();
    }
}
