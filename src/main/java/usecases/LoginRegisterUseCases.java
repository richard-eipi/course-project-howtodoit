package usecases;

import constants.Enums;
import entities.Project;
import entities.User;

/**
 * This class deals with login and register use cases.
 */
public class LoginRegisterUseCases implements LoginRegisterInputBoundary {
    private final UserList userList;

    public LoginRegisterUseCases(UserList userList) {
        this.userList = userList;
    }

    /**
     * Lets the user log in.
     * @param username user's username
     * @param password user's password
     * @return LoginResult indicating whether success, failure, or no such user
     */
    @Override
    public Enums.LoginResult login(String username, String password) {
        User user = this.userList.getUser(username);
        if (user == null) {
            return Enums.LoginResult.NO_SUCH_USER;
        } else if (user.passwordMatches(password)) {
            return Enums.LoginResult.SUCCESS;
        } else {
            return Enums.LoginResult.FAILURE;
        }

    }

    /**
     * Lets the user register for a new account.
     * @param username user's username
     * @param password user's password
     * @return RegisterResult indicating whether success or failure
     */
    @Override
    public Enums.RegisterResult register(String username, String password) {
        if (this.userList.getUser(username) != null) {
            return Enums.RegisterResult.FAILURE; // user already exists
        } else {
            User user = new User(username, password);
            user.addProject(new Project("General"));
            user.addProject(new Project("Assigned to me"));
            userList.addUser(user);
            return Enums.RegisterResult.SUCCESS;
        }
    }
}
