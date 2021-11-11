package usecases;

import database.DataSaver;
import entities.Memento;
import entities.User;

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
     * Sets the memento, liking taking a timestamp on current system.
     */
    public void setMemento(String username) {
        User user = this.userList.getUser(username);
        if (this.currentMemento == null) {
            this.currentMemento = user.createMemento();
        } else {
            this.currentMemento.next = user.createMemento();
            this.currentMemento.next.prev = this.currentMemento;
            this.currentMemento = this.currentMemento.next;
        }
    }

    /**
     * Save data.
     */
    @Override
    public void save() {
        this.dataSaver.writeData();
    }

    /**
     * Undo the previous action.
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean undo(String username) {
        Memento prevMemento = this.currentMemento.prev;
        if (prevMemento == null) {
            return false;
        } else {
            this.currentMemento = prevMemento;
            this.userList.getUser(username).restore(prevMemento);
            return true;
        }
    }

    /**
     * Redo the action that was just undone.
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean redo(String username) {
        Memento nextMemento = this.currentMemento.next;
        if (nextMemento == null) {
            return false;
        } else {
            this.currentMemento = nextMemento;
            this.userList.getUser(username).restore(nextMemento);
            return true;
        }
    }
}
