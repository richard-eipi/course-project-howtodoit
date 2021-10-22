package helpers;

import todoSystem.Folder;
import todoSystem.Task;
import todoSystem.TodoSystem;

import java.util.HashMap;
import java.util.List;

/**
 * This class is the core object of the Memento Design Pattern.
 * It stores the state of entities and allows us to revert to this state later.
 */
public class Memento {
    public Memento prev;
    public Memento next;

    // The state of the current TodoSystem.
    private final HashMap<String, Task> tasks = new HashMap<>();
    private final HashMap<String, Folder> projects = new HashMap<>();
    private final HashMap<String, Folder> labels = new HashMap<>();

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
    public void setState(TodoSystem todoSystem) {
        HashMap<String, Task> tasks = todoSystem.getTasks();
        HashMap<String, Folder> projects = todoSystem.getProjects();
        HashMap<String, Folder> labels = todoSystem.getLabels();

        cloneProjects(projects);
        cloneLabels(labels);
        cloneTasks(tasks);
    }

    private void cloneProjects(HashMap<String, Folder> projects) {
        for (String name : projects.keySet()) {
            this.projects.put(name, new Folder(name, true));
        }
    }

    private void cloneLabels(HashMap<String, Folder> labels) {
        for (String name : labels.keySet()) {
            this.labels.put(name, new Folder(name, false));
        }
    }

    private void cloneTasks(HashMap<String, Task> tasks) {
        for (String name : tasks.keySet()) {
            // Get task and its corresponding project and labels
            Task task = tasks.get(name);
            Folder project = task.getProject();
            List<Folder> labels = task.getLabels();

            // Add cloned task to cloned project
            Folder cloneProject = this.projects.get(project.getName());
            Task cloneTask = new Task(name, task.getDueDate(), task.getDescription(), cloneProject);
            cloneProject.getTasks().put(name, cloneTask);

            // Add cloned task to cloned labels
            for (Folder label : labels) {
                Folder cloneLabel = this.labels.get(label.getName());
                cloneTask.getLabels().add(cloneLabel);
                cloneLabel.getTasks().put(name, cloneTask);
            }
        }
    }
}
