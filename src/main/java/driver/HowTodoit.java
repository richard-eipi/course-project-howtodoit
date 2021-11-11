package driver;

import database.DataManager;
import database.UseCaseControllerBuilder;

/**
 * This is where our program will be run.
 */
public class HowTodoit {
    public static void main(String[] args) {
        // Initialize DataManager and read data
        UseCaseControllerBuilder builder = new UseCaseControllerBuilder();
        DataManager dataManager = new DataManager(builder);
        System.out.println(dataManager.readData());

        // Set up initial Memento
//        try {
//            Commands.COMMANDS.get("regret").execute(dataManager, new String[]{"setMemento"});
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        // Run the program on CLI
        CLI.run();

        // Write data into local files and exit the system
        System.out.println(dataManager.writeData());
    }
}
