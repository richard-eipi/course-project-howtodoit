package commands;

import driver.DataAccessor;
import todoSystem.Folder;
import todoSystem.TodoSystem;

/**
 * This class creates a new project
 */
public class NewProj implements Executable {

    /**
     * This function executes the newproj command: create a new project with given params.
     * The project must not already exist in the system.
     *
     * @param args a list of Strings with length 1, representing user arguments
     * @return a String indicating a new project has been created successfully
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) throws Exception {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        checkArgs(todoSystem, args); // Check whether arguments are valid

        // Map user arguments to name
        String name = args[0];
        // Add new project to the system
        todoSystem.getProjects().put(name, new Folder(name, true));

        return "Project <" + name + "> has been added successfully.";
    }

    private void checkArgs(TodoSystem todoSystem, String[] args) throws Exception {
        if (args.length != 1) {
            throw new Exception("Wrong argument length.");
        } else if (todoSystem.getProjects().containsKey(args[0])) {
            throw new Exception("Project <" + args[0] + "> already exists.");
        }
    }
}
