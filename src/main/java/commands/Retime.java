package commands;
import entities.Task;
import usecasesControllers.TaskController;

/**
 * This class updates the due date of a task.
 */
public class Retime implements Command {

    /**
     * This function executes the retime command: change the due date of a task
     * The task must already exist in the system.
     *
     * @param username current username
     * @param args a list of Strings with length 2, representing user arguments
     * @return a String indicating a task's due date has been updated
     */
    @Override
    public String execute(String username, String[] args) throws Exception{
//        TodoSystem todoSystem = dataSaver.getSystem(); // Get access to entities
//        // checkArgs(todoSystem, args); // Check whether arguments are valid
//
//        // Map user arguments to task name and new due date
//        String name = args[0];
//        String newtime = args[1];
//        // Get task and change its due date
//        Task task = todoSystem.getTasks().get(name);
//        task.setDueDate(newtime);
//
//        return "The due date of task <" + name + "> has been updated successfully.";
        if (args.length != 2) throw new Exception("Incorrect argument length!");
        return TaskController.getInstance().retime(username,args[0], args[1]);
    }
}
