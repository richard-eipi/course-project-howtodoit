package driver.commands;

import controllers.QueryController;


public class ViewProj implements Command {
    /**
     * This function executes the viewProj command: show all projects for the user.
     *
     * @param username current username
     * @param args a list of Strings with length 0, representing user arguments
     * @return a String indicating the all peojects have been successfully displayed.
     */
    @Override
    public String execute(String username, String[] args) throws Exception{
//        TodoSystem todoSystem = dataSaver.getSystem(); // Get access to entities
//        // checkArgs(todoSystem, args); // Check whether arguments are valid
//
//        // Map user arguments to project name
//        String name = args[0];
//
//        Folder project = todoSystem.getProjects().get(name);
//        HashMap<String, Task> tasks = project.getTasks(); // Get all tasks from this project
//        List<Task> sortedTasks = ChronologicalSort.tasks_in_ch_order(tasks); // Sort them
//        StringBuilder output = new StringBuilder("This project <" + name + "> contains the following tasks:\n");
//        for (Task task: sortedTasks) {
//            output.append(task.toString()).append('\n'); // Each line will be a task
//        }
//
//        return output.toString();
        if (args.length != 0) throw new Exception("Incorrect argument length!");
        return QueryController.getInstance().viewProjs(username);
    }
}
