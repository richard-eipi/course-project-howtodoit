package commands;

import driver.DataAccessor;
import todoSystem.TodoSystem;
import helpers.Memento;

/**
 * This class undos or redos actions
 */
public class Regret implements Executable {
    private Memento currentMemento;

    /**
     * This function executes the regret command: either undo an action or redo an action depending on user argument.
     * @param dataAccessor gives us TodoSystem
     * @param args a list of Strings with length 1, representing user arguments
     * @return a String indicating action has been undone/redone successfully
     * @throws Exception not allowed to undo/redo anymore
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) throws Exception {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(args); // Check whether arguments are valid

        if (args[0].equals("undo")) {
            return returnToPrevMemento(todoSystem);
        } else if (args[0].equals("redo")) {
            return returnToNextMemento(todoSystem);
        } else {
            this.setMemento(todoSystem);
            return "";
        }
    }

    private String returnToPrevMemento(TodoSystem todoSystem) throws Exception {
        Memento prevMemento = this.currentMemento.prev;
        if (prevMemento == null) {
            throw new Exception("No actions to undo.");
        } else {
            this.currentMemento = prevMemento;
            todoSystem.restore(prevMemento);
            return "Action has been undone successfully.";
        }
    }

    private String returnToNextMemento(TodoSystem todoSystem) throws Exception {
        Memento nextMemento = this.currentMemento.next;
        if (nextMemento == null) {
            throw new Exception("No actions to redo.");
        } else {
            this.currentMemento = nextMemento;
            todoSystem.restore(nextMemento);
            return "Action has been redone successfully.";
        }
    }

    private void setMemento(TodoSystem todoSystem) {
        if (this.currentMemento == null) {
            this.currentMemento = todoSystem.createMemento();
        } else {
            this.currentMemento.next = todoSystem.createMemento();
            this.currentMemento.next.prev = this.currentMemento;
            this.currentMemento = this.currentMemento.next;
        }
    }
}
