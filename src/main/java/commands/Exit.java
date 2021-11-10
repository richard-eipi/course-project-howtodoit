package commands;

/**
 * This class quits the program and save data.
 */
public class Exit implements Executable{

    /**
     * This function executes the exit command: quit the program and save data.
     *
     * @param username current username
     * @param args a list of Strings with length 0, representing user arguments
     * @return a String indicating the user has been successfully exit
     */
    @Override
    public String execute(String username, String[] args) {
        return "";
    }
}
