package driver.commands;

import controllers.UserAccountController;

/**
 * This class modifies a password.
 */
public class ModPwd implements Command {
    /**
     * This function executes the modUsn command: modify the password from <pw1> to <pw2>.
     *
     * @param username current username
     * @param args     a list of Strings with length 2, representing user arguments
     * @return a String indicating a password has been changed
     */
    @Override
    public String execute(String username, String[] args) throws Exception {
        if (args.length != 2) throw new Exception("Incorrect argument length!");
        return UserAccountController.getInstance().modPwd(username, args[0], args[1]);
    }
}
