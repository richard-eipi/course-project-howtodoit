package commands;

import driver.DataAccessor;
import driver.DataManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class NewLabTest {
    private DataAccessor dataAccessor;
    private final NewProj newlabCommand = new NewProj();

    @BeforeEach
    public void setUp() {
        this.dataAccessor = new DataManager();
    }

    @Test
    public void testSuccessfullyAddedLab() {
        try {
            String[] args = {"CS"};
            this.newlabCommand.execute(this.dataAccessor, args);
            // Check that the system has this label
            Assertions.assertTrue(this.dataAccessor.getSystem().getProjects().containsKey("CS"),
                    "Failure: Label has not been added successfully");
        } catch (Exception e) {
            Assertions.fail("Failure: an unexpected Exception was thrown.");
        }


    }
}