package commands;

import driver.DataAccessor;
import entities.Task;
import helpers.ChronologicalSort;

import java.util.HashMap;
import java.util.List;

/**
 * This class shows all upcoming tasks.
 */
public class Upcoming implements Executable {

    /**
     * This function executes the upcoming command: list all tasks in chronological order
     *
     * @param args a list of Strings with length 0, representing user arguments
     * @return a String of all tasks in chronological order
     */

    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities

        HashMap<String, Task> tasks = todoSystem.getTasks(); // Get all tasks
        List<Task> sortedTasks = ChronologicalSort.tasks_in_ch_order(tasks); // Sort them
        StringBuilder output = new StringBuilder();
        for (Task task: sortedTasks) {
            output.append(task.toString()).append('\n'); // Each line will be a task
        }
        return output.toString();
    }
}
