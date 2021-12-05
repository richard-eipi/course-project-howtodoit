import controllers.DataMemoryController;
import controllers.QueryController;
import driver.commands.ViewTasksInProj;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.QueryUseCases;
import usecases.managers.UserList;

/**
 * This class is a test for class ViewTasksInProj
 */
class ViewTasksInProjTest {
    private final ViewTasksInProj viewTasksInProjCommand = new ViewTasksInProj();

    @BeforeEach
    void setUp() {
        UserList userList = TestingSystemSetUp.SetUp();
        QueryController.getInstance().setInputBoundary(new QueryUseCases(userList));
    }

    /**
     * This test case tests if ViewTasksInProj shows all tasks in a particular project
     * This test case executes the viewTasksInProj command: show all tasks in the project called <name>
     * @result The returned string will be
     * "This project <General> contains the following tasks:\nPractice: due on 2021-12-15; in project <General>;
     * description: \n", assertion will be true
     */
    @Test
    public void testSuccessfullyShowedTasks() {
        try {
            String[] args = {"General"};
            String result = viewTasksInProjCommand.execute("Rafa", args);
            String actual = "This project <General> contains the following tasks:\nPractice: due on 2021-12-15; in project <General>; description: \n";
            // Check that the returned String is correct
            Assertions.assertEquals(result, actual,
                    "Failure: Failed to show tasks in project successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

}
