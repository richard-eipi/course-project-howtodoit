package usecases;

import database.DataSaver;

public class DataMemoryUseCases implements DataMemoryInputBoundary {
    private final UserList userList;
    private DataSaver dataSaver;

    public DataMemoryUseCases(UserList userList) {
        this.userList = userList;
    }

    public void setDataSaver(DataSaver dataSaver) {
        this.dataSaver = dataSaver;
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
     */
    @Override
    public void undo() {

    }

    /**
     * Redo the action that was just undone.
     */
    @Override
    public void redo() {

    }
}
