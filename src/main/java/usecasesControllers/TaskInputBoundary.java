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

    /**
     * Complete a task.
     * @param username current username
     * @param taskName name of the task to complete
     * @return boolean indicating whether success or failure
     */
    boolean completeTask(String username, String taskName);

    /**
     * Star a task.
     * @param username current username
     * @param taskName name of the task to star
     * @return boolean indicating whether success or failure
     */
    boolean star(String username, String taskName);

    /**
     * Unstar a task.
     * @param username current username
     * @param taskName name of the task to unstar
     * @return boolean indicating whether success or failure
     */
    boolean unstar(String username, String taskName);

    /**
     * Rename a task.
     * @param username current username
     * @param name1 current name of the task
     * @param name2 new name of the task
     * @return boolean indicating whether success or failure
     */
    boolean rename(String username, String name1, String name2);

    /**
     * Reset the due date of a task.
     * @param username current username
     * @param taskName name of the task
     * @param dueDate new due date of the task
     * @return boolean indicating whether success or failure
     */
    boolean retime(String username, String taskName, String dueDate);

    /**
     * Reset the description of a task.
     * @param username current username
     * @param taskName name of the task
     * @param desc new description of the task
     * @return boolean indicating whether success or failure
     */
    boolean redesc(String username, String taskName, String desc);
}
