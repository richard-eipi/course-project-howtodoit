package driver.commands;

import controllers.TaskController;

/**
 * This class unstars a task.
 */
public class Unstar implements Command {
    /**
     * This function executes the unstar command: Unstar a task called <name>
     * The task must already exist in the system.
     *
     * @param username current username
     * @param args     a list of Strings with length 1, representing user arguments
     * @return a String indicating a task has been added to Starred label
     */
    @Override
    public String execute(String username, String[] args) throws Exception {
        if (args.length != 1) throw new Exception("Incorrect argument length!");
        return TaskController.getInstance().unstar(username, args[0]);
    }
}