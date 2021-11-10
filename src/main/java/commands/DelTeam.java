package commands;

/**
 * This class deletes a team.
 */
public class DelTeam implements Executable {
    /**
     * This function executes the delTeam command: delete the team called <name>.
     * Only admins of the team can perform this action.
     *
     * @param username current username
     * @param args a list of Strings with length 1, representing user arguments
     * @return a String indicating a new team has been deleted successfully
     */
    @Override
    public String execute(String username, String[] args) throws Exception {
        return "";
    }

}
