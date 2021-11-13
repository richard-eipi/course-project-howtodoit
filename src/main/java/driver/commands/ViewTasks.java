package driver.commands;

import controllers.QueryController;
/**
 * This class shows all tasks of the user with specific order.
 */
public class ViewTasks implements Command {

    /**
     * This function executes the viewTasks command: show all upcoming tasks in all projects in chronological order
     * for the user; starred tasks will have stars in front of them.
     *
     * @param username current username
     * @param args     a list of Strings with length 0, representing user arguments
     * @return a String indicating all tasks have been successfully displayed.
     */
    @Override
    public String execute(String username, String[] args) throws Exception {
        if (args.length != 0) throw new Exception("Incorrect argument length!");
        return QueryController.getInstance().viewTasks(username);
    }
}
