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
}
