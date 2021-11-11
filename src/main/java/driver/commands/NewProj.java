package driver.commands;

import controllers.ProjectController;

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
        if (args.length != 1) throw new Exception("Incorrect argument length!");
        return ProjectController.getInstance().newProj(username, args[0]);
    }
}
