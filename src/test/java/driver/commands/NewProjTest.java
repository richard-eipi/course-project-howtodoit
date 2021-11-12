package driver.commands;

import controllers.DataMemoryController;
import controllers.ProjectController;
import controllers.TaskController;
import entities.Project;
import entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.ProjectUseCases;
import usecases.TaskUseCases;
import usecases.UserList;


class NewProjTest {
    private final NewProj newprojCommand = new NewProj();
    private UserList userList = new UserList();
    private final String username = "Eipi";

    @BeforeEach
    void setUp() {
        userList = new UserList();
        User user = new User(username, "+1=0");
        userList.addUser(user);
        user.addProject(new Project("CSC207"));
        ProjectController.getInstance().setInputBoundary(new ProjectUseCases(userList));
        DataMemoryController.getInstance().setInputBoundary(new DataMemoryUseCases(userList));
    }

    @Test
    public void testSuccessfullyAddedProj() {
        try {
            String projName = "CSC236";
            String[] args = {projName};
            newprojCommand.execute(username, args);
            // Check that the system has this project
            User user = userList.getUser(username);
            Assertions.assertTrue(user.hasProject(projName),
                    "Failure: Project has not been added successfully");
        } catch (Exception e) {
            Assertions.fail("Failure: an unexpected Exception was thrown.");
        }
    }
}
