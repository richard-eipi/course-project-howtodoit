package driver;

import entities.UserList;
import helpers.IUseCaseControllerBuilder;

import java.io.*;

import static constants.FilePaths.systemFilePath;

/**
 * This class reads data from and writes data into local files.
 */
public class DataManager implements DataSaver {
    private UserList userlist;
    private final IUseCaseControllerBuilder builder;

    public DataManager(IUseCaseControllerBuilder builder){
        this.builder = builder;
    }

    /**
     * This function reads data from local files and initializes todoSystem.
     */
    public String readData() {
        try {
            FileInputStream fileIn = new FileInputStream(systemFilePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.userlist = (UserList) in.readObject();
            this.builder.build(this.userlist); // Let the builder build use cases and controllers
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
            i.printStackTrace();
        }
    }
}