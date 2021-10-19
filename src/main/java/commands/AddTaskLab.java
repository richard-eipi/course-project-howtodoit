package commands;

import driver.DataAccessor;
import todoSystem.Folder;
import todoSystem.TodoSystem;
import todoSystem.Task;

/**
 * This class adds a task to a label.
 */
public class AddTaskLab implements Executable {

    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, args); // Check whether arguments are valid

        // Map user arguments to task name and label name
        String taskName = args[0];
        String labName = args[1];

        Task task = todoSystem.getTasks().get(taskName);
        Folder label = todoSystem.getLabels().get(labName);
        label.getTasks().put(taskName, task); // Add task to label
        task.getLabels().add(label);

        return "Task <" + taskName + "> has been added to label <" + labName + "> successfully.";
    }
}