package usecases;

public interface DataMemoryInputBoundary {
    /**
     * Save data.
     */
    void save();

    /**
     * Undo the previous action.
     * @param username current username
     * @return boolean indicating whether success or failure
     */
    boolean undo(String username);

    /**
     * Redo the action that was just undone.
     * @param username current username
     * @return boolean indicating whether success or failure
     */
    boolean redo(String username);
}
