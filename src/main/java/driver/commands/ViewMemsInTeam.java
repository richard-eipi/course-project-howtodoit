package driver.commands;

import controllers.QueryController;

/**
 * This class shows all members in a team
 */
public class ViewMemsInTeam implements Command {

    /**
     * This function executes the viewMemsIn command: show all members in the team called <name>.
     *
     * @param username current username
     * @param args     a list of Strings with length 1, representing user arguments
     * @return a String indicating all members have been successfully displayed.
     */
    @Override
    public String execute(String username, String[] args) throws Exception {
        if (args.length != 1) throw new Exception("Incorrect argument length!");
        return QueryController.getInstance().viewMemsInTeam(username, args[0]);
    }
}
