package driver.commands;

import controllers.QueryController;

/**
 * This class shows all projects of the user.
 */
public class ViewProj implements Command {
    /**
     * This function executes the viewProj command: show all projects for the user.
     *
     * @param username current username
     * @param args     a list of Strings with length 0, representing user arguments
     * @return a String indicating the all peojects have been successfully displayed.
     */
    @Override
    public String execute(String username, String[] args) throws Exception {
        if (args.length != 0) throw new Exception("Incorrect argument length!");
        return QueryController.getInstance().viewProjs(username);
    }
}
