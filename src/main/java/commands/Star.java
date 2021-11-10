package commands;
import entities.Task;
import usecasesControllers.TaskController;

/**
 * This class stars a task.
 */
public class Star implements Command {
    /**
     * This function executes the star command: Add a task called <name> to Starred label
     * The task must already exist in the system.
     *
     * @param username current username
     * @param args a list of Strings with length 1, representing user arguments
     * @return a String indicating a task has been added to Starred label
     */
    @Override
    public String execute(String username, String[] args) throws Exception{
//        TodoSystem todoSystem = dataSaver.getSystem(); // Get access to entities
//        // checkArgs(todoSystem, name); // Check whether argument are valid
//
//        // Map user arguments to task name
//        String name = args[0];
//
//        Task task = todoSystem.getTasks().get(name);
//        Folder starred = todoSystem.getLabels().get("Starred");
//        starred.getTasks().put(name, task); // Add task to Starred
//        task.getLabels().add(starred);
//
//        return "Task <" + name + "> has been added to label <Starred> successfully.";
        if (args.length != 1) throw new Exception("Incorrect argument length!");
        return TaskController.getInstance().star(username,args[0]);
    }
}
