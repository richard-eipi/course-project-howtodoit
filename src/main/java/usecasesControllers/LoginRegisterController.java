package usecasesControllers;

public class LoginRegisterController {
    private static final LoginRegisterController instance = new LoginRegisterController();
    private LoginRegisterInputBoundary inputBoundary;

    public LoginRegisterController() {

    }

    public static LoginRegisterController getInstance(){
        return instance;
    }

    public void setInputBoundary(LoginRegisterInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public void login(String username, String password) throws Exception {
        LoginRegisterUseCases.LoginResult loginResult = this.inputBoundary.login(username, password);
        if (loginResult == LoginRegisterUseCases.LoginResult.NO_SUCH_USER) throw new Exception("No such user!");
        if (loginResult == LoginRegisterUseCases.LoginResult.FAILURE) throw new Exception("Password incorrect!");
    }

    public void register(String username, String password) throws Exception {
        LoginRegisterUseCases.RegisterResult registerResult = this.inputBoundary.register(username, password);
        if (registerResult == LoginRegisterUseCases.RegisterResult.FAILURE) throw new Exception("User already exists!");
    }
}
