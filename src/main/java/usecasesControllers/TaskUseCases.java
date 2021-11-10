package usecasesControllers;

public class TaskUseCases implements TaskInputBoundary {
    private final UserList userList;

    public TaskUseCases(UserList userList) {
        this.userList = userList;
    }

    /**
     * Create a new task.
     * @param username current username
     * @param taskName name of the new task
     * @param dueDate due date of the new task
     * @param projName project the new task belongs to
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean newTask(String username, String taskName, String dueDate, String projName) {
        return false;
    }

    /**
     * Complete a task.
     * @param username current username
     * @param taskName name of the task to complete
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean completeTask(String username, String taskName) {
        return false;
    }

    /**
     * Star a task.
     * @param username current username
     * @param taskName name of the task to star
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean star(String username, String taskName) {
        return false;
    }

    /**
     * Unstar a task.
     * @param username current username
     * @param taskName name of the task to unstar
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean unstar(String username, String taskName) {
        return false;
    }

    /**
     * Rename a task.
     * @param username current username
     * @param name1 current name of the task
     * @param name2 new name of the task
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean rename(String username, String name1, String name2) {
        return false;
    }

    /**
     * Reset the due date of a task.
     * @param username current username
     * @param taskName name of the task
     * @param dueDate new due date of the task
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean retime(String username, String taskName, String dueDate) {
        return false;
    }

    /**
     * Reset the description of a task.
     * @param username current username
     * @param taskName name of the task
     * @param desc new description of the task
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean redesc(String username, String taskName, String desc) {
        return false;
    }
}
