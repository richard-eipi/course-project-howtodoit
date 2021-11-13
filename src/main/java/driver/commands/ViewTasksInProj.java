package driver.commands;

import controllers.QueryController;
/**
 * This class shows all tasks of one particular project to the user.
 */
public class ViewTasksInProj implements Command {

    /**
     * This function executes the viewTasksInProj command: show all tasks in the project called <name>.
     *
     * @param username current username
     * @param args     a list of Strings with length 1, representing user arguments
     * @return a String indicating all tasks have been successfully displayed.
     */
    @Override
    public String execute(String username, String[] args) throws Exception {
        if (args.length != 1) throw new Exception("Incorrect argument length!");
        return QueryController.getInstance().viewTasksInProj(username, args[0]);
    }
}
