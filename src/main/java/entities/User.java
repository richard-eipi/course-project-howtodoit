package entities;

import usecases.managers.ProjectList;
import usecases.managers.TaskList;
import usecases.managers.TeamList;

import java.io.Serializable;

/**
 * This class represents a User.
 * A user has a username, a password, collection of tasks, a collection of projects, and a collection of teams.
 */
public class User implements Serializable, Comparable<User> {
    /**
     * Username.
     */
    private String name;
    /**
     * Password.
     */
    private String password;
    /**
     * A collection of tasks.
     */
    private final TaskList taskList;
    /**
     * A collection of projects.
     */
    private final ProjectList projectList;
    /**
     * A collection of teams this user is in.
     */
    private final TeamList teamList;

    /**
     * Constructor for user with given username and password.
     *
     * @param name        the username
     * @param password    password of the new user
     * @param taskList    the list of tasks
     * @param projectList the list of projects
     * @param teamList    the list of teams this user is in
     */
    public User(String name, String password, TaskList taskList, ProjectList projectList, TeamList teamList) {
        this.name = name;
        this.password = password;
        this.taskList = taskList;
        this.projectList = projectList;
        this.teamList = teamList;
        this.projectList.addProject(new Project("General"));
        this.projectList.addProject(new Project("Assigned to me"));
    }

    /**
     * Return the name of the user.
     *
     * @return username
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the user.
     *
     * @param name username
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the password of the user.
     *
     * @param password new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Checks if entered password matches this user's password
     *
     * @param password the password entered by the user
     * @return true if matches
     */
    public boolean passwordMatches(String password) {
        return this.password.equals(password);
    }

    /**
     * Return the task list.
     *
     * @return task list
     */
    public TaskList getTaskList() {
        return this.taskList;
    }

    /**
     * Return the project list
     *
     * @return project list
     */
    public ProjectList getProjectList() {
        return this.projectList;
    }

    /**
     * Return the team list
     *
     * @return team list
     */
    public TeamList getTeamList() {
        return this.teamList;
    }

    /**
     * Let this user be compared to another user based on username.
     *
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
    public User copy(TaskList taskList, ProjectList projectList, TeamList teamList) {
        User userCopy = new User(this.name, this.password, taskList, projectList, teamList);
        for (Project project : this.projectList) {
            String projName = project.getName();
            ProjectList userCopyProjectList = userCopy.getProjectList();
            Project projectCopy = userCopyProjectList.hasProject(projName) ?
                    userCopyProjectList.getProject(projName) : new Project(project.getName());
            copyTasks(userCopy, project, projectCopy);
            userCopyProjectList.addProject(projectCopy);
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
            taskCopy.setStarred(task.isStarred());
            projectCopy.addTask(taskCopy);
            userCopy.getTaskList().addTask(taskCopy);
        }
    }
}