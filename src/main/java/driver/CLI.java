package driver;

import controllers.DataMemoryController;
import driver.commands.CommandExecutor;
import driver.commands.LoginRegisterExecutor;
import constants.Commands;

import java.util.Scanner;

/**
 * This is our command line interface.
 */
public class CLI {
    public static void run() {
        // Greetings
        System.out.println("Welcome to driver.HowTodoit: our virtual to-do-list system (version 0).");

        // Setup
        Scanner in = new Scanner(System.in);
        Commands.loadCommands();
        CommandExecutor commandExecutor = new CommandExecutor();

        while (true) {
            boolean running;
            running = dealWithLoginRegister(in, commandExecutor);
            if (!running) return;
            running = executeCommands(in, commandExecutor);
            if (!running) return;
        }
    }

    /**
     *
     * @param in the scanner
     * @param commandExecutor the class that's responsible for finding driver.commands to execute
     * @return true if user logs in, false if exit
     */
    private static boolean dealWithLoginRegister(Scanner in, CommandExecutor commandExecutor) {
        LoginRegisterExecutor loginRegisterExecutor = new LoginRegisterExecutor();
        while (true) {
            System.out.println("Please login or register to continue.");
            String userInput = in.nextLine();
            if (userInput.equals("exit")) return false;
            try {
                String username = loginRegisterExecutor.executeCommand(userInput);
                commandExecutor.setUsername(username);
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Let user type their driver.commands and execute them
     * @param in the scanner
     * @param commandExecutor the class that's responsible for finding driver.commands to execute
     * @return true if user just logs out but does not exit the program (may log in again), false if exit
     */
    private static boolean executeCommands(Scanner in, CommandExecutor commandExecutor) {
        while (true) {
            System.out.print("User command: ");
            String userInput = in.nextLine();
            switch (userInput) {
                case "exit":
                    return false;
                case "save":
                    DataMemoryController.getInstance().save();
                    break;
                case "logout":
                    DataMemoryController.getInstance().save(); // auto save data when logging out
                    return true;
                default:
                    executeCommand(commandExecutor, userInput);
                    break;
            }
        }
    }

    private static void executeCommand(CommandExecutor commandExecutor, String userInput) {
        try {
            String output = commandExecutor.executeCommand(userInput);
            System.out.println(output);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
