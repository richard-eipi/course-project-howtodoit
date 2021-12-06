package usecases.managers;

import entities.Team;

/**
 * This interface represents a list of teams.
 */
public interface TeamList {
    /**
     * Checks whether this user is in the given team.
     *
     * @param name team name
     * @return true if the team list has teams
     */
    boolean hasTeam(String name);

    /**
     * Return a team by name.
     *
     * @param name team name
     * @return the team
     */
    Team getTeam(String name);

    /**
     * Let the user join this team.
     *
     * @param team the team object
     */
    void addTeam(Team team);

    /**
     * Leave a team.
     *
     * @param team the team object
     */
    void delTeam(Team team);
}
