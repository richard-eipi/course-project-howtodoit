import controllers.DataMemoryController;
import entities.User;
import gateway.DataManager;
import gateway.DataSaver;
import helpers.TestingSystemSetUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecases.DataMemoryUseCases;
import usecases.LoginRegisterUseCases;
import usecases.managers.UserList;

import static org.junit.jupiter.api.Assertions.*;

class DataMemoryControllerTest {
    private UserList userList;
    private final DataMemoryController dataMemoryController = DataMemoryController.getInstance();

    /**
     * A mock class that does the data saving trick
     */
    static class MockDataSaver implements DataSaver {

        @Override
        public String writeData() {
            return "Successfully saved.";
        }
    }

    @BeforeEach
    void setUp() {
        userList = TestingSystemSetUp.SetUp();
        DataMemoryUseCases dataMemoryUseCases = new DataMemoryUseCases(userList);
        dataMemoryUseCases.setDataSaver(new MockDataSaver()); // inject DataSaver into that use case
        dataMemoryController.setInputBoundary(dataMemoryUseCases);
        dataMemoryController.setTimeStamp();
    }

    @Test
    public void testSave() {
        String msg = dataMemoryController.save();
        Assertions.assertEquals("Successfully saved.", msg,
                "Failure: Data has not been saved successfully.");
    }

    @Test
    public void testNoActionsToUndo() {
        String msg = dataMemoryController.undo();
        Assertions.assertEquals("No actions to undo.", msg,
                "Failure: Wrong message returned when there are no actions to undo.");
    }

    @Test
    public void testNoActionsToRedo() {
        String msg = dataMemoryController.redo();
        Assertions.assertEquals("No actions to redo.", msg,
                "Failure: Wrong message returned when there are no actions to redo.");
    }

    @Test
    public void testSuccessfulUndo() {
        userList.getUser("Nole").setName("Andy");
        dataMemoryController.setTimeStamp();
        dataMemoryController.undo();
        // Check that the action (changing Nole's username to Andy) has been undone
        Assertions.assertNotNull(userList.getUser("Nole"),
                "Failure: Action has not been undone successfully.");
    }

    @Test
    public void testSuccessfulRedo() {
        userList.getUser("Nole").setName("Andy");
        dataMemoryController.setTimeStamp();
        dataMemoryController.undo();
        dataMemoryController.redo();
        // Check that the action has been redone, assuming undo works
        Assertions.assertNotNull(userList.getUser("Andy"),
                "Failure: Action has not been undone successfully.");
    }
}