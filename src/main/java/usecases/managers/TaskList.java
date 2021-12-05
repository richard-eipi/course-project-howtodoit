package usecases.managers;

import entities.Task;

/**
 * This interface represents a list of tasks.
 */
public interface TaskList {
    /**
     * Checks whether this user has the given task.
     *
     * @param name task name
     * @return true if the task list has tasks
     */
    boolean hasTask(String name);

    /**
     * Return a task by name.
     *
     * @param name task name
     * @return the task
     */
    Task getTask(String name);

    /**
     * Let the user have this task.
     *
     * @param task the task object
     */
    void addTask(Task task);

    /**
     * Remove a task.
     *
     * @param task the task object
     */
    void delTask(Task task);
}
