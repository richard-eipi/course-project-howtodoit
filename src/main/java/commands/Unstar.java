package commands;

import driver.DataAccessor;
import todoSystem.Folder;
import todoSystem.Task;
import todoSystem.TodoSystem;

/**
 * This class unstars a task.
 */
public class Unstar implements Executable {

    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, args); // Check whether arguments are valid

        // Map user arguments to task name
        String name = args[0];

        Task task = todoSystem.getTasks().get(name);
        Folder starred = todoSystem.getLabels().get("Starred");
        starred.getTasks().remove(name); // Remove task from Starred
        task.getLabels().remove(starred);

        return "Task <" + name + "> has been removed from label <Starred> successfully.";
    }
}