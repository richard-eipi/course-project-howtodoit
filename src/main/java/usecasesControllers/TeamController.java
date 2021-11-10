package usecasesControllers;

public class TeamController {
    private static final TeamController instance = new TeamController();
    private TeamInputBoundary inputBoundary;

    public TeamController() {

    }

    public static TeamController getInstance(){
        return instance;
    }

    public void setInputBoundary(TeamInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }
}
