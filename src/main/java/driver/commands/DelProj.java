package driver.commands;

import controllers.ProjectController;

/**
 * This class deletes a project.
 */
public class DelProj implements Command {
    /**
     * This function executes the DelProj command: Delete the project called <name> and delete all its tasks.
     *
     * @param username current username
     * @param args     a list of Strings with length 1, representing user arguments
     * @return a String indicating a project has been deleted successfully
     */
    @Override
    public String execute(String username, String[] args) throws Exception {
        if (args.length != 1) throw new Exception("Incorrect argument length!");
        return ProjectController.getInstance().delProj(username, args[0]);
    }
}