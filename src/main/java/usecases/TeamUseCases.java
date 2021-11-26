package usecases;

import entities.Team;
import entities.User;
import usecases.managers.TeamList;
import usecases.managers.UserList;

/**
 * This class deals with team use cases.
 */
public class TeamUseCases implements TeamInputBoundary {
    /**
     * The list of users.
     */
    private final UserList userList;

    /**
     * Constructor.
     *
     * @param userList the list of users
     */
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
        TeamList teamList = user.getTeamList();

        if (teamList.hasTeam(teamName)) {
            return false; // team already exists
        } else {
            Team team = new Team(teamName);
            teamList.addTeam(team);
            team.addMem(user);
            team.addAdmin(user);
            return true;
        }
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
        User user = this.userList.getUser(username);
        TeamList teamList = user.getTeamList();
        Team team = teamList.getTeam(teamName);

        if (!teamList.hasTeam(teamName)) {
            return false; // teamName must exist
        } else if (!team.isAdmin(username)) {
            return false; // user must be an admin
        } else {
            for (User member : team) {
                member.getTeamList().delTeam(team);
            }
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
        User user = this.userList.getUser(username);
        TeamList teamList = user.getTeamList();
        Team team = teamList.getTeam(name1);

        if (!teamList.hasTeam(name1)) {
            return false; // user must have name1
        } else if (!team.isAdmin(username)) {
            return false; // user must be an admin
        } else if (checkRepetitiveTeam(team, name2)) {
            return false; // for any user that has name1, they don't have name2
        } else {
            team.setName(name2);
            return true;
        }
    }

    /**
     * Helper method of modTeam.
     * Checking if any team member has another team which has the new name
     *
     * @param team  current team
     * @param name2 new name of the team
     * @return boolean indicating whether a duplicate team exists
     */
    private boolean checkRepetitiveTeam(Team team, String name2) {
        for (User member : team) {
            if (member.getTeamList().hasTeam(name2)) return true;
        }
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
        User user = this.userList.getUser(username);
        User member = this.userList.getUser(memName);
        Team team = user.getTeamList().getTeam(teamName);

        if (!user.getTeamList().hasTeam(teamName)) {
            return false; // user must have teamName
        } else if (!team.isAdmin(username)) {
            return false; // user must be an admin
        } else if (member.getTeamList().hasTeam(teamName)) {
            return false; // member must not already have teamName
        } else {
            team.addMem(member);
            member.getTeamList().addTeam(team);
            return true;
        }
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
        User user = this.userList.getUser(username);
        TeamList teamList = user.getTeamList();
        Team team = teamList.getTeam(teamName);

        if (!teamList.hasTeam(teamName)) {
            return false; // user must have teamName in order to leave
        } else {
            team.delMem(user);
            teamList.delTeam(team);
            return true;
        }
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
        User user = this.userList.getUser(username);
        User member = this.userList.getUser(memName);
        Team team = user.getTeamList().getTeam(teamName);

        if (!user.getTeamList().hasTeam(teamName)) {
            return false; // user must have teamName
        } else if (!team.isAdmin(username)) {
            return false; // user must be an admin
        } else if (!member.getTeamList().hasTeam(teamName)) {
            return false; // member must have teamName
        } else {
            team.addAdmin(member);
            return true;
        }
    }
}
