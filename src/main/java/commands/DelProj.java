package commands;

import driver.DataAccessor;
import todoSystem.Folder;
import todoSystem.TodoSystem;

import java.util.HashMap;

/**
 * This class deletes a project.
 */
public class DelProj implements Executable {
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, args); // Check whether arguments are valid

        // Map user arguments to project name
        String name = args[0];

        HashMap<String, Folder> projects = todoSystem.getProjects();
        Folder project = projects.get(name);
        Folder inbox = projects.get("Inbox");
        inbox.getTasks().putAll(project.getTasks()); // Move all tasks in this project to Inbox
        projects.remove(name); // Delete project from the system

        return "Project <" + name + "> has been removed and all tasks have been added into inbox successfully.";
    }
}