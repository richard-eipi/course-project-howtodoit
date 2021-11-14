package usecases;

import database.DataSaver;
import entities.Memento;

/**
 * This class deals with data memory use cases.
 */
public class DataMemoryUseCases implements DataMemoryInputBoundary {
    /**
     * The list of users.
     */
    private final UserList userList;
    /**
     * The data saver interface.
     */
    private DataSaver dataSaver;
    /**
     * The current memento object, storing a copy of the system.
     */
    private Memento currentMemento;

    /**
     * Constructor.
     * @param userList the list of users
     */
    public DataMemoryUseCases(UserList userList) {
        this.userList = userList;
    }

    /**
     * Sets the data saver interface.
     * @param dataSaver the data saver interface
     */
    public void setDataSaver(DataSaver dataSaver) {
        this.dataSaver = dataSaver;
    }

    /**
     * Save data.
     *
     * @return String indicating success or failure
     */
    @Override
    public String save() {
        return this.dataSaver.writeData();
    }

    /**
     * Undo the previous action.
     *
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean undo() {
        Memento prevMemento = this.currentMemento.prev;
        if (prevMemento == null) {
            return false;
        } else {
            this.currentMemento = prevMemento;
            this.userList.restore(prevMemento);
            return true;
        }
    }

    /**
     * Redo the action that was just undone.
     *
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean redo() {
        Memento nextMemento = this.currentMemento.next;
        if (nextMemento == null) {
            return false;
        } else {
            this.currentMemento = nextMemento;
            this.userList.restore(nextMemento);
            return true;
        }
    }

    /**
     * Resets memory when user logs out.
     */
    @Override
    public void cleanMemory() {
        this.currentMemento = null;
    }

    /**
     * Sets the memento, liking taking a timestamp on current system.
     */
    @Override
    public void setTimeStamp() {
        if (this.currentMemento == null) {
            this.currentMemento = this.userList.createMemento();
        } else {
            this.currentMemento.next = this.userList.createMemento();
            this.currentMemento.next.prev = this.currentMemento;
            this.currentMemento = this.currentMemento.next;
        }
    }
}
