package driver;

import driver.cli.CLI;
import driver.gui.GUI;
import gateway.DataManager;

/**
 * This is where our program will be run.
 */
public class HowTodoit {
    public static void main(String[] args) {
        // Initialize DataManager and read data
        DataManager dataManager = new DataManager();
        System.out.println(dataManager.readData());

        // Run the program on CLI
        // CLI.run();

        // Run the program on GUI
        GUI.run();

        // Write data into local files and exit the system
        System.out.println(dataManager.writeData());
    }
}
