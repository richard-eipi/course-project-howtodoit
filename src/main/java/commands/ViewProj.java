package commands;

import driver.DataAccessor;
import todoSystem.Folder;
import todoSystem.TodoSystem;
import todoSystem.Task;

import java.util.List;
import java.util.HashMap;
import helpers.ChronologicalSort;

/**
 * This class lists all tasks contained in a project.
 */
public class ViewProj implements Executable {

    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, args); // Check whether arguments are valid

        // Map user arguments to project name
        String name = args[0];

        Folder project = todoSystem.getProjects().get(name);
        HashMap<String, Task> tasks = project.getTasks(); // Get all tasks from this project
        List<Task> sortedTasks = ChronologicalSort.tasks_in_ch_order(tasks); // Sort them
        StringBuilder output = new StringBuilder("This project <" + name + "> contains the following tasks:\n");
        for (Task task: sortedTasks) {
            output.append(task.toString()).append('\n'); // Each line will be a task
        }

        return output.toString();
    }
}
