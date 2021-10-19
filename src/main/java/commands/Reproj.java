package commands;

import driver.DataAccessor;
import todoSystem.Folder;
import todoSystem.Task;
import todoSystem.TodoSystem;

/**
 * This class updates the project a task is in.
 */
public class Reproj implements Executable {

    /**
     * This function executes the reproj command: move this task to a different project.
     * @param args a list of Strings with length 2, representing user arguments
     * @return a String indicating this task has been moved to a different project
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, args); // Check whether arguments are valid

        // Map user arguments to name, dueDate, description
        String taskName = args[0];
        String projName = args[1];

        Task task = todoSystem.getTasks().get(taskName);
        task.getProject().getTasks().remove(taskName); // Delete task from current project
        Folder newProj = todoSystem.getProjects().get(projName);
        newProj.getTasks().put(taskName, task); // Add task to new project
        task.setProject(newProj);

        return "Task <"+ taskName + "> has been successfully moved to project <" + projName + ">.";
    }
}
