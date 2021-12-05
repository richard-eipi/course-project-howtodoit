import controllers.QueryController;
import driver.commands.ViewTasks;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.QueryUseCases;
import usecases.managers.UserList;

/**
 * This class is a test for class ViewTasks
 */
class ViewTasksTest {
    private final ViewTasks viewTasksCommand = new ViewTasks();

    @BeforeEach
    void setUp() {
        UserList userList = TestingSystemSetUp.SetUp();
        QueryController.getInstance().setInputBoundary(new QueryUseCases(userList));
    }

    /**
     * This test case tests if ViewTasks shows all upcoming tasks in all projects in chronological order
     * This test case executes the viewTasks command: show all upcoming tasks in all projects in chronological order
     * for the user; starred tasks will have stars in front of them
     * @result The returned string will be
     * "You have the following upcoming tasks:\nPractice: due on 2021-12-15; in project <General>; description: \n",
     * assertion will be true
     */
    @Test
    public void testSuccessfullyShowedProjects() {
        try {
            String[] args = {};
            String result = viewTasksCommand.execute("Rafa", args);
            String actual = "You have the following upcoming tasks:\nPractice: due on 2021-12-15; in project <General>; description: \n";
            // Check that the returned String is correct
            Assertions.assertEquals(result, actual,
                    "Failure: Failed to show tasks successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }
}