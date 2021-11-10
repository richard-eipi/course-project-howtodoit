package usecasesControllers;

import entities.User;

public class LoginRegisterUseCases implements LoginRegisterInputBoundary {
    private final UserList userList;
    public enum LoginResult {SUCCESS, FAILURE, NO_SUCH_USER}
    public enum RegisterResult {SUCCESS, FAILURE}

    public LoginRegisterUseCases(UserList userList) {
        this.userList = userList;
    }

    public LoginResult login(String username, String password) {
        User user = this.userList.getUser(username);
        if (user == null) return LoginResult.NO_SUCH_USER;
        if (!user.passwordMatches(password)) return LoginResult.FAILURE;
        return LoginResult.SUCCESS;
    }

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
