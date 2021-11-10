package commands;

import driver.DataAccessor;
/**
 * This class show all users by name
 */
public class AllUsers implements Executable{

    /**
     * This function executes the allUsers command: show all users by name.
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
