package usecasesControllers;

public interface LoginRegisterInputBoundary {
    LoginRegisterUseCases.LoginResult login(String username, String password);

    LoginRegisterUseCases.RegisterResult register(String username, String password);
}
