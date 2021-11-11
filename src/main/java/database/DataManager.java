package database;

import usecases.UserList;

import java.io.*;

import static constants.FilePaths.systemFilePath;

/**
 * This class reads data from and writes data into local files.
 */
public class DataManager implements DataSaver {
    private UserList userlist;
    private final IUseCaseControllerBuilder useCaseControllerBuilder;

    public DataManager(IUseCaseControllerBuilder builder){
        this.useCaseControllerBuilder = builder;
    }

    /**
     * This function reads data from local files and initializes todoSystem.
     */
    public String readData() {
        try {
            FileInputStream fileIn = new FileInputStream(systemFilePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.userlist = (UserList) in.readObject();
            // let the builder build use cases and controllers
            this.useCaseControllerBuilder.buildUseCaseController(this.userlist, this);
            in.close();
            fileIn.close();
            return "Data has been loaded successfully.";
        } catch (IOException i) {
            return "Data not found. We are starting with a new empty system.";
        } catch (ClassNotFoundException c) {
            return "UserList class not found. We are starting with a new empty system.";
        }
    }

    /**
     * This function writes data (tasks, projects...) into the given file.
     */
    @Override
    public String writeData() {
        try {
            FileOutputStream fileOut = new FileOutputStream(systemFilePath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.userlist);
            out.close();
            fileOut.close();
            return "Data has been saved successfully.";
        } catch (IOException i) {
            return "Data has not been saved successfully. Sorry, your data is lost.";
        }
    }
}