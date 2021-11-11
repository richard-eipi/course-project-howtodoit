package driver.commands;

import database.DataSaver;
import database.DataManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class NewLabTest {
    private DataSaver dataSaver;
    private final NewProj newlabCommand = new NewProj();

    @BeforeEach
    public void setUp() {
        this.dataSaver = new DataManager();
    }

    @Test
    public void testSuccessfullyAddedLab() {
        try {
            String[] args = {"CS"};
            this.newlabCommand.execute(this.dataSaver, args);
            // Check that the system has this label
            Assertions.assertTrue(this.dataSaver.getSystem().getProjects().containsKey("CS"),
                    "Failure: Label has not been added successfully");
        } catch (Exception e) {
            Assertions.fail("Failure: an unexpected Exception was thrown.");
        }


    }
}