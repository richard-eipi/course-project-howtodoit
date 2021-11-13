package controllers;

import usecases.DataMemoryInputBoundary;
/**
 * This class performs the undo and redo action, and decides to clean or save the data.
 */
public class DataMemoryController {
    private static final DataMemoryController instance = new DataMemoryController();
    private DataMemoryInputBoundary inputBoundary;

    public DataMemoryController() {

    }

    public static DataMemoryController getInstance() {
        return instance;
    }

    public void setInputBoundary(DataMemoryInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Hands off the work to use case to save data.
     */
    public String save() {
        return this.inputBoundary.save();
    }

    /**
     * Hands off the work to use case to perform the undo action.
     */
    public String undo() {
        boolean result = this.inputBoundary.undo();
        if (!result) {
            return "No actions to undo.";
        } else {
            return "Action has been undone successfully.";
        }
    }

    /**
     * Hands off the work to use case to perform the redo action.
     */
    public String redo() {
        boolean result = this.inputBoundary.redo();
        if (!result) {
            return "No actions to redo.";
        } else {
            return "Action has been redone successfully.";
        }
    }

    /**
     * Resets memory when user logs out.
     */
    public void cleanMemory() {
        this.inputBoundary.cleanMemory();
    }

    /**
     * Take a timestamp on current system so that we can return to it later on.
     */
    public void setTimeStamp() {
        this.inputBoundary.setTimeStamp();
    }
}
