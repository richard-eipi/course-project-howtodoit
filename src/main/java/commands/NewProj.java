package commands;

import usecasesControllers.ProjectController;
import usecasesControllers.TaskController;

/**
 * This class creates a new project.
 */
public class NewProj implements Command {

    /**
     * This function executes the newProj command: create a new project with given params.
     * The project must not already exist in the system.
     *
     * @param username current username
     * @param args a list of Strings with length 1, representing user arguments
     * @return a String indicating a new project has been created successfully
     */
    @Override
    public String execute(String username, String[] args) throws Exception {
//        TodoSystem todoSystem = dataSaver.getSystem(); // Get access to entities
//        checkArgs(todoSystem, args); // Check whether arguments are valid
//
//        // Map user arguments to name
//        String name = args[0];
//        // Add new project to the system
//        todoSystem.getProjects().put(name, new Folder(name, true));
//
//        return "Project <" + name + "> has been added successfully.";
        if (!(args.length == 1) && !(args.length == 2)) throw new Exception("Incorrect argument length!");
        String teamName = args.length == 2 ? args[1] : "";
        return ProjectController.getInstance().newProj(username, args[0], teamName);
    }

    private void checkArgs(TodoSystem todoSystem, String[] args) throws Exception {
        if (args.length != 1) {
            throw new Exception("Wrong argument length.");
        } else if (todoSystem.getProjects().containsKey(args[0])) {
            throw new Exception("Project <" + args[0] + "> already exists.");
        }
    }
}
