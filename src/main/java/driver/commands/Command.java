package driver.commands;

/**
 * This class executes a user command by delegating the task to a controller.
 */
public interface Command {

    /**
     * Execute the command.
     *
     * @param username current username
     * @param args     user arguments
     * @return String indicating result
     * @throws Exception any Exceptions that occur along the way
     */
    String execute(String username, String[] args) throws Exception;

}
