package usecasesControllers;

public interface TaskInputBoundary {
    /**
     * Create a new task.
     * @param username current username
     * @param taskName name of the new task
     * @param dueDate due date of the new task
     * @param projName project the new task belongs to
     * @return boolean indicating whether success or failure
     */
    boolean newTask(String username, String taskName, String dueDate, String projName);

    boolean completeTask(String username, String taskName);

    boolean star(String username, String taskName);

    boolean unstar(String username, String taskName);

    boolean rename(String username, String name1, String name2);

    boolean retime(String username, String taskName, String dueDate);

    boolean redesc(String username, String taskName, String desc);
}
