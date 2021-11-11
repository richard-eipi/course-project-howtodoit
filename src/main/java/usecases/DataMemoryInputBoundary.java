package usecases;

public interface DataMemoryInputBoundary {
    /**
     * Save data.
     * @return
     */
    String save();

    /**
     * Undo the previous action.
     * @return boolean indicating whether success or failure
     */
    boolean undo();

    /**
     * Redo the action that was just undone.
     * @return boolean indicating whether success or failure
     */
    boolean redo();

    /**
     * Resets memory when user logs out.
     */
    void cleanMemory();

    /**
     * Sets the memento, liking taking a timestamp on current system.
     */
    void setTimeStamp();
}
