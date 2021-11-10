package usecasesControllers;

public class QueryUseCases implements QueryInputBoundary {
    private final UserList userList;

    public QueryUseCases(UserList userList) {
        this.userList = userList;
    }

    @Override
    public String viewTeams(String username) {
        return null;
    }

    @Override
    public String viewMemsIn(String username, String teamName) {
        return null;
    }

    @Override
    public String viewProjs(String username) {
        return null;
    }

    @Override
    public String viewTasks(String username) {
        return null;
    }

    @Override
    public String viewTasksInProj(String username, String projName) {
        return null;
    }
}
