package commands;

import usecasesControllers.TeamController;

/**
 * This class adds a new member to a team.
 */
public class AddMem implements Command {
    /**
     * This function executes the addMem command: add a user called <username> to the team called <teamname>.
     * Only admins of the team can perform this action.
     *
     * @param username current username
     * @param args a list of Strings with length 2, representing user arguments
     * @return a String indicating a new member has been added successfully
     */
    @Override
    public String execute(String username, String[] args) throws Exception {
        if (args.length != 2) throw new Exception("Incorrect argument length!");
        return TeamController.getInstance().addMem(username, args[0], args[1]);
    }
}
