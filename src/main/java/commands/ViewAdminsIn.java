package commands;

import driver.DataAccessor;
/**
 * This class show all admins in the team.
 */
public class ViewAdminsIn implements Executable{

    /**
     * This function executes the viewAdminsIn command: show all admins in the team called <name>.
     *
     * @param dataAccessor gives us TodoSystem
     * @param args a list of Strings with length 1, representing user arguments
     * @return a String indicating all admins have been successfully displayed.
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        return "";
    }
}
