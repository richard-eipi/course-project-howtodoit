package driver.commands;

import controllers.DataMemoryController;
/**
 * This class undoes an action performed by the user.
 */
public class Undo implements Command {
    /**
     * This function executes the undo command: undo an action.
     *
     * @param username current username
     * @param args a list of Strings with length 0, representing user arguments
     * @return a String indicating a new admin has been added successfully
     */
    @Override
    public String execute(String username, String[] args) throws Exception {
        if (args.length != 0) throw new Exception("Incorrect argument length!");
        return DataMemoryController.getInstance().undo(username);
    }
}
