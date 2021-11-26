package usecases.managers;

import entities.Task;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;

/**
 * This class represents a list of tasks.
 */
public class TaskManager implements TaskList, Serializable {
    /**
     * A collection of tasks.
     */
    private final HashMap<String, Task> tasks = new HashMap<>();

    /**
     * Checks whether this user has the given task.
     *
     * @param name task name
     * @return true if has task
     */
    @Override
    public boolean hasTask(String name) {
        return this.tasks.containsKey(name);
    }

    /**
     * Return a task by name.
     *
     * @param name task name
     * @return the task
     */
    @Override
    public Task getTask(String name) {
        return this.tasks.getOrDefault(name, null);
    }

    /**
     * Let the user have this task.
     *
     * @param task the task object
     */
    @Override
    public void addTask(Task task) {
        this.tasks.putIfAbsent(task.getName(), task);
    }

    /**
     * Remove a task.
     *
     * @param task the task object
     */
    @Override
    public void delTask(Task task) {
        this.tasks.remove(task.getName());
    }

    /**
     * Return a String showing all task info.
     *
     * @return a String showing all team names
     */
    @Override
    public String toString() {
        Task[] tasks = this.tasks.values().toArray(new Task[0]);
        Arrays.sort(tasks); // Sort them
        StringBuilder output = new StringBuilder("You have the following upcoming tasks:\n");
        for (Task task : tasks) {
            output.append(task.toString()).append('\n'); // Each line will be a project
        }

        return output.toString();
    }
}
