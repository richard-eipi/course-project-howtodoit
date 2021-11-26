package entities;

import usecases.managers.UserList;

import java.util.HashMap;

/**
 * This class is the core object of the Memento Design Pattern.
 * It stores the state of entities and allows us to revert to this state later.
 */
public class Memento {
    /**
     * The previous memento object. Go back to this one if undo.
     */
    public Memento prev;
    /**
     * The next memento object. Go to this one if redo.
     */
    public Memento next;

    // The current state of the system.
    private HashMap<String, User> userListCopy;

    /**
     * Returns the state of the system stored.
     *
     * @return copy of the state of user list
     */
    public HashMap<String, User> getState() {
        return this.userListCopy;
    }

    /**
     * Timestamps the state of the current system.
     *
     * @param userList the list of users
     */
    public void setState(UserList userList) {
        this.userListCopy = userList.copy();
    }

}
