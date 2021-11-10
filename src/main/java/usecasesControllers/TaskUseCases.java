package usecasesControllers;

public class TaskUseCases implements TaskInputBoundary {
    private final UserList userList;

    public TaskUseCases(UserList userList) {
        this.userList = userList;
    }

    @Override
    public boolean newTask(String username, String taskName, String dueDate, String projName) {
        return false;
    }

    @Override
    public boolean completeTask(String username, String taskName) {
        return false;
    }

    @Override
    public boolean star(String username, String taskName) {
        return false;
    }

    @Override
    public boolean unstar(String username, String taskName) {
        return false;
    }

    @Override
    public boolean rename(String username, String name1, String name2) {
        return false;
    }

    @Override
    public boolean retime(String username, String taskName, String dueDate) {
        return false;
    }

    @Override
    public boolean redesc(String username, String taskName, String desc) {
        return false;
    }
}
