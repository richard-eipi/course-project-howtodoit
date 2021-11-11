package usecases;

import database.DataSaver;
import entities.Memento;

public class DataMemoryUseCases implements DataMemoryInputBoundary {
    private final UserList userList;
    private DataSaver dataSaver;
    private Memento currentMemento;

    public DataMemoryUseCases(UserList userList) {
        this.userList = userList;
    }

    public void setDataSaver(DataSaver dataSaver) {
        this.dataSaver = dataSaver;
    }

    /**
     * Save data.
     * @return String indicating success or failure
     */
    @Override
    public String save() {
        return this.dataSaver.writeData();
    }

    /**
     * Undo the previous action.
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
