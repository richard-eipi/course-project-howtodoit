package commands;

import driver.DataAccessor;
/**
 * This class show all teams that the user is in
 */
public class ViewTeams implements Executable{

    /**
     * This function executes the viewTeams command: show all teams that the user is in.
     *
     * @param dataAccessor gives us TodoSystem
     * @param args a list of Strings with length 0, representing user arguments
     * @return a String indicating the all teams have been successfully displayed.
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        return "";
    }
}
