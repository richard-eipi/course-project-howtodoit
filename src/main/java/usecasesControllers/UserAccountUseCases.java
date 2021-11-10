package usecasesControllers;

public class UserAccountUseCases implements UserAccountInputBoundary {
    private final UserList userList;

    public UserAccountUseCases(UserList userList) {
        this.userList = userList;
    }
}
