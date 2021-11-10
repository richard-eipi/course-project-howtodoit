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

    public String newTeam(String username, String teamName) throws Exception {
        boolean result = this.inputBoundary.newTeam(username, teamName);
        if (result) {
            return "New team created successfully.";
        } else {
            throw new Exception("Failure to create new team.");
        }
    }

    public String delTeam(String username, String teamName) throws Exception {
        boolean result = this.inputBoundary.delTeam(username, teamName);
        if (result) {
            return "Team deleted successfully.";
        } else {
            throw new Exception("Failure to delete team.");
        }
    }

    public String modTeam(String username, String name1, String name2) throws Exception {
        boolean result = this.inputBoundary.modTeam(username, name1, name2);
        if (result) {
            return "Team renamed successfully.";
        } else {
            throw new Exception("Failure to rename team.");
        }
    }

    public String addMem(String username, String teamName, String memName) throws Exception {
        boolean result = this.inputBoundary.addMem(username, teamName, memName);
        if (result) {
            return "Member added successfully.";
        } else {
            throw new Exception("Failure to add member.");
        }
    }

    public String delMem(String username, String teamName, String memName) throws Exception {
        boolean result = this.inputBoundary.delMem(username, teamName, memName);
        if (result) {
            return "Member deleted successfully.";
        } else {
            throw new Exception("Failure to delete member.");
        }
    }

    public String addAdmin(String username, String teamName, String memName) throws Exception {
        boolean result = this.inputBoundary.addAdmin(username, teamName, memName);
        if (result) {
            return "Admin added successfully.";
        } else {
            throw new Exception("Failure to add admin.");
        }
    }
}
