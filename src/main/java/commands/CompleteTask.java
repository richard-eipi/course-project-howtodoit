package commands;

import entities.Task;
import usecasesControllers.TaskController;

import java.util.HashMap;

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
//        TodoSystem todoSystem = dataSaver.getSystem(); // Get access to entities
//        // checkArgs(todoSystem, name); // Check whether argument are valid
//
//        // Map user arguments to task name
//        String name = args[0];
//
//        HashMap<String, Task> tasks = todoSystem.getTasks();
//        Task task = tasks.get(name);
//        task.getProject().getTasks().remove(name); // Delete task from its project
//        // Delete task from all the labels it's in
//        ArrayList<Folder> labels = task.getLabels();
//        for (Folder label : labels) {
//            label.getTasks().remove(name); // Delete task from its labels
//        }
//        tasks.remove(name); // Delete task from the system
//
//        return "Task <" + name + "> has been completed successfully.";
        if (args.length != 1) throw new Exception("Incorrect argument length!");
        return TaskController.getInstance().completeTask(username,args[0]);
    }
}