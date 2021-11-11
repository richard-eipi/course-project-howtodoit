package entities;

import helpers.SortTasksChronologically;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * This class represents a project.
 * A project stores a collection of tasks, but those tasks must be in exactly one project.
 */
public class Project implements Serializable, Iterable<Task> {

    private String name;
    private final HashMap<String, Task> tasks = new HashMap<>();

    /**
     * Create a personal project with given name
     * @param name project name
     */
    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasTask(String name) { return this.tasks.containsKey(name); }

    public Task getTask(String name) {
        return this.tasks.getOrDefault(name, null);
    }

    public void addTask(Task task) {
        this.tasks.putIfAbsent(task.getName(), task);
    }

    public void delTask(Task task) {
        this.tasks.remove(task.getName());
    }

    @Override
    public String toString() {
        List<Task> sortedTasks = SortTasksChronologically.sortTasks(this.tasks); // Sort them
        StringBuilder output = new StringBuilder("This project <" + this.name + "> contains the following tasks:\n");
        for (Task task: sortedTasks) {
            output.append(task.toString()).append('\n'); // Each line will be a task
        }

        return output.toString();
    }

    @Override
    public Iterator<Task> iterator() {
        return this.tasks.values().iterator();
    }
}