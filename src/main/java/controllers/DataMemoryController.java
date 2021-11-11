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
    public void undo() {
        this.inputBoundary.undo();
    }

    /**
     * Hands off the work to use case to perform the redo action.
     */
    public void redo() {
        this.inputBoundary.redo();
    }
}
