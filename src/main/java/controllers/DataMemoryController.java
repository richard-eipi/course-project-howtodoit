package controllers;

import database.DataSaver;
import usecases.DataMemoryInputBoundary;
import usecases.LoginRegisterInputBoundary;

public class DataMemoryController {
    private static final DataMemoryController instance = new DataMemoryController();
    private DataMemoryInputBoundary inputBoundary;

    public DataMemoryController() {

    }

    public static DataMemoryController getInstance(){
        return instance;
    }

    public void setInputBoundary(DataMemoryInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Hands off the work to use case to save data.
     */
    public void save() {
        this.inputBoundary.save();
    }

    /**
     * Hands off the work to use case to perform the undo action.
     */
    public String undo(String username) throws Exception {
        boolean result = this.inputBoundary.undo(username);
        if (!result) {
            throw new Exception("No actions to undo.");
        } else {
            return "Action has been undone successfully.";
        }
    }

    /**
     * Hands off the work to use case to perform the redo action.
     */
    public String redo(String username) throws Exception {
        boolean result = this.inputBoundary.redo(username);
        if (!result) {
            throw new Exception("No actions to redo.");
        } else {
            return "Action has been redone successfully.";
        }
    }
}
