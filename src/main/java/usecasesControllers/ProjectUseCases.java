package usecasesControllers;

public class ProjectUseCases implements ProjectInputBoundary {
    private final UserList userList;

    public ProjectUseCases(UserList userList) {
        this.userList = userList;
    }
}
