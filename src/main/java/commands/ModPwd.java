package commands;
import driver.DataAccessor;
public class ModPwd implements Executable{
    /**
     * This function executes the modUsn command: modify the password from <pw1> to <pw2>.
     *
     * @param args a list of Strings with length 2, representing user arguments
     * @return a String indicating a password has been changed.
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args){
        return "";
    }
}
