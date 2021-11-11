package usecasesControllers;

import entities.Project;
import entities.Task;
import entities.Team;
import entities.User;

public class TaskUseCases implements TaskInputBoundary {
    private final UserList userList;

    public TaskUseCases(UserList userList) {
        this.userList = userList;
    }

    /**
     * Create a new task.
     * @param username current username
     * @param taskName name of the new task
     * @param dueDate due date of the new task
     * @param projName project the new task belongs to
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean newTask(String username, String taskName, String dueDate, String projName) {
        User user = this.userList.getUser(username);
        Project project = user.getProject(projName);
        if (project == null) project = user.getProject("General");
        Task task = new Task(taskName, dueDate, project);
        user.addTask(task);
        return true;
    }

    /**
     * Complete a task.
     * @param username current username
     * @param taskName name of the task to complete
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean completeTask(String username, String taskName) {
        User user = this.userList.getUser(username);
        Task task = user.getTask(taskName);
        if (task == null) return false; // non-existent task
        user.delTask(task);
        return true;
    }

    /**
     * Star a task.
     * @param username current username
     * @param taskName name of the task to star
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean star(String username, String taskName) {
        User user = this.userList.getUser(username);
        Task task = user.getTask(taskName);
        if (task == null ) return false; // non-existent task
        task.setStarred(true);
        return true;
    }

    /**
     * Unstar a task.
     * @param username current username
     * @param taskName name of the task to unstar
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean unstar(String username, String taskName) {
        User user = this.userList.getUser(username);
        Task task = user.getTask(taskName);
        if (task == null ) return false; // non-existent task
        task.setStarred(false);
        return true;
    }

    /**
     * Rename a task.
     * @param username current username
     * @param name1 current name of the task
     * @param name2 new name of the task
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean rename(String username, String name1, String name2) {
        User user = this.userList.getUser(username);
        Task task = user.getTask(name1);
        if (task == null ) return false; // non-existent task
        task.setName(name2);
        return true;
    }

    /**
     * Reset the due date of a task.
     * @param username current username
     * @param taskName name of the task
     * @param dueDate new due date of the task
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean retime(String username, String taskName, String dueDate) {
        User user = this.userList.getUser(username);
        Task task = user.getTask(taskName);
        if (task == null ) return false; // non-existent task
        task.setDueDate(dueDate);
        return true;
    }

    /**
     * Reset the description of a task.
     * @param username current username
     * @param taskName name of the task
     * @param desc new description of the task
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean redesc(String username, String taskName, String desc) {
        User user = this.userList.getUser(username);
        Task task = user.getTask(taskName);
        if (task == null ) return false; // non-existent task
        task.setDescription(desc);
        return true;
    }

    /**
     * Assign a task to a teammate
     * @param username1 current user
     * @param teamName the name of the team
     * @param username2 the name of the teammate
     * @param taskName the name of the task
     * @param dueDate due date of the task
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean assignTask(String username1, String teamName, String username2, String taskName, String dueDate) {
        return false;
    }
}
