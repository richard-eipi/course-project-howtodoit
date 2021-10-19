package commands;

import driver.DataAccessor;
import todoSystem.Folder;
import todoSystem.Task;
import todoSystem.TodoSystem;

import java.util.HashMap;

/**
 * This class deletes a label.
 */
public class DelLab implements Executable {

    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, args); // Check whether arguments are valid

        // Map user arguments to label name
        String name = args[0];

        HashMap<String, Folder> labels = todoSystem.getLabels();
        Folder label = labels.get(name);
        // Remove this label from all tasks it contains
        for (String taskName : label.getTasks().keySet()) {
            Task task = todoSystem.getTasks().get(taskName);
            task.getLabels().remove(label);
        }
        labels.remove(name); // Delete label from the system

        return "Label <" + name + "> has been removed successfully.";
    }
}