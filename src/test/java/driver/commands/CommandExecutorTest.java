package driver.commands;

import controllers.QueryController;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import usecases.QueryUseCases;
import usecases.managers.UserList;

import static org.junit.jupiter.api.Assertions.*;

class CommandExecutorTest {
    private final CommandExecutor commandExecutor = new CommandExecutor();

    @Test
    public void testSuccessfullyExecutedCommand() {
        try {
            UserList userList = TestingSystemSetUp.SetUp();
            QueryController.getInstance().setInputBoundary(new QueryUseCases(userList));
            commandExecutor.setUsername("Nole");
            String arg = "viewProj";
            commandExecutor.executeCommand(arg);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    @Test
    public void testCommandNotFound() {
        try {
            String arg = "dosomething;adksfjaksdf";
            commandExecutor.executeCommand(arg);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }
}