package usecases;

public interface DataMemoryInputBoundary {
    /**
     * Save data.
     */
    void save();

    /**
     * Undo the previous action.
     */
    void undo();

    /**
     * Redo the action that was just undone.
     */
    void redo();
}
