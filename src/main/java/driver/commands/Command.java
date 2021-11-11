package driver.commands;

public interface Command {

    String execute(String username, String[] args) throws Exception;

}
