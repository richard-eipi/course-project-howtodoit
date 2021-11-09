package todoSystem;

import java.util.HashMap;
import java.util.List;

/**
 * This class represents a UserList.
 * A UserList stores a collection of Users,
 */
public class UserList {
    private static final UserList instance = new UserList();
    private HashMap<String, User> users;

    public static UserList getInstance() {
        return instance;
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public User getUser(String name) {
        return this.users.get(name);
    }

    public void addUser(User user) {
        this.users.put(user.getName(), user);
    }
}
