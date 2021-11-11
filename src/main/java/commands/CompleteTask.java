package commands;

import controllers.TaskController;

/**
 * This class deletes a completed task.
 */
public class CompleteTask implements Command {

    /**
     * This function executes the completeTask command: delete the task that's already finished
     * The task must already exist in the system.
     *
     * @param username current username
     * @param args a list of Strings with length 1, representing user arguments
     * @return a String indicating the completed task has been deleted
     */
    @Override
    public String execute(String username, String[] args) throws Exception{
        if (args.length != 1) throw new Exception("Incorrect argument length!");
        return TaskController.getInstance().completeTask(username,args[0]);
    }
}