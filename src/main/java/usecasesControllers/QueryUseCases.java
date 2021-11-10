package usecasesControllers;

public class QueryUseCases implements QueryInputBoundary {
    private final UserList userList;

    public QueryUseCases(UserList userList) {
        this.userList = userList;
    }
}
