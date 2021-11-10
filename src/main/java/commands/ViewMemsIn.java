package commands;

import driver.DataAccessor;
/**
 * This class shows all members in a team
 */
public class ViewMemsIn implements Executable{

    /**
     * This function executes the viewMemsIn command: show all members in the team called <name>.
     *
     * @param dataAccessor gives us TodoSystem
     * @param args a list of Strings with length 1, representing user arguments
     * @return a String indicating all members have been successfully displayed.
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        return "";
    }
}
