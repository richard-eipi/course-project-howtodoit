package driver.cli;

import constants.Commands;
import controllers.DataMemoryController;

import java.util.Scanner;

/**
 * This is our command line interface.
 */
public class CLI {
    public static void run() {
        // Greetings
        System.out.println("Welcome to HowTodoit: a virtual to-do-list app!");

        // Set up
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
     * @param in              the scanner
     * @param commandExecutor the class that's responsible for finding driver.commands to execute
     * @return true if user logs in, false if exit
     */
    private static boolean dealWithLoginRegister(Scanner in, CommandExecutor commandExecutor) {
        LoginRegisterExecutor loginRegisterExecutor = new LoginRegisterExecutor();
        while (true) {
            System.out.println("Please login or register to continue.(please type register(login); username; password");
            String userInput = in.nextLine();
            if (userInput.equals("exit")) return false;
            try {
                String username = loginRegisterExecutor.executeCommand(userInput);
                commandExecutor.setUsername(username);
                DataMemoryController.getInstance().setTimeStamp();
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Let user type their driver.commands and execute them
     *
     * @param in              the scanner
     * @param commandExecutor the class that's responsible for finding a command to execute
     * @return true if user just logs out but does not exit the program (may log in again), false if exit
     */
    private static boolean executeCommands(Scanner in, CommandExecutor commandExecutor) {
        while (true) {
            System.out.print("User command: ");
            String userInput = in.nextLine();
            switch (userInput) {
                case "logout":
                    System.out.println(DataMemoryController.getInstance().save()); // auto save data when logging out
                    DataMemoryController.getInstance().cleanMemory(); // clean memory for next user login
                    return true;
                case "exit":
                    return false;
                case "save":
                    System.out.println(DataMemoryController.getInstance().save());
                    break;
                case "undo":
                    System.out.println(DataMemoryController.getInstance().undo());
                    break;
                case "redo":
                    System.out.println(DataMemoryController.getInstance().redo());
                    break;
                default:
                    executeCommand(commandExecutor, userInput);
                    break;
            }
        }
    }

    /**
     * Helper method for executing one command.
     *
     * @param commandExecutor the class that's responsible for finding a command to execute
     * @param userInput       user input String
     */
    private static void executeCommand(CommandExecutor commandExecutor, String userInput) {
        try {
            String output = commandExecutor.executeCommand(userInput);
            System.out.println(output);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
