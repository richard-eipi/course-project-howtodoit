package usecases;

import entities.User;

import java.io.Serializable;
import java.util.HashMap;

/**
 * This class represents a UserList.
 * A UserList stores a collection of Users,
 */
public class UserList implements Serializable {
    private HashMap<String, User> users;

    public User getUser(String name) {
        return this.users.getOrDefault(name, null);
    }

    public void addUser(User user) {
        this.users.put(user.getName(), user);
    }
}
