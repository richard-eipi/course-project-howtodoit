package commands;

import controllers.QueryController;

/**
 * This class show all teams that the user is in
 */
public class ViewTeams implements Command {

    /**
     * This function executes the viewTeams command: show all teams that the user is in.
     *
     * @param username current username
     * @param args a list of Strings with length 0, representing user arguments
     * @return a String indicating the all teams have been successfully displayed.
     */
    @Override
    public String execute(String username, String[] args) throws Exception{
        if (args.length != 0) throw new Exception("Incorrect argument length!");
        return QueryController.getInstance().viewTeams(username);
    }
}
