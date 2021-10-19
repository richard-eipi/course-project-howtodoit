package todoSystem;

import java.io.Serializable;
import java.util.HashMap;

/**
 * This class stores all system objects such as tasks, projects, and labels.
 */
public class TodoSystem implements Serializable {
    private final HashMap<String, Task> tasks = new HashMap<>();
    private final HashMap<String, Folder> projects = new HashMap<>();
    private final HashMap<String, Folder> labels = new HashMap<>();

    public TodoSystem() {
        projects.put("Inbox", new Folder("Inbox", true));
        labels.put("Starred", new Folder("Starred", false));
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

}
