package commands;

import driver.DataAccessor;
import todoSystem.Folder;
import todoSystem.TodoSystem;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class lists all labels.
 */
public class ListLab implements Executable {

    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, args); // Check whether arguments are valid

        HashMap<String, Folder> labels = todoSystem.getLabels();
        Set<String> labNames = labels.keySet(); // Get all label names
        List<String> sortedNames = labNames.stream().sorted().collect(Collectors.toList()); // Sort them
        // Put Starred at the beginning
        sortedNames.remove("Starred");
        sortedNames.add(0, "Starred");

        return "The following labels are in HowTodoit: <" + sortedNames + ">.";
    }
}