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

        if (user.hasTeam(teamName)) {
            return false; // team already exists
        } else {
            Team team = new Team(teamName);
            user.addTeam(team);
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
        Team team = user.getTeam(teamName);
        if (!user.hasTeam(teamName)) {
            return false; // teamName must exist
        } else if (!team.isAdmin(username)) {
            return false; // user must be an admin
        } else {
            for (User member : team) {
                member.delTeam(team);
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
        Team team = user.getTeam(name1);
        if (!user.hasTeam(name1)) {
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
            if (member.hasTeam(name2)) return true;
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
        Team team = user.getTeam(teamName);

        if (!user.hasTeam(teamName)) {
            return false; // user must have teamName
        } else if (!team.isAdmin(username)) {
            return false; // user must be an admin
        } else if (member.hasTeam(teamName)) {
            return false; // member must not already have teamName
        } else {
            team.addMem(member);
            member.addTeam(team);
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
        Team team = user.getTeam(teamName);
        if (!user.hasTeam(teamName)) {
            return false; // user must have teamName in order to leave
        } else {
            team.delMem(user);
            user.delTeam(team);
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
        Team team = user.getTeam(teamName);

        if (!user.hasTeam(teamName)) {
            return false; // user must have teamName
        } else if (!team.isAdmin(username)) {
            return false; // user must be an admin
        } else if (!member.hasTeam(teamName)) {
            return false; // member must have teamName
        } else {
            team.addAdmin(member);
            return true;
        }
    }
}
