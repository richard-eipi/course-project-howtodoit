package usecases;

import entities.Project;
import entities.Task;
import entities.User;
import usecases.managers.ProjectList;
import usecases.managers.UserList;

/**
 * This class deals with project use cases.
 */
public class ProjectUseCases implements ProjectInputBoundary {
    /**
     * The list of users.
     */
    private final UserList userList;

    /**
     * Constructor.
     *
     * @param userList the list of users
     */
    public ProjectUseCases(UserList userList) {
        this.userList = userList;
    }

    /**
     * Create a new project.
     *
     * @param username current username
     * @param projName name of the new project you want to create
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean newProj(String username, String projName) {
        User user = this.userList.getUser(username);
        ProjectList projectList = user.getProjectList();
        if (projectList.hasProject(projName)) {
            return false; // project already exists
        } else {
            projectList.addProject(new Project(projName));
            return true;
        }
    }

    /**
     * Delete a project, move all its tasks to "General".
     *
     * @param username current username
     * @param projName name of the project you want to delete
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean delProj(String username, String projName) {
        User user = this.userList.getUser(username);
        ProjectList projectList = user.getProjectList();
        if (projName.equals("General") || projName.equals("Assigned to me")) {
            return false; // you cannot delete them
        } else if (!projectList.hasProject(projName)) {
            return false; // project doesn't exist
        } else {
            Project project = projectList.getProject(projName);
            emptyTasks(user, project);
            projectList.delProject(project);
            return true;
        }
    }

    /**
     * Helper method that helps delete tasks stored in a project from the user.
     *
     * @param user    the user
     * @param project the project which stores tasks that we want to delete
     */
    private void emptyTasks(User user, Project project) {
        for (Task task : project) {
            user.getTaskList().delTask(task);
        }
    }

    /**
     * Change the name of a project.
     *
     * @param username current username
     * @param name1    name of the project you want to change
     * @param name2    the new name
     * @return boolean indicating whether success or failure
     */
    @Override
    public boolean modProj(String username, String name1, String name2) {
        User user = this.userList.getUser(username);
        ProjectList projectList = user.getProjectList();
        if (name1.equals("General") || name1.equals("Assigned to me")) {
            return false; // you cannot rename them
        } else if (!projectList.hasProject(name1) || projectList.hasProject(name2)) {
            return false; // project doesn't exist or new name already used
        } else {
            Project project = projectList.getProject(name1);
            project.setName(name2);
            return true;
        }
    }
}
