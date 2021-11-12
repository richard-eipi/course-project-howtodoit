package database;

import controllers.*;
import usecases.*;

import java.io.*;

import static constants.FilePaths.systemFilePath;

/**
 * This class reads data from and writes data into local files.
 */
public class DataManager implements DataSaver {
    private UserList userList = new UserList();

    /**
     * This function reads data from local files and initializes todoSystem.
     */
    public String readData() {
        String output;
        try {
            FileInputStream fileIn = new FileInputStream(systemFilePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.userList = (UserList) in.readObject();
            in.close();
            fileIn.close();
            output =  "Data has been loaded successfully.";
        } catch (IOException i) {
            output =  "Data not found. We are starting with a new empty system.";
        } catch (ClassNotFoundException c) {
            output =  "UserList class not found. We are starting with a new empty system.";
        }

        buildUseCaseController();
        return output;
    }

    /**
     * This function writes data (tasks, projects...) into the given file.
     */
    @Override
    public String writeData() {
        try {
            FileOutputStream fileOut = new FileOutputStream(systemFilePath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.userList);
            out.close();
            fileOut.close();
            return "Data has been saved successfully.";
        } catch (IOException i) {
            return "Data has not been saved successfully. Sorry, your data is lost.";
        }
    }

    private void buildUseCaseController() {
        LoginRegisterUseCases loginRegisterUseCases = new LoginRegisterUseCases(userList);
        UserAccountUseCases userAccountUseCases = new UserAccountUseCases(userList);
        TaskUseCases taskUseCases = new TaskUseCases(userList);
        TeamUseCases teamUseCases = new TeamUseCases(userList);
        ProjectUseCases projectUseCases = new ProjectUseCases(userList);
        QueryUseCases queryUseCases = new QueryUseCases(userList);
        DataMemoryUseCases dataMemoryUseCases = new DataMemoryUseCases(userList);
        dataMemoryUseCases.setDataSaver(this); // inject DataSaver into that use case

        LoginRegisterController.getInstance().setInputBoundary(loginRegisterUseCases);
        UserAccountController.getInstance().setInputBoundary(userAccountUseCases);
        TaskController.getInstance().setInputBoundary(taskUseCases);
        TeamController.getInstance().setInputBoundary(teamUseCases);
        ProjectController.getInstance().setInputBoundary(projectUseCases);
        QueryController.getInstance().setInputBoundary(queryUseCases);
        DataMemoryController.getInstance().setInputBoundary(dataMemoryUseCases);
    }
}