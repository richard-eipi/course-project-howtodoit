package todoSystem;

import helpers.Memento;

import java.io.Serializable;
import java.util.HashMap;

/**
 * This class stores all system objects such as tasks, projects, and labels.
 */
public class TodoSystem implements Serializable {
    private HashMap<String, Task> tasks = new HashMap<>();
    private HashMap<String, Folder> projects = new HashMap<>();
    private HashMap<String, Folder> labels = new HashMap<>();

    public TodoSystem() {
        this.projects.put("Inbox", new Folder("Inbox", true));
        this.labels.put("Starred", new Folder("Starred", false));
    }

    public HashMap<String, Task> getTasks() {
        return this.tasks;
    }

    public HashMap<String, Folder> getProjects() {
        return this.projects;
    }

    public HashMap<String, Folder> getLabels() {
        return this.labels;
    }

    /**
     * Saves current state in a new Memento object for undo/redo.
     * @return a Memento object containing current state
     */
    public Memento createMemento() {
        Memento memento = new Memento();
        memento.setState(this);
        return memento;
    }

    /**
     * Restore the state of the system using Memento.
     * @param memento the Memento that contains the state we want to revert to
     */
    public void restore(Memento memento) {
        this.tasks = memento.getTasks();
        this.projects = memento.getProjects();
        this.labels = memento.getLabels();
    }
}
