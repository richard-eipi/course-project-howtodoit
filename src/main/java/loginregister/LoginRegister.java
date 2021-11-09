package loginregister;

import java.security.AuthProvider;

public class LoginRegister {
    private static final LoginRegister instance = new LoginRegister();

    public static LoginRegister getInstance(){
        return instance;
    }

    public void login(String username, String password) throws Exception {
        User user = UserList.getInstance().getUser(username);
        if (user == null) throw new Exception("No such user!");
        if (!user.passwordMatches(password)) throw new Exception("Password incorrect!");
    }

    public void register(String username, String password) throws Exception {

    }
}
