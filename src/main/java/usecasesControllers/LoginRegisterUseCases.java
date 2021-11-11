package usecasesControllers;

import entities.User;

/**
 * This class deals with login and register use cases.
 */
public class LoginRegisterUseCases implements LoginRegisterInputBoundary {
    private final UserList userList;
    public enum LoginResult {SUCCESS, FAILURE, NO_SUCH_USER}
    public enum RegisterResult {SUCCESS, FAILURE}

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
    public LoginResult login(String username, String password) {
        User user = this.userList.getUser(username);
        if (user == null) return LoginResult.NO_SUCH_USER;
        if (user.passwordMatches(password)) {
            return LoginResult.SUCCESS;
        } else {
            return LoginResult.FAILURE;
        }

    }

    /**
     * Lets the user register for a new account.
     * @param username user's username
     * @param password user's password
     * @return RegisterResult indicating whether success, failure, or no such user
     */
    @Override
    public RegisterResult register(String username, String password) {
        User user = this.userList.getUser(username);
        if (user != null) {
            return RegisterResult.FAILURE;
        } else {
            userList.addUser(new User(username, password));
            return RegisterResult.SUCCESS;
        }
    }
}
