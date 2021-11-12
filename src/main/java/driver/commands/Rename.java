package driver.commands;

import controllers.TaskController;

/**
 * This class renames a task.
 */
public class Rename implements Command {

    /**
     * This function executes the rename command: Change the name of a task from <name1> to <name2>
     * The task must already exist in the system.
     *
     * @param username current username
     * @param args     a list of Strings with length 2, representing user arguments
     * @return a String indicating a task has been renamed
     */
    @Override
    public String execute(String username, String[] args) throws Exception {
        if (args.length != 2) throw new Exception("Incorrect argument length!");
        return TaskController.getInstance().rename(username, args[0], args[1]);
    }

}

