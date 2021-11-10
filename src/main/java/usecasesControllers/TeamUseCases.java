package usecasesControllers;

public class TeamUseCases implements TeamInputBoundary {
    private final UserList userList;

    public TeamUseCases(UserList userList) {
        this.userList = userList;
    }

    @Override
    public boolean newTeam(String username, String teamName) {
        return false;
    }

    @Override
    public boolean delTeam(String username, String teamName) {
        return false;
    }

    @Override
    public boolean modTeam(String username, String name1, String name2) {
        return false;
    }

    @Override
    public boolean addMem(String username, String teamName, String memName) {
        return false;
    }

    @Override
    public boolean delMem(String username, String teamName, String memName) {
        return false;
    }

    @Override
    public boolean addAdmin(String username, String teamName, String memName) {
        return false;
    }
}
