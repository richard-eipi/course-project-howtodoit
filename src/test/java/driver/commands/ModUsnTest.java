package driver.commands;

import controllers.DataMemoryController;
import controllers.UserAccountController;
import entities.User;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.UserAccountUseCases;
import usecases.managers.UserList;


class ModUsnTest {
    private final ModUsn modUsnCommand = new ModUsn();
    private UserList userList = new UserList();

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        UserAccountController.getInstance().setInputBoundary(new UserAccountUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    @Test
    public void testSuccessfullyChangedUsn() {
        try {
            User user = userList.getUser("Rafa");
            String[] args = {"Nadal"};
            modUsnCommand.execute("Rafa", args);
            // Check that the username has been changed
            Assertions.assertEquals("Nadal", user.getName(),
                    "Failure: Username has not been changed successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testNewNameAlreadyExists() {
        try {
            String[] args = {"Roge"};
            modUsnCommand.execute("Nole", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }
}