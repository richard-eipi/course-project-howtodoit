package commands;

import driver.DataAccessor;

public class NewTeamProj implements Executable {

    /**
     * This function executes the newTeamProj command: Create a team project called <proj name> for a team
     * called <team name>
     * This project will be created for every member of the team.
     * Only admins of the team can perform this action.
     *
     * @param args a list of Strings with length 2, representing user arguments
     * @return a String indicating a new team project has been created successfully
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) throws Exception {
        return "";
    }

}
