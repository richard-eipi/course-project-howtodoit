package controllers;

import constants.Enums;
import usecases.LoginRegisterInputBoundary;
/**
 * This class allows user to log in or register for a new account.
 */
public class LoginRegisterController {
    private static final LoginRegisterController instance = new LoginRegisterController();
    private LoginRegisterInputBoundary inputBoundary;

    public LoginRegisterController() {

    }

    public static LoginRegisterController getInstance() {
        return instance;
    }

    public void setInputBoundary(LoginRegisterInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Lets the user log in.
     *
     * @param username user's username
     * @param password user's password
     * @throws Exception fail to log in because user doesn't exist or password is incorrect
     */
    public void login(String username, String password) throws Exception {
        Enums.LoginResult loginResult = this.inputBoundary.login(username, password);
        if (loginResult == Enums.LoginResult.NO_SUCH_USER) throw new Exception("No such user!");
        if (loginResult == Enums.LoginResult.FAILURE) throw new Exception("Password incorrect!");
    }

    /**
     * Lets the user register for a new account.
     *
     * @param username user's username
     * @param password user's password
     * @throws Exception fail to register because duplicate user exists
     */
    public void register(String username, String password) throws Exception {
        Enums.RegisterResult registerResult = this.inputBoundary.register(username, password);
        if (registerResult == Enums.RegisterResult.FAILURE) throw new Exception("User already exists!");
    }
}
