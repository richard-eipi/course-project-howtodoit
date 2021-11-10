package commands;

import driver.DataSaver;
/**
 * This class logs a user out
 */
public class Logout implements Executable{

    /**
     * This function executes the logout command: let the user logout
     *
     * @param dataSaver gives us TodoSystem
     * @param args a list of Strings with length 0, representing user arguments
     * @return a String indicating the user has been successfully logout.
     */
    @Override
    public String execute(DataSaver dataSaver, String[] args) {
        return "";
    }
}
