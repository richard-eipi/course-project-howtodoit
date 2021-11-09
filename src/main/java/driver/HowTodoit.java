package driver;

/**
 * This is where our program will be run.
 */
public class HowTodoit {
    public static void main(String[] args) {
        // Initialize DataManager and read data
        DataManager dataManager = new DataManager();
        dataManager.readData();

        // Set up initial Memento
//        try {
//            Commands.COMMANDS.get("regret").execute(dataManager, new String[]{"setMemento"});
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        // Run the program on CLI
        CLI.run();

        // Write data into local files and exit the system
        dataManager.writeData();
    }
}
