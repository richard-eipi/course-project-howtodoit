import controllers.DataMemoryController;
import controllers.UserAccountController;
import driver.commands.ModPwd;
import entities.User;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.UserAccountUseCases;
import usecases.managers.UserList;


class ModPwdTest {
    private final ModPwd modPwdCommand = new ModPwd();
    private UserList userList = new UserList();

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        UserAccountController.getInstance().setInputBoundary(new UserAccountUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    @Test
    public void testSuccessfullyChangedPwd() {
        try {
            String[] args = {"1986", "kingofclay"};
            modPwdCommand.execute("Rafa", args);
            // Check that the password has been changed
            User user = userList.getUser("Rafa");
            Assertions.assertTrue(user.passwordMatches("kingofclay"),
                    "Failure: Password has not been changed successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testCurrentPwdIncorrect() {
        try {
            String[] args = {"kingofclay", "1986"};
            modPwdCommand.execute("Rafa", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }
}