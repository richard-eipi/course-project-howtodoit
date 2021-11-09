package commands;

import driver.DataAccessor;
import todoSystem.Task;

/**
 * This class updates the due date of a task.
 */
public class Retime implements Executable {

    /**
     * This function executes the retime command: change the due date of a task
     * The task must already exist in the system.
     *
     * @param args a list of Strings with length 2, representing user arguments
     * @return a String indicating a task's due date has been updated
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, args); // Check whether arguments are valid

        // Map user arguments to task name and new due date
        String name = args[0];
        String newtime = args[1];
        // Get task and change its due date
        Task task = todoSystem.getTasks().get(name);
        task.setDueDate(newtime);

        return "The due date of task <" + name + "> has been updated successfully.";
    }
}
