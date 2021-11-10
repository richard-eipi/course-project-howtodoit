package commands;
/**
 * This class adds a new member to a team.
 */
public class AddMem implements Executable {
    /**
     * This function executes the addMem command: add a user called <username> to the team called <teamname>.
     * Only admins of the team can perform this action.
     *
     * @param username current username
     * @param args a list of Strings with length 2, representing user arguments
     * @return a String indicating a new member has been added successfully
     */
    @Override
    public String execute(String username, String[] args) throws Exception {
        return "";
    }
}
