package commands;

import driver.DataAccessor;
import todoSystem.Project;
import todoSystem.Task;
import todoSystem.TodoSystem;

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
        // Move task to a different project
        Task task = todoSystem.getTasks().get(taskName); // Get task
        task.getProject().delTask(task); // Delete task from current project
        Project newProj = todoSystem.getProjects().get(projName); // Get new project
        newProj.addTask(task); // Add task to new project
        task.setProject(newProj);
        return "Task successfully moved to a different project.";
    }

//    private void checkArgs(TodoSystem todoSystem, String[] args) {
//    }
}