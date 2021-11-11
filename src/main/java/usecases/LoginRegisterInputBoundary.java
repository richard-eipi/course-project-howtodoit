package usecases;

import constants.Enums;

public interface LoginRegisterInputBoundary {
    /**
     * Lets the user log in.
     * @param username user's username
     * @param password user's password
     * @return LoginResult indicating whether success, failure, or no such user
     */
    Enums.LoginResult login(String username, String password);

    /**
     * Lets the user register for a new account.
     * @param username user's username
     * @param password user's password
     * @return RegisterResult indicating whether success, failure, or no such user
     */
    Enums.RegisterResult register(String username, String password);
}
