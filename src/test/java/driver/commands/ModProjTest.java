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


class ModProjTest {
    private final ModProj modProjCommand = new ModProj();
    private UserList userList = new UserList();

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        ProjectController.getInstance().setInputBoundary(new ProjectUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    @Test
    public void testSuccessfullyRenamedProj() {
        try {
            String[] args = {"Take Over", "Join Goats Club"};
            modProjCommand.execute("Nole", args);
            // Check that the project has been renamed
            User user = userList.getUser("Nole");
            Assertions.assertTrue(user.getProjectList().hasProject("Join Goats Club"),
                    "Failure: Project has not been renamed successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }
}