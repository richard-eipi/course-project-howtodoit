package entities;

import usecases.UserList;

import java.util.HashMap;
import java.util.List;

/**
 * This class is the core object of the Memento Design Pattern.
 * It stores the state of entities and allows us to revert to this state later.
 */
public class Memento {
    public Memento prev;
    public Memento next;

    // The state of the current user.
    private User userCopy;

    /**
     * Saves the current state of the user.
     * @param user current user
     */
    public void setState(User user) {
        this.userCopy = user.copy();
    }

    public User getState() {
        return this.userCopy;
    }

}
