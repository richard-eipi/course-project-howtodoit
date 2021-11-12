package driver.commands;

import controllers.TeamController;

/**
 * This class adds a new admin to a team.
 */
public class AddAdmin implements Command {
    /**
     * This function executes the addAdmin command: promote the user called <username> to an admin of the team
     * A     * called <team name>.
     * Only admins of the team can perform this action.
     *
     * @param username current username
     * @param args     a list of Strings with length 2, representing user arguments
     * @return a String indicating a new admin has been added successfully
     */
    @Override
    public String execute(String username, String[] args) throws Exception {
        if (args.length != 2) throw new Exception("Incorrect argument length!");
        return TeamController.getInstance().addAdmin(username, args[0], args[1]);
    }

}
