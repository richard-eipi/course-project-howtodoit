package driver.commands;

import controllers.LoginRegisterController;
import entities.User;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.LoginRegisterUseCases;
import usecases.managers.UserList;


class LoginRegisterExecutorTest {
    private final LoginRegisterExecutor loginRegisterExecutor = new LoginRegisterExecutor();

    @BeforeEach
    void setUp() {
        UserList userList = TestingSystemSetUp.SetUp();
        LoginRegisterController.getInstance().setInputBoundary(new LoginRegisterUseCases(userList));
    }

    @Test
    public void testSuccessfullyLoggedIn() {
        try {
            String arg = "login;Nole;1987";
            String username = loginRegisterExecutor.executeCommand(arg);
            // Check that the returned username is correct
            Assertions.assertEquals(username, "Nole",
                    "Failure: User logged into a different account.");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testNoSuchUser() {
        try {
            String arg = "login;Andy;1987";
            loginRegisterExecutor.executeCommand(arg);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    @Test
    public void testIncorrectPwd() {
        try {
            String arg = "login;Rafa;kingofclay";
            loginRegisterExecutor.executeCommand(arg);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    @Test
    public void testSuccessfullyRegistered() {
        try {
            String arg = "register;Andy;1987";
            loginRegisterExecutor.executeCommand(arg);
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testUserAlreadyExists() {
        try {
            String arg = "register;Rafa;kingofclay";
            loginRegisterExecutor.executeCommand(arg);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    @Test
    public void testCommandNotFound() {
        try {
            String arg = "Login;Rafa;1986";
            loginRegisterExecutor.executeCommand(arg);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

    @Test
    public void testWrongArgLength() {
        try {
            String arg = "login;Rafa;1986;kingofclay";
            loginRegisterExecutor.executeCommand(arg);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }
}