package commands;
import driver.DataAccessor;
public class ModUsn implements Executable{
    /**
     * This function executes the modUsn command: modify the username from its current name to <name>.
     *
     * @param args a String, representing user arguments
     * @return a String indicating a username has been changed.
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args){
        return "";
    }
}
