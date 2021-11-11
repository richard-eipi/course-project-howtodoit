package driver.commands;

import controllers.TeamController;

/**
 * This class allows the current user to leave team.
 */
public class LeaveTeam implements Command {
    /**
     * This function executes the leaveTeam command: remove the current user from the team <team name>.
     *
     * @param username current username
     * @param args a list of Strings with length 1, representing user arguments
     * @return a String indicating current user had been removed successfully
     */
    @Override
    public String execute(String username, String[] args) throws Exception {
        if (args.length != 1) throw new Exception("Incorrect argument length!");
        return TeamController.getInstance().leaveTeam(username, args[0]);
    }
}
