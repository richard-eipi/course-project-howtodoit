package commands;

import controllers.ProjectController;

/**
 * This class renames a project.
 */
public class ModProj implements Command {
    /**
     * This function executes the modproj command: change a project’s name from <name1> to <name2>
     * The project must already exist in the system.
     *
     * @param username current username
     * @param args a list of Strings with length 2, representing user arguments
     * @return a String indicating a project name has been changed
     */
    @Override
    public String execute(String username, String[] args) throws Exception{
//        TodoSystem todoSystem = dataSaver.getSystem(); // Get access to entities
//        // checkArgs(todoSystem, name); // Check whether argument are valid
//
//        // Map user arguments to old name, new name
//        String oldName = args[0];
//        String newName = args[1];
//
//        Folder project = todoSystem.getProjects().get(oldName);
//        project.setName(newName); // Rename project
//
//        return "Project <" + oldName + "> has been renamed to <" + newName + "> successfully.";
        if (args.length != 2) throw new Exception("Incorrect argument length!");
        return ProjectController.getInstance().modProj(username, args[0], args[1]);
    }
}
