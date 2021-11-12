package entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 * This class represents a project.
 * A project stores a collection of tasks, but those tasks must be in exactly one project.
 */
public class Project implements Serializable, Iterable<Task>, Comparable<Project> {

    private final HashMap<String, Task> tasks;
    private String name;

    /**
     * Create a personal project with given name
     *
     * @param name project name
     */
    public Project(String name) {
        this.name = name;
        this.tasks = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasTask(String name) {
        return this.tasks.containsKey(name);
    }

    public void addTask(Task task) {
        this.tasks.putIfAbsent(task.getName(), task);
    }

    public void delTask(Task task) {
        this.tasks.remove(task.getName());
    }

    @Override
    public String toString() {
        Task[] tasks = this.tasks.values().toArray(new Task[0]);
        Arrays.sort(tasks); // Sort them
        StringBuilder output = new StringBuilder("This project <" + this.name + "> contains the following tasks:\n");
        for (Task task : tasks) {
            output.append(task.toString()).append('\n'); // Each line will be a task
        }

        return output.toString();
    }

    @Override
    public Iterator<Task> iterator() {
        return this.tasks.values().iterator();
    }

    @Override
    public int compareTo(Project o) {
        return this.name.compareToIgnoreCase(o.getName());
    }
}