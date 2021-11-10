package commands;
import entities.Task;
import usecasesControllers.TaskController;

/**
 * This class renames a task.
 */
public class Rename implements Command {

    /**
     * This function executes the rename command: Change the name of a task from <name1> to <name2>
     * The task must already exist in the system.
     *
     * @param username current username
     * @param args a list of Strings with length 2, representing user arguments
     * @return a String indicating a task has been renamed
     */
    @Override
    public String execute(String username, String[] args) throws Exception{
//        TodoSystem todoSystem = dataSaver.getSystem(); // Get access to entities
//        // checkArgs(todoSystem, args); // Check whether arguments are valid
//
//        // Map user arguments to old name, new name
//        String oldName = args[0];
//        String newName = args[1];
//        // Get task and rename it
//        Task task = todoSystem.getTasks().get(oldName);
//        task.setName(newName);
//
//        return "Task <" + oldName + "> has been renamed to <" + newName + "> successfully.";
        if (args.length != 2) throw new Exception("Incorrect argument length!");
        return TaskController.getInstance().rename(username,args[0], args[1]);
    }

}

