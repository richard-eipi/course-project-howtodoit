package usecases;

import entities.Team;
import entities.User;

public class TeamUseCases implements TeamInputBoundary {
    private final UserList userList;

    public TeamUseCases(UserList userList) {
        this.userList = userList;
    }

    /**
     * Create a new team.
     *
     * @param username current username
     * @param teamName name of the team you want to create
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean newTeam(String username, String teamName) {
        User user = this.userList.getUser(username);
        Team team = new Team(teamName);
        team.addMem(user);
        team.addAdmin(user);
        return user.addTeam(team);
    }

    /**
     * Delete a team.
     *
     * @param username current username
     * @param teamName name of the team you want to delete
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean delTeam(String username, String teamName) {
        Team team = this.userList.getUser(username).getTeam(teamName);
        
        if (!team.isAdmin(username)) return false;

        for (User member : team) {
            member.delTeam(team);
        }
        return true;
    }

    /**
     * Change the name of a team.
     *
     * @param username current username
     * @param name1    name of the team you want to change
     * @param name2    the new name
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean modTeam(String username, String name1, String name2) {
        return false;
    }

    /**
     * Add a member to a team.
     *
     * @param username current username
     * @param teamName name of the team you want to add a member to
     * @param memName  name of the member you want to add to the team
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean addMem(String username, String teamName, String memName) {
        return false;
    }

    /**
     * Leave a team.
     *
     * @param username current username
     * @param teamName name of the team you want to leave
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean leaveTeam(String username, String teamName) {
        return false;
    }

    /**
     * Promote a member to admin.
     *
     * @param username current username
     * @param teamName name of the team
     * @param memName  name of the member you want to promote
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean addAdmin(String username, String teamName, String memName) {
        return false;
    }
}
