package commands;

import driver.DataSaver;
/**
 * This class registers a new user
 */
public class Register implements Executable{

    /**
     * This function executes the register command: add new user with given <username> and <password>
     *     and automatically log in.
     *
     * @param dataSaver gives us TodoSystem
     * @param args a list of Strings with length 2, representing user arguments
     * @return a String indicating the user has been successfully registered.
     */
    @Override
    public String execute(DataSaver dataSaver, String[] args) {
        return "";
    }
}
