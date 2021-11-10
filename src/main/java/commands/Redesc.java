package commands;

import entities.Task;

/**
 * This class updates the description of a task.
 */
public class Redesc implements Executable {

    /**
     * This function executes the redesc command: change the description of a task
     * The task must already exist in the system.
     *
     * @param username current username
     * @param args a list of Strings with length 2, representing user arguments
     * @return a String indicating a task's description has been updated
     */
    @Override
    public String execute(String username, String[] args) {
        TodoSystem todoSystem = dataSaver.getSystem(); // Get access to entities
        // checkArgs(todoSystem, args); // Check whether arguments are valid

        // Map user arguments to task name and new description
        String name = args[0];
        String newdesc = args[1];
        // Get task and change its description
        Task task = todoSystem.getTasks().get(name);
        task.setDescription(newdesc);

        return "The description of task <" + name + "> has been updated successfully.";
    }
}