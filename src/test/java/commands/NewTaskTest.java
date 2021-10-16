package commands;

import driver.DataAccessor;
import driver.DataManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NewTaskTest {
    private DataAccessor dataAccessor;
    private final NewTask newtaskCommand = new NewTask();

    @BeforeEach
    void setUp() {
        this.dataAccessor = new DataManager();
    }

    @Test
    public void testSuccessfullyAddedTask() {
        try {
            String[] args = {"Phase 0"};
            this.newtaskCommand.execute(this.dataAccessor, args);
            // Check that the system has this task
            Assertions.assertTrue(this.dataAccessor.getSystem().getTasks().containsKey("Phase 0"),
                    "Failure: Task has not been added successfully");
        } catch (Exception e) {
            Assertions.fail("Failure: An unexpected Exception was thrown.");
        }
    }
}

