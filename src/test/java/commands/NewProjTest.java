package commands;

import driver.DataAccessor;
import driver.DataManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class NewProjTest {
    private DataAccessor dataAccessor;
    private final NewProj newprojCommand = new NewProj();

    @BeforeEach
    public void setUp() {
        this.dataAccessor = new DataManager();
    }

    @Test
    public void testSuccessfullyAddedProj() {
        try {
            String[] args = {"CSC207"};
            this.newprojCommand.execute(this.dataAccessor, args);
            // Check that the system has this project
            Assertions.assertTrue(this.dataAccessor.getSystem().getProjects().containsKey("CSC207"),
                    "Failure: Project has not been added successfully");
        } catch (Exception e) {
            Assertions.fail("Failure: an unexpected Exception was thrown.");
        }


    }
}
