package driver.commands;

import controllers.DataMemoryController;
import controllers.QueryController;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.QueryUseCases;
import usecases.managers.UserList;

import static org.junit.jupiter.api.Assertions.*;

class ViewTasksTest {
    private final ViewTasks viewTasksCommand = new ViewTasks();

    @BeforeEach
    void setUp() {
        UserList userList = TestingSystemSetUp.SetUp();
        QueryController.getInstance().setInputBoundary(new QueryUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

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