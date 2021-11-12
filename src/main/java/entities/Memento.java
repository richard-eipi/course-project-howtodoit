package entities;

import usecases.UserList;

import java.util.HashMap;

/**
 * This class is the core object of the Memento Design Pattern.
 * It stores the state of entities and allows us to revert to this state later.
 */
public class Memento {
    public Memento prev;
    public Memento next;

    // The current state of the system.
    private HashMap<String, User> userListCopy;

    public HashMap<String, User> getState() {
        return this.userListCopy;
    }

    public void setState(UserList userList) {
        this.userListCopy = userList.copy();
    }

}
