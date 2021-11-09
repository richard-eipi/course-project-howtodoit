package driver;

import commands.CommandExecutor;
import loginregister.LoginRegisterExecutor;
import constants.Commands;

import java.util.Scanner;

/**
 * This is our command line interface.
 */
public class CLI {
    public static void run() {
        // Greetings
        System.out.println("Welcome to HowTodoit: our virtual to-do-list system (version 0).");

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
     * @param commandExecutor the class that's responsible for finding commands to execute
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
     * Let user type their commands and execute them
     * @param in the scanner
     * @param commandExecutor the class that's responsible for finding commands to execute
     * @return true if user just logs out but does not exit the program (may log in again), false if exit
     */
    private static boolean executeCommands(Scanner in, CommandExecutor commandExecutor) {
        while (true) {
            System.out.print("User command: ");
            String userInput = in.nextLine();
            if (userInput.equals("exit")) return false;
            if (userInput.equals("logout")) return true;
            try {
                String output = commandExecutor.executeCommand(userInput);
                System.out.println(output);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
