package driver;

import driver.cli.CLI;
import driver.gui.GUI;
import gateway.DataManager;

import java.util.Scanner;

/**
 * This is where our program will be run.
 */
public class HowTodoit {
    public static void main(String[] args) {
        // Initialize DataManager and read data
        DataManager dataManager = new DataManager();
        System.out.println(dataManager.readData());

        // Ask the user whether to run CLI or GUI
        Scanner in = new Scanner(System.in);
        System.out.println("Do you wish to run the app on GUI? Please type 'yes' if you do.");
        if (in.nextLine().equals("yes")) {
            GUI.run();
        } else {
            CLI.run();
        }

        // Write data into local files and exit the system
        System.out.println(dataManager.writeData());
    }
}
