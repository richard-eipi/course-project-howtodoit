package entities;

import java.io.Serializable;
import java.util.HashMap;
/**
 * This class represents a project.
 * A project stores a collection of tasks, but those tasks must be in exactly one project.
 */
public class Project implements Serializable {

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
}