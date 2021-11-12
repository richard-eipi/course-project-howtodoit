package driver.commands;

import controllers.TaskController;

/**
 * This class stars a task.
 */
public class Star implements Command {
    /**
     * This function executes the star command: Add a task called <name> to Starred label
     * The task must already exist in the system.
     *
     * @param username current username
     * @param args     a list of Strings with length 1, representing user arguments
     * @return a String indicating a task has been added to Starred label
     */
    @Override
    public String execute(String username, String[] args) throws Exception {
        if (args.length != 1) throw new Exception("Incorrect argument length!");
        return TaskController.getInstance().star(username, args[0]);
    }
}
