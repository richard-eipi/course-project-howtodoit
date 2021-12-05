import controllers.QueryController;
import driver.cli.CommandExecutor;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import usecases.QueryUseCases;
import usecases.managers.UserList;

/**
 * This class is a test for class CommandExecutor
 */
class CommandExecutorTest {
    private final CommandExecutor commandExecutor = new CommandExecutor();

    /**
     * This test case tests if the commandExecuter can execute the command user inputted
     * This test case executes command viewProj
     * @result All projects of the user "Nole" will be returned
     */
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

    /**
     * This test case tests if the commandExecuter can execute a non-existing command user inputted
     * This test case executes command based on user's input
     * @result The command will not be executed
     */
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