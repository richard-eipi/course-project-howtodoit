package usecases;

import entities.Project;
import entities.Task;
import entities.User;

public class ProjectUseCases implements ProjectInputBoundary {
    private final UserList userList;

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
        if (user.hasProject(projName)) {
            return false; // project already exists
        } else {
            user.addProject(new Project(projName));
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
        if (projName.equals("General") || projName.equals("Assigned to me")) {
            return false; // you cannot delete them
        } else if (!user.hasProject(projName)) {
            return false; // project doesn't exist
        } else {
            Project project = user.getProject(projName);
            emptyTasks(user, project);
            user.delProject(project);
            return true;
        }
    }

    private void emptyTasks(User user, Project project) {
        for (Task task : project) {
            user.delTask(task);
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
        if (name1.equals("General") || name1.equals("Assigned to me")) {
            return false; // you cannot rename them
        } else if (!user.hasProject(name1) || user.hasProject(name2)) {
            return false; // project doesn't exist or new name already used
        } else {
            Project project = user.getProject(name1);
            project.setName(name2);
            return true;
        }
    }
}
