package commands;

import driver.DataAccessor;
/**
 * This class logs a user out
 */
public class Logout implements Executable{

    /**
     * This function executes the logout command: let the user logout
     *
     * @param dataAccessor gives us TodoSystem
     * @param args a list of Strings with length 0, representing user arguments
     * @return a String indicating the user has been successfully logout.
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        return "";
    }
}
