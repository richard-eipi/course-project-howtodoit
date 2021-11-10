package commands;

import driver.DataAccessor;
/**
 * This class registers a new user
 */
public class Register implements Executable{

    /**
     * This function executes the register command: add new user with given <username> and <password>
     *     and automatically log in.
     *
     * @param dataAccessor gives us TodoSystem
     * @param args a list of Strings with length 2, representing user arguments
     * @return a String indicating the user has been successfully registered.
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        return "";
    }
}
