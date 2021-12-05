import controllers.DataMemoryController;
import controllers.ProjectController;
import driver.commands.NewProj;
import entities.User;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.ProjectUseCases;
import usecases.managers.UserList;

/**
 * This class is a test for class NewProj
 */
class NewProjTest {
    private final NewProj newProjCommand = new NewProj();
    private UserList userList = new UserList();

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        ProjectController.getInstance().setInputBoundary(new ProjectUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    /**
     * This test case tests if a new project can be created
     * This test case executes the newProj command: create a new project with given params
     * @result A new project called "Recover" will be created
     */
    @Test
    public void testSuccessfullyAddedProj() {
        try {
            String[] args = {"Recover"};
            newProjCommand.execute("Rafa", args);
            // Check that the system has this project
            User user = userList.getUser("Rafa");
            Assertions.assertTrue(user.getProjectList().hasProject("Recover"),
                    "Failure: Project has not been added successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    /**
     * This test case tests if a same project name can be repetitively used
     * This test case executes the newProj command: create a new project with given params
     * @result This action will not be performed since project "General" already exists
     */
    @Test
    public void testProjAlreadyExists() {
        try {
            String[] args = {"General"};
            newProjCommand.execute("Rafa", args);
            Assertions.fail("Failure: Expected Exception has not been thrown.");
        } catch (Exception ignored) {
        }
    }

}
