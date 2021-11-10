package usecasesControllers;

public interface LoginRegisterInputBoundary {
    /**
     * Lets the user log in.
     * @param username user's username
     * @param password user's password
     * @return LoginResult indicating whether success, failure, or no such user
     */
    LoginRegisterUseCases.LoginResult login(String username, String password);

    /**
     * Lets the user register for a new account.
     * @param username user's username
     * @param password user's password
     * @return RegisterResult indicating whether success, failure, or no such user
     */
    LoginRegisterUseCases.RegisterResult register(String username, String password);
}
