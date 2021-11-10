package commands;

import driver.DataSaver;

import java.util.HashMap;

/**
 * This class deletes a project.
 */
public class DelProj implements Executable {
    /**
     * This function executes the DelProj command: Delete the project called <name> and move all its tasks to General
     * if the project is personal.
     * If the project is a team project, this user must be an admin and all tasks are deleted.
     *
     *
     * @param args a list of Strings with length 1, representing user arguments
     * @return a String indicating a  project has been deleted successfully
     */
    @Override
    public String execute(DataSaver dataSaver, String[] args) {
        TodoSystem todoSystem = dataSaver.getSystem(); // Get access to entities
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