package entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;

/**
 * This class represents a User.
 */
public class User implements Serializable, Comparable<User> {
    private String name;
    private String password;
    private final HashMap<String, Task> tasks;
    private final HashMap<String, Project> projects;
    private final HashMap<String, Team> teams;

    /**
     * Constructor for user with given name and password.
     * Generate empty map.
     *
     * @param name     the username
     * @param password password of the new user
     */
    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.tasks = new HashMap<>();
        this.projects = new HashMap<>();
        this.addProject(new Project("General"));
        this.addProject(new Project("Assigned to me"));
        this.teams = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean passwordMatches(String password) {
        return this.password.equals(password);
    }

    public boolean hasProject(String name) {
        return this.projects.containsKey(name);
    }

    public boolean hasTeam(String name) {
        return this.teams.containsKey(name);
    }

    public boolean hasTask(String name) {
        return this.tasks.containsKey(name);
    }

    public Project getProject(String name) {
        return this.projects.getOrDefault(name, null);
    }

    public Team getTeam(String name) {
        return this.teams.getOrDefault(name, null);
    }

    public Task getTask(String name) {
        return this.tasks.getOrDefault(name, null);
    }

    public void addProject(Project project) {
        this.projects.putIfAbsent(project.getName(), project);
    }

    public void addTeam(Team team) {
        this.teams.putIfAbsent(team.getName(), team);
    }

    public void addTask(Task task) {
        this.tasks.putIfAbsent(task.getName(), task);
    }

    public void delProject(Project project) {
        this.projects.remove(project.getName());
    }

    public void delTeam(Team team) {
        this.teams.remove(team.getName());
    }

    public void delTask(Task task) {
        this.tasks.remove(task.getName());
    }

    public String getProjects() {
        Project[] projects = this.projects.values().toArray(new Project[0]);
        Arrays.sort(projects); // Sort them
        StringBuilder output = new StringBuilder("You have the following projects:\n");
        for (Project project : projects) {
            output.append(project.getName()).append('\n'); // Each line will be a task
        }

        return output.toString();
    }

    public String getTeams() {
        Team[] teams = this.teams.values().toArray(new Team[0]);
        Arrays.sort(teams); // Sort them
        StringBuilder output = new StringBuilder("You are in the following teams:\n");
        for (Team team : teams) {
            output.append(team.getName()).append('\n'); // Each line will be a team
        }

        return output.toString();
    }

    public String getTasks() {
        Task[] tasks = this.tasks.values().toArray(new Task[0]);
        Arrays.sort(tasks); // Sort them
        StringBuilder output = new StringBuilder("You have the following upcoming tasks:\n");
        for (Task task : tasks) {
            output.append(task.toString()).append('\n'); // Each line will be a project
        }

        return output.toString();
    }

    @Override
    public int compareTo(User o) {
        return this.name.compareToIgnoreCase(o.getName());
    }

    /**
     * Copy this user and their tasks and projects (but not teams)
     *
     * @return a copy of this user
     */
    public User copy() {
        User userCopy = new User(this.name, this.password);
        for (Project project : this.projects.values()) {
            String projName = project.getName();
            Project projectCopy = userCopy.hasProject(projName) ?
                    userCopy.getProject(projName) : new Project(project.getName());
            copyTasks(userCopy, project, projectCopy);
            userCopy.addProject(projectCopy);
        }
        return userCopy;
    }

    /**
     * Helper method that copies tasks when copying this user.
     *
     * @param userCopy    the clone of this user
     * @param project     this user's original project
     * @param projectCopy the clone of that original project
     */
    private void copyTasks(User userCopy, Project project, Project projectCopy) {
        for (Task task : project) {
            Task taskCopy = new Task(task.getName(), task.getDueDate(), projectCopy);
            taskCopy.setDescription(task.getDescription());
            projectCopy.addTask(taskCopy);
            userCopy.addTask(taskCopy);
        }
    }
}