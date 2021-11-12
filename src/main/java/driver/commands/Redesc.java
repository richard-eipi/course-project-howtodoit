package driver.commands;

import controllers.TaskController;

/**
 * This class updates the description of a task.
 */
public class Redesc implements Command {

    /**
     * This function executes the redesc command: change the description of a task
     * The task must already exist in the system.
     *
     * @param username current username
     * @param args     a list of Strings with length 2, representing user arguments
     * @return a String indicating a task's description has been updated
     */
    @Override
    public String execute(String username, String[] args) throws Exception {
        if (args.length != 2) throw new Exception("Incorrect argument length!");
        return TaskController.getInstance().redesc(username, args[0], args[1]);
    }
}