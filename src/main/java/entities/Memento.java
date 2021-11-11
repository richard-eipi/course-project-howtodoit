package entities;

import usecases.UserList;

import java.util.HashMap;
import java.util.List;

/**
 * This class is the core object of the Memento Design Pattern.
 * It stores the state of entities and allows us to revert to this state later.
 */
public class Memento {
    public Memento prev;
    public Memento next;

    // The state of the current system.
    private HashMap<String, User> usersCopy;

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
     * Saves the current state of TodoSystem.
     * @param todoSystem the current TodoSystem
     */
    public void setState(UserList userList) {
        HashMap<String, Task> tasks = todoSystem.getTasks();
        HashMap<String, Folder> projects = todoSystem.getProjects();
        HashMap<String, Folder> labels = todoSystem.getLabels();

        cloneProjects(projects);
        cloneLabels(labels);
        cloneTasks(tasks);
    }

    public HashMap<String, User> getState() {
    }
}
