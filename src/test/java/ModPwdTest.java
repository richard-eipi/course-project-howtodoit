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

/**
 * This class is a test for class ModPwd
 */
class ModPwdTest {
    private final ModPwd modPwdCommand = new ModPwd();
    private UserList userList = new UserList();

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        UserAccountController.getInstance().setInputBoundary(new UserAccountUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    /**
     * This test case tests if a user's password can be modified
     * This test case executes the modPwd command: modify the password from <pw1> to <pw2>
     *
     * @result The password of user "Rafa" will be changed to "kingofclay"
     */
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

    /**
     * This test case tests if a user's password can be modified if the current password that the user inputted is wrong
     * This test case executes the modPwd command: modify the password from <pw1> to <pw2>
     *
     * @result This action will not be performed since the current password that "Rafa" inputted is wrong
     */
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