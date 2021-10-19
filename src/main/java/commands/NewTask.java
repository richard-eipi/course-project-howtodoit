package commands;

import driver.DataAccessor;
import todoSystem.Folder;
import todoSystem.Task;
import todoSystem.TodoSystem;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 * This class creates a new task.
 */
public class NewTask implements Executable {

    /**
     * This function executes the newtask command: create a new task with given params and add it to Inbox.
     * The task must not already exist in the system.
     * The due day should be after the current time and have length of 8, in the format of YYYY-MM-DD.
     *
     * @param args a list of Strings with length 3, representing user arguments
     * @return a String indicating a new task has been added successfully
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) throws Exception {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        checkArgs(todoSystem, args); // Check whether arguments are valid

        // Map user arguments to name, dueDate, description
        String name = args[0];
        String dueDate = args[1];
        String description = args[2];

        Folder inbox = todoSystem.getProjects().get("Inbox");
        Task task = new Task(name, dueDate, description, inbox);
        todoSystem.getTasks().put(name, task); // Add new task to the system
        inbox.getTasks().put(name, task); // Add new task to Inbox

        return "Task <" + name + "> has been added successfully.";
    }

    private void checkArgs(TodoSystem todoSystem, String[] args) throws Exception {
        if (args.length != 3) {
            throw new Exception("Wrong argument length.");
        } else if (todoSystem.getTasks().containsKey(args[0])) {
            throw new Exception("Task <" + args[0] + "> already exists.");
        } else if (!(checkDue(args[1]))) {
            throw new Exception("Due date with wrong format. The correct format should be YYYY-MM-dd.");
        } else if (LocalDate.parse(args[1]).isBefore(LocalDate.now())) {
            throw new Exception("This task is already overdue.");
        }
    }

    private boolean checkDue(String s) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // If we want the format of string to be formal, use false. Otherwise, use true.
            sd.setLenient(true);
            sd.parse(s);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
}
