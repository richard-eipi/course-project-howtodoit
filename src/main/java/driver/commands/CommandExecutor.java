package driver.commands;

import constants.Commands;

import java.util.Arrays;

/**
 * This class executes driver.commands after the user has logged in.
 */
public class CommandExecutor {
    /**
     * The username of the user that's logged in.
     */
    private static String username;

    /**
     * Executes a command based on user input.
     *
     * @param userInput exactly what the user typed
     * @return whatever String is returned by the specific command executed
     * @throws Exception when command is not found or when arguments are invalid
     */
    public static String executeCommand(String userInput) throws Exception {
        String[] inputArray = userInput.split(";"); // Use ";" to split user input String
        String userCommandName = inputArray[0];
        // Get the corresponding command object
        Command command = Commands.COMMANDS.getOrDefault(userCommandName, null);
        if (command != null) {
            String[] args = Arrays.copyOfRange(inputArray, 1, inputArray.length); // Get user arguments
            return command.execute(CommandExecutor.username, args); // Execute the command
        } else {
            throw new Exception("Command not found!");
        }
    }

    /**
     * Sets the username after logging in
     *
     * @param username the username
     */
    public static void setUsername(String username) {
        CommandExecutor.username = username;
    }
}
