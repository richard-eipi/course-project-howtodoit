package driver.gui;

import controllers.LoginRegisterController;

public class LoginExecutor {
    public void executeCommand(String username, String pw) throws Exception{
        if (username == null | pw == null) {
            throw new Exception("Please fill in the box");
        }

        LoginRegisterController.getInstance().login(username, pw);
    }
}