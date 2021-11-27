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


class DelProjTest {
    private final DelProj delProjCommand = new DelProj();
    private UserList userList = new UserList();

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        ProjectController.getInstance().setInputBoundary(new ProjectUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    @Test
    public void testSuccessfullyDeletedProj() {
        try {
            String[] args = {"Take Over"};
            delProjCommand.execute("Nole", args);
            // Check that the system no longer has this project
            User user = userList.getUser("Nole");
            Assertions.assertFalse(user.getProjectList().hasProject("Take Over"),
                    "Failure: Project has not been deleted successfully");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }
}