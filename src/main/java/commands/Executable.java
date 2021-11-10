package commands;

import driver.DataSaver;

public interface Executable {
    String execute(String username, String[] args) throws Exception;
}
