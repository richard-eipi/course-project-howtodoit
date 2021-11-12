package usecases;

public interface UserAccountInputBoundary {
    /**
     * Change username.
     *
     * @param username current username
     * @param newName  new username
     * @return boolean indicating whether success or failure
     */
    boolean modUsn(String username, String newName);

    /**
     * Change password.
     *
     * @param username current username
     * @param pw1      current password
     * @param pw2      new password
     * @return boolean indicating whether success or failure
     */
    boolean modPwd(String username, String pw1, String pw2);
}
