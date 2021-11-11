package driver.commands;

import controllers.TaskController;

/**
 * This class creates a new task.
 */
public class NewTask implements Command {

    /**
     * This function executes the newTask command: create a new task called <task name> with due date <time> and add it
     * to a project called <proj name>
     * A valid example of <time> would be “2021-1015”
     * the user can leave the <proj name> field blank to put the task in "General"
     *
     * @param username current username
     * @param args     a list of Strings with length 2 or 3, representing user arguments
     * @return a String indicating a new task has been added successfully
     */
    @Override
    public String execute(String username, String[] args) throws Exception {
        if (!(args.length == 3) && !(args.length == 2)) throw new Exception("Incorrect argument length!");
        String projName = args.length == 3 ? args[2] : "General";
        return TaskController.getInstance().newTask(username, args[0], args[1], projName);
    }
}
