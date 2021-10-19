package commands;

import driver.DataAccessor;
import todoSystem.Folder;
import todoSystem.Task;
import todoSystem.TodoSystem;

/**
 * This class stars a task.
 */
public class Star implements Executable{
    /**
     * This function executes the star command: Add a task called <name> to Starred label
     * The task must already exist in the system.
     * @param args a String, representing user arguments
     * @return a String indicating a task has been added to Starred label
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, name); // Check whether argument are valid

        // Map user arguments to task name
        String name = args[0];

        Task task = todoSystem.getTasks().get(name);
        Folder starred = todoSystem.getLabels().get("Starred");
        starred.getTasks().put(name, task); // Add task to Starred
        task.getLabels().add(starred);

        return "Task <" + name + "> has been added to label <Starred> successfully.";
    }
}
