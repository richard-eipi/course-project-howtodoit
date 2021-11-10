package usecasesControllers;

public class ProjectController {
    private static final ProjectController instance = new ProjectController();
    private ProjectInputBoundary inputBoundary;

    public ProjectController() {

    }

    public static ProjectController getInstance(){
        return instance;
    }

    public void setInputBoundary(ProjectInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public String newProj(String username, String projName, String teamName) throws Exception {
        boolean result = this.inputBoundary.newProj(username, projName, teamName);
        if (result) {
            return "New project created successfully.";
        } else {
            throw new Exception("Failure to create new project.");
        }
    }

    public String delProj(String username, String projName) throws Exception {
        boolean result = this.inputBoundary.delProj(username, projName);
        if (result) {
            return "Project deleted successfully.";
        } else {
            throw new Exception("Failure to delete project.");
        }
    }

    public String modProj(String username, String name1, String name2) throws Exception {
        boolean result = this.inputBoundary.modProj(username, name1, name2);
        if (result) {
            return "Project renamed successfully.";
        } else {
            throw new Exception("Failure to rename project.");
        }
    }
}
