package driver.commands;

import controllers.UserAccountController;

/**
 * This class modifies the name of a user.
 */
public class ModUsn implements Command {
    /**
     * This function executes the modUsn command: modify the username from its current name to <name>.
     *
     * @param username current username
     * @param args a list of Strings with length 1, representing user arguments
     * @return a String indicating a username has been changed
     */
    @Override
    public String execute(String username, String[] args) throws Exception{
        if (args.length != 1) throw new Exception("Incorrect argument length!");
        return UserAccountController.getInstance().modUsn(username, args[0]);
    }
}
