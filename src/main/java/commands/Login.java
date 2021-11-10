package commands;

import driver.DataSaver;
/**
 * This class logs a user in
 */
public class Login implements Executable{

    /**
     * This function executes the login command: check whether <username> matches <password>.
     *
     * @param dataSaver gives us TodoSystem
     * @param args a list of Strings with length 2, representing user arguments
     * @return a String indicating the user has been successfully login.
     */
    @Override
    public String execute(DataSaver dataSaver, String[] args) {
        return "";
    }
}
