package driver.commands;

import controllers.DataMemoryController;
import controllers.ProjectController;
import entities.User;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.ProjectUseCases;
import usecases.managers.UserList;


class NewProjTest {
    private final NewProj newProjCommand = new NewProj();
    private UserList userList = new UserList();

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        ProjectController.getInstance().setInputBoundary(new ProjectUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

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
