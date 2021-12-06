package usecases.managers;

import entities.Task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class represents a list of tasks.
 */
public class TaskManager implements TaskList, Serializable {
    /**
     * A collection of tasks.
     */
    private final List<Task> tasks = new ArrayList<>();

    /**
     * Checks whether this user has the given task.
     *
     * @param name task name
     * @return true if the hashmap has tasks
     */
    @Override
    public boolean hasTask(String name) {
        for (Task task : this.tasks) {
            if (task.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return a task by name.
     *
     * @param name task name
     * @return the task
     */
    @Override
    public Task getTask(String name) {
        for (Task task : this.tasks) {
            if (task.getName().equals(name)) {
                return task;
            }
        }
        return null;
    }

    /**
     * Let the user have this task.
     *
     * @param task the task object
     */
    @Override
    public void addTask(Task task) {
        if (!this.hasTask(task.getName())) {
            this.tasks.add(task);
        }
    }

    /**
     * Remove a task.
     *
     * @param task the task object
     */
    @Override
    public void delTask(Task task) {
        this.tasks.remove(task);
    }

    /**
     * Return a String showing all task info.
     *
     * @return a String showing all team names
     */
    @Override
    public String toString() {
        Collections.sort(tasks);
        StringBuilder output = new StringBuilder("You have the following upcoming tasks:\n");
        for (Task task : tasks) {
            output.append(task.toString()).append('\n'); // Each line will be a task
        }

        return output.toString();
    }
}
