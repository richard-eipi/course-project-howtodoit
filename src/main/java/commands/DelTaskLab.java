package commands;

import driver.DataAccessor;
import todoSystem.Folder;
import todoSystem.Task;
import todoSystem.TodoSystem;

/**
 * This class deletes a task from a label.
 */
public class DelTaskLab implements Executable {

    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, args); // Check whether arguments are valid

        // Map user arguments to task name and label name
        String taskName = args[0];
        String labName = args[1];

        Task task = todoSystem.getTasks().get(taskName);
        Folder label = todoSystem.getLabels().get(labName);
        label.getTasks().remove(taskName); // Remove task from label
        task.getLabels().remove(label);

        return "Task <" + taskName + "> has been removed from label <" + labName + "> successfully.";
    }
}