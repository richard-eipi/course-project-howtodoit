package usecasesControllers;

public class ProjectUseCases implements ProjectInputBoundary {
    private final UserList userList;

    public ProjectUseCases(UserList userList) {
        this.userList = userList;
    }

    @Override
    public boolean newProj(String username, String projName, String teamName) {
        return false;
    }

    @Override
    public boolean delProj(String username, String projName) {
        return false;
    }

    @Override
    public boolean modProj(String username, String name1, String name2) {
        return false;
    }
}
