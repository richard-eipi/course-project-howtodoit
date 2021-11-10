package usecasesControllers;

public class TaskUseCases implements TaskInputBoundary {
    private final UserList userList;

    public TaskUseCases(UserList userList) {
        this.userList = userList;
    }
}
