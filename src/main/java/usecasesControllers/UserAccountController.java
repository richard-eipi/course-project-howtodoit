package usecasesControllers;

public class UserAccountController {
    private static final UserAccountController instance = new UserAccountController();
    private UserAccountInputBoundary inputBoundary;

    public UserAccountController() {

    }

    public static UserAccountController getInstance(){
        return instance;
    }

    public void setInputBoundary(UserAccountInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }
}
