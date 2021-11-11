package driver.commands;

import controllers.DataMemoryController;
/**
 * This class redoes an action performed by the user.
 */
public class Redo implements Command {
    /**
     * This function executes the redo command: redo an action.
     *
     * @param username current username
     * @param args a list of Strings with length 0, representing user arguments
     * @return a String indicating a new admin has been added successfully
     */
    @Override
    public String execute(String username, String[] args) throws Exception {
        if (args.length != 0) throw new Exception("Incorrect argument length!");
        return DataMemoryController.getInstance().redo(username);
    }
}
