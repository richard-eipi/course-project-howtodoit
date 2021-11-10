package commands;

import driver.DataAccessor;
/**
 * This class modifies a team
 */
public class ModTeam implements Executable {
    /**
     * This function executes the modTeam command: rename the team from <name1> to <name2>.
     * Only admins of the team can perform this action.
     *
     * @param args a list of Strings with length 2, representing user arguments
     * @return a String indicating a new team has been renamed successfully
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) throws Exception {
        return "";
    }

}
