package commands;

import constants.Commands;
import driver.DataAccessor;

import java.util.*;

/**
 * This class initializes and executes commands.
 */
public class CommandExecutor {
    /**
     *
     * @param userInput exactly what the user typed
     * @return whatever String is returned by the specific command executed
     * @throws Exception when command is not found or when arguments are invalid
     */
    public String executeCommand(DataAccessor dataAccessor, String userInput) throws Exception {
        String[] inputArray = userInput.split(";"); // Use ";" to split user input String
        String userCommandName = inputArray[0];
        // Get the corresponding command object
        Executable command  = Commands.COMMANDS.getOrDefault(userCommandName, null);
        if (command != null) {
            String[] args = Arrays.copyOfRange(inputArray, 1, inputArray.length); // Get user arguments
            String output = command.execute(dataAccessor, args);
            // Timestamp current state if it's a mutating command
            if (!Commands.NON_MUTATING_COMMANDS.contains(userCommandName)) {
                Commands.COMMANDS.get("regret").execute(dataAccessor, new String[]{"setMemento"});
            }
            return output; // Execute the command
        } else {
            throw new Exception("Command not found!");
        }
    }
}
