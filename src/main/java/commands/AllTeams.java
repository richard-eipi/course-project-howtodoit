package commands;

import driver.DataAccessor;
/**
 * This class shows all teams by name
 */
public class AllTeams implements Executable{

    /**
     * This function executes the allTeams command: show all teams by name.
     *
     * @param dataAccessor gives us TodoSystem
     * @param args a list of Strings with length 0, representing user arguments
     * @return a String indicating the user has been successfully logout.
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        return "";
    }
}
