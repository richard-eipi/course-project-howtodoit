package commands;

import driver.DataAccessor;
import todoSystem.Folder;
import todoSystem.TodoSystem;

/**
 * This class renames a label.
 */
public class ModLab implements Executable{
    /**
     * This function executes the modlab command: change a label’s name from <name1> to <name2>
     * The label must already exist in the system.
     *
     * @param args a String, representing user arguments
     * @return a String indicating a label name has been changed
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args){
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, name); // Check whether argument are valid

        // Map user arguments to old name, new name
        String oldName = args[0];
        String newName = args[1];

        Folder label = todoSystem.getLabels().get(oldName);
        label.setName(newName); // Rename label

        return "Label <" + oldName + "> has been renamed to <" + newName + "> successfully.";
    }
}