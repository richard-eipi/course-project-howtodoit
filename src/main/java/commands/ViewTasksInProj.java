package commands;

import driver.DataAccessor;

public class ViewTasksInProj implements Executable{

    /**
     * This function executes the viewTasksInProj command: show all tasks in the project called <name>.
     *
     * @param args a list of Strings with length 1, representing user arguments
     * @return a String indicating all tasks have been successfully displayed.
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        return "";
    }
}
