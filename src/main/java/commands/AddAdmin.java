package commands;
import driver.DataSaver;
/**
 * This class adds a new admin to a team
 */
public class AddAdmin implements Executable {
    /**
     * This function executes the addAdmin command: promote the user called <username> to an admin of the team
     * called <teamname>.
     * Only admins of the team can perform this action.
     *
     * @param args a list of Strings with length 2, representing user arguments
     * @return a String indicating a new admin has been added successfully
     */
    @Override
    public String execute(DataSaver dataSaver, String[] args) throws Exception {
        return "";
    }
}
