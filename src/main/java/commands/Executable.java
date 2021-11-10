package commands;

import driver.DataSaver;

public interface Executable {
    String execute(DataSaver dataSaver, String[] args) throws Exception;
}
