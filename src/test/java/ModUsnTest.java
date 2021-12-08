import controllers.DataMemoryController;
import controllers.UserAccountController;
import driver.commands.ModUsn;
import entities.User;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.UserAccountUseCases;
import usecases.managers.UserList;

/**
 * This class is a test for class ModUsn
 */
class ModUsnTest {
    private final ModUsn modUsnCommand = new ModUsn();
    private UserList userList = new UserList();

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        UserAccountController.getInstance().setInputBoundary(new UserAccountUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    /**
     * This test case tests if an existing user can change the username
     * This test case executes the modUsn command: modify the username from its current name to <name>
     *
     * @result The username of "Rafa" will be changed to "Nadal"
     */
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

    /**
     * This test case tests if the same username can be used by more than one user
     * This test case executes the modUsn command: modify the username from its current name to <name>
     *
     * @result This action will not be performed since username "Nole" is already in use
     */
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