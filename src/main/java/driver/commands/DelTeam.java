package driver.commands;

import controllers.TeamController;

/**
 * This class deletes a team.
 */
public class DelTeam implements Command {
    /**
     * This function executes the DelTeam command: Delete the team called <name>.
     *
     * @param username current username
     * @param args     a list of Strings with length 1, representing user arguments
     * @return a String indicating a team has been deleted successfully
     */
    @Override
    public String execute(String username, String[] args) throws Exception {
        if (args.length != 1) throw new Exception("Incorrect argument length!");
        return TeamController.getInstance().delTeam(username, args[0]);
    }
}