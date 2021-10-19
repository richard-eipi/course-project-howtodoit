package commands;

import driver.DataAccessor;
import todoSystem.Folder;
import todoSystem.TodoSystem;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class lists all projects.
 */
public class ListProj implements Executable {

    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, args); // Check whether arguments are valid

        HashMap<String, Folder> projects = todoSystem.getProjects();
        Set<String> projNames = projects.keySet(); // Get all project names
        List<String> sortedNames = projNames.stream().sorted().collect(Collectors.toList()); // Sort them
        // Put Inbox at the end
        sortedNames.remove("Inbox");
        sortedNames.add(sortedNames.size() - 1, "Inbox");

        return "The following projects are in HowTodoit: <" + sortedNames + ">.";
    }
}
