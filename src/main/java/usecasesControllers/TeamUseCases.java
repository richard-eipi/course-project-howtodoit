package usecasesControllers;

public class TeamUseCases implements TeamInputBoundary {
    private final UserList userList;

    public TeamUseCases(UserList userList) {
        this.userList = userList;
    }
}
