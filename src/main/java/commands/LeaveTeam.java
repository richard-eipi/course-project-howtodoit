package commands;

import driver.DataAccessor;
/**
 * This class allows a user to leave a team
 */
public class LeaveTeam implements Executable {
    /**
     * This function executes the leaveTeam command: leave a team called <name>.
     *
     * @param args a list of Strings with length 1, representing user arguments
     * @return a String indicating a user has left a team.
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) throws Exception {
        return "";
    }

}
