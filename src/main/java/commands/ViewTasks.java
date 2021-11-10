package commands;

import driver.DataSaver;

public class ViewTasks implements Executable{

    /**
     * This function executes the viewTasks command: show all upcoming tasks in all projects in chronological order
     * for the user; starred tasks will have stars in front of them.
     *
     * @param args a list of Strings with length 0, representing user arguments
     * @return a String indicating all tasks have been successfully displayed.
     */
    @Override
    public String execute(DataSaver dataSaver, String[] args) {
        return "";
    }
}
