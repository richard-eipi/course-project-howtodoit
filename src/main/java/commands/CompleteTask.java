package commands;

import driver.DataAccessor;
import todoSystem.Folder;
import todoSystem.Task;
import todoSystem.TodoSystem;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class deletes a completed task.
 */
public class CompleteTask implements Executable {

    /**
     * This function executes the completetask command: delete the task that's already finished
     * The task must already exist in the system.
     *
     * @param args a list of Strings with length 1, representing user arguments
     * @return a String indicating the completed task has been deleted.
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, name); // Check whether argument are valid

        // Map user arguments to task name
        String name = args[0];

        HashMap<String, Task> tasks = todoSystem.getTasks();
        Task task = tasks.get(name);
        task.getProject().getTasks().remove(name); // Delete task from its project
        // Delete task from all the labels it's in
        ArrayList<Folder> labels = task.getLabels();
        for (Folder label : labels) {
            label.getTasks().remove(name); // Delete task from its labels
        }
        tasks.remove(name); // Delete task from the system

        return "Task <" + name + "> has been completed successfully.";
    }
}