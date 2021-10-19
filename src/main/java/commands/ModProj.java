package commands;

import driver.DataAccessor;
import todoSystem.Folder;
import todoSystem.TodoSystem;

/**
 * This class renames a project.
 */
public class ModProj implements Executable{
    /**
     * This function executes the modproj command: change a project’s name from <name1> to <name2>
     * The project must already exist in the system.
     *
     * @param args a String, representing user arguments
     * @return a String indicating a project name has been changed
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args){
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, name); // Check whether argument are valid

        // Map user arguments to old name, new name
        String oldName = args[0];
        String newName = args[1];

        Folder project = todoSystem.getProjects().get(oldName);
        project.setName(newName); // Rename project

        return "Project <" + oldName + "> has been renamed to <" + newName + "> successfully.";
    }
}
