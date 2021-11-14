package entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;

/**
 * This class represents a User.
 * A user has a username, a password, collection of tasks, a collection of projects, and a collection of teams.
 */
public class User implements Serializable, Comparable<User> {
    /**
     * A collection of tasks.
     */
    private final HashMap<String, Task> tasks;
    /**
     * A collection of projects.
     */
    private final HashMap<String, Project> projects;
    /**
     * A collection of teams this user is in.
     */
    private final HashMap<String, Team> teams;
    /**
     * Username.
     */
    private String name;
    /**
     * Password.
     */
    private String password;

    /**
     * Constructor for user with given username and password.
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

    /**
     * Return the name of the user.
     * @return username
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the user.
     * @param name username
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the password of the user.
     * @param password new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Checks if entered password matches this user's password
     * @param password the password entered by the user
     * @return true if matches
     */
    public boolean passwordMatches(String password) {
        return this.password.equals(password);
    }

    /**
     * Checks whether this user has the given project.
     * @param name project name
     * @return true if has project
     */
    public boolean hasProject(String name) {
        return this.projects.containsKey(name);
    }

    /**
     * Checks whether this user is in the given team.
     * @param name team name
     * @return true if has team
     */
    public boolean hasTeam(String name) {
        return this.teams.containsKey(name);
    }

    /**
     * Checks whether this user has the given task.
     * @param name task name
     * @return true if has task
     */
    public boolean hasTask(String name) {
        return this.tasks.containsKey(name);
    }

    /**
     * Return a project by name.
     * @param name project name
     * @return the project
     */
    public Project getProject(String name) {
        return this.projects.getOrDefault(name, null);
    }

    /**
     * Return a team by name.
     * @param name team name
     * @return the team
     */
    public Team getTeam(String name) {
        return this.teams.getOrDefault(name, null);
    }

    /**
     * Return a task by name.
     * @param name task name
     * @return the task
     */
    public Task getTask(String name) {
        return this.tasks.getOrDefault(name, null);
    }

    /**
     * Let the user have this project.
     * @param project the project object
     */
    public void addProject(Project project) {
        this.projects.putIfAbsent(project.getName(), project);
    }

    /**
     * Let the user join this team.
     * @param team the team object
     */
    public void addTeam(Team team) {
        this.teams.putIfAbsent(team.getName(), team);
    }

    /**
     * Let the user have this task.
     * @param task the task object
     */
    public void addTask(Task task) {
        this.tasks.putIfAbsent(task.getName(), task);
    }

    /**
     * Remove a project.
     * @param project the project object
     */
    public void delProject(Project project) {
        this.projects.remove(project.getName());
    }

    /**
     * Leave a team.
     * @param team the team object
     */
    public void delTeam(Team team) {
        this.teams.remove(team.getName());
    }

    /**
     * Remove a task.
     * @param task the task object
     */
    public void delTask(Task task) {
        this.tasks.remove(task.getName());
    }

    /**
     * Return a String showing all project names.
     * @return a String showing all project names
     */
    public String getProjects() {
        Project[] projects = this.projects.values().toArray(new Project[0]);
        Arrays.sort(projects); // Sort them
        StringBuilder output = new StringBuilder("You have the following projects:\n");
        for (Project project : projects) {
            output.append(project.getName()).append('\n'); // Each line will be a task
        }

        return output.toString();
    }

    /**
     * Return a String showing all team names.
     * @return a String showing all team names
     */
    public String getTeams() {
        Team[] teams = this.teams.values().toArray(new Team[0]);
        Arrays.sort(teams); // Sort them
        StringBuilder output = new StringBuilder("You are in the following teams:\n");
        for (Team team : teams) {
            output.append(team.getName()).append('\n'); // Each line will be a team
        }

        return output.toString();
    }

    /**
     * Return a String showing all task info.
     * @return a String showing all team names
     */
    public String getTasks() {
        Task[] tasks = this.tasks.values().toArray(new Task[0]);
        Arrays.sort(tasks); // Sort them
        StringBuilder output = new StringBuilder("You have the following upcoming tasks:\n");
        for (Task task : tasks) {
            output.append(task.toString()).append('\n'); // Each line will be a project
        }

        return output.toString();
    }

    /**
     * Let this user be compared to another user based on username.
     * @param o another user
     * @return negative number for <, positive number for >, 0 for =
     */
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
            taskCopy.setStarred(task.getIsStarred());
            projectCopy.addTask(taskCopy);
            userCopy.addTask(taskCopy);
        }
    }
}