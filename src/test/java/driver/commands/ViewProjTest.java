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


class ViewProjTest {
    private final ViewProj viewProjCommand = new ViewProj();

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
            String result = viewProjCommand.execute("Nole", args);
            String actual = "You have the following projects:\nAssigned to me\nGeneral\nTake Over\n";
            // Check that the returned String is correct
            Assertions.assertEquals(result, actual,
                    "Failure: Failed to show projects successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

}