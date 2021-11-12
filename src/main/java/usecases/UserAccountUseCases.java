package usecases;

import entities.User;

public class UserAccountUseCases implements UserAccountInputBoundary {
    private final UserList userList;

    public UserAccountUseCases(UserList userList) {
        this.userList = userList;
    }

    /**
     * Change username.
     *
     * @param username current username
     * @param newName  new username
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean modUsn(String username, String newName) {
        User user = this.userList.getUser(username);
        if (this.userList.getUser(newName) != null) {
            return false;
        } else {
            user.setName(newName);
            return true;
        }
    }

    /**
     * Change password.
     *
     * @param username current username
     * @param pw1      current password
     * @param pw2      new password
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean modPwd(String username, String pw1, String pw2) {
        User user = this.userList.getUser(username);
        if (!user.passwordMatches(pw1)) {
            return false;
        } else {
            user.setPassword(pw2);
            return true;
        }
    }
}
