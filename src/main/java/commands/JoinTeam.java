package commands;

import driver.DataAccessor;
/**
 * This class allows a user to join a team
 */
public class JoinTeam implements Executable {
    /**
     * This function executes the joinTeam command: join a team called <name> as a normal teammate (not an admin).
     *
     * @param args a list of Strings with length 1, representing user arguments
     * @return a String indicating a user has joined a team.
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) throws Exception {
        return "";
    }

}
