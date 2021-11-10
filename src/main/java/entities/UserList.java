package entities;

import java.io.Serializable;
import java.util.HashMap;

/**
 * This class represents a UserList.
 * A UserList stores a collection of Users,
 */
public class UserList implements Serializable {
    private static final UserList instance = new UserList();
    private HashMap<String, User> users;

    public static UserList getInstance() {
        return instance;
    }

    public User getUser(String name) {
        return this.users.getOrDefault(name, null);
    }

    public void addUser(User user) {
        this.users.put(user.getName(), user);
    }
}
