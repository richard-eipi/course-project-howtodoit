package commands;

import usecasesControllers.TaskController;

/**
 * This class assigns a task to a user.
 */
public class AssignTask implements Command {
    /**
     * This function executes the assignTask command: create a new task called <task name> for a teammate called
     *  <username> in a team called <team name> with <due date>.
     *
     * @param username current username
     * @param args a list of Strings with length 4, representing user arguments
     * @return a String indicating the task has been assigned to a user
     */
    @Override
    public String execute(String username, String[] args) throws Exception{
        if (args.length != 4) throw new Exception("Incorrect argument length!");
        return TaskController.getInstance().assignTask(username,args[0], args[1], args[2], args[3]);
    }
}
