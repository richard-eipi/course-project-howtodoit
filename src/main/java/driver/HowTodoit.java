package driver;

import commands.CommandExecutor;
import constants.Commands;

import java.util.Scanner;

/**
 * This is where our program will be run.
 */
public class HowTodoit {
    public static void main(String[] args) {
        System.out.println("Welcome to HowTodoit: our virtual to-do-list system (version 0).");

        // Initialize DataManager, CommandExecutor, and all commands
        DataManager dataManager = new DataManager();
        CommandExecutor commandExecutor = new CommandExecutor();
        Commands.loadCommands();

        // Read data from local files
        dataManager.readData();

        // Set up initial Memento
        try {
            Commands.COMMANDS.get("regret").execute(dataManager, new String[]{"setMemento"});
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Let user type their commands and execute them
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("User command: ");
            String userInput = in.nextLine();
            if (userInput.equals("exit")) break;
            try {
                String output = commandExecutor.executeCommand(dataManager, userInput);
                System.out.println(output);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // Write data into local files and exit the system
        dataManager.writeData();
    }
}
