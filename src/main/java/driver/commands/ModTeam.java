package driver.commands;

import controllers.TeamController;

/**
 * This class modifies a team name
 */
public class ModTeam implements Command {
    /**
     * This function executes the modTeam command: rename the team from <name1> to <name2>.
     * Only admins of the team can perform this action.
     *
     * @param username current username
     * @param args     a list of Strings with length 2, representing user arguments
     * @return a String indicating a new team has been renamed successfully
     */
    @Override
    public String execute(String username, String[] args) throws Exception {
        if (args.length != 2) throw new Exception("Incorrect argument length!");
        return TeamController.getInstance().modTeam(username, args[0], args[1]);
    }

}
