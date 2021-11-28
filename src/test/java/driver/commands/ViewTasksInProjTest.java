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


class ViewTasksInProjTest {
    private final ViewTasksInProj viewTasksInProjCommand = new ViewTasksInProj();

    @BeforeEach
    void setUp() {
        UserList userList = TestingSystemSetUp.SetUp();
        QueryController.getInstance().setInputBoundary(new QueryUseCases(userList));
    }

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
