import controllers.LoginRegisterController;
import driver.cli.LoginRegisterExecutor;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.LoginRegisterUseCases;
import usecases.managers.UserList;

/**
 * This class is a test for class LoginRegisterExecuter
 */
class LoginRegisterExecutorTest {
    @BeforeEach
    void setUp() {
        UserList userList = TestingSystemSetUp.SetUp();
        LoginRegisterController.getInstance().setInputBoundary(new LoginRegisterUseCases(userList));
    }

    /**
     * This test case tests if an existing user can successfully login
     * This test case executes login
     * @result The user "Nole" will be logged in
     */
    @Test
    public void testSuccessfullyLoggedIn() {
        try {
            String arg = "login;Nole;1987";
            String username = LoginRegisterExecutor.executeCommand(arg);
            // Check that the returned username is correct
            Assertions.assertEquals(username, "Nole",
                    "Failure: User logged into a different account.");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    /**
     * This test case tests if a non-existing user can login
     * This test case executes login
     * @result This action will not be performed because the user "Andy" does not exist
     */
    @Test
    public void testNoSuchUser() {
        try {
            String arg = "login;Andy;1987";
            LoginRegisterExecutor.executeCommand(arg);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    /**
     * This test case tests if an existing user can successfully login with wrong password
     * This test case executes login
     * @result The action will not be performed since the password is wrong
     */
    @Test
    public void testIncorrectPwd() {
        try {
            String arg = "login;Rafa;kingofclay";
            LoginRegisterExecutor.executeCommand(arg);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    /**
     * This test case tests if a new user can ve registered
     * This test case executes register
     * @result A new user "Andy" will be registered
     */
    @Test
    public void testSuccessfullyRegistered() {
        try {
            String arg = "register;Andy;1987";
            LoginRegisterExecutor.executeCommand(arg);
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    /**
     * This test case tests if an existing user can be registered again
     * This test case executes register
     * @result This action will not be performed since the user "Rafa" already exists
     */
    @Test
    public void testUserAlreadyExists() {
        try {
            String arg = "register;Rafa;kingofclay";
            LoginRegisterExecutor.executeCommand(arg);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    /**
     * This test case tests if the username can be null or "" when registered
     * This test case executes register
     * @result This action will not be performed since we do not allow empty username
     */
    @Test
    public void testNullUser() {
        try {
            String arg = "register;;1234";
            LoginRegisterExecutor.executeCommand(arg);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    /**
     * This test case tests if non-existing command can be executed
     * This test case executes either login or register based on user input
     * @result This action will not be performed since the command is wrong
     */
    @Test
    public void testCommandNotFound() {
        try {
            String arg = "Login;Rafa;1986";
            LoginRegisterExecutor.executeCommand(arg);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    /**
     * This test case tests if a user can be logged in with wrong argument length
     * This test case executes login
     * @result This action will not be performed since the argument length is incorrect
     */
    @Test
    public void testWrongArgLength() {
        try {
            String arg = "login;Rafa;1986;kingofclay";
            LoginRegisterExecutor.executeCommand(arg);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }
}