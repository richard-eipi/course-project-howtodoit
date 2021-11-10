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

    public String modUsn(String username, String newName) throws Exception {
        boolean result = this.inputBoundary.modUsn(username, newName);
        if (result) {
            return "Username changed successfully.";
        } else {
            throw new Exception("This new username already exists.");
        }
    }

    public String modPwd(String username, String pw1, String pw2) throws Exception {
        boolean result = this.inputBoundary.modPwd(username, pw1, pw2);
        if (result) {
            return "Password changed successfully.";
        } else {
            throw new Exception("Current password incorrect. Failure to change password.");
        }
    }
}
