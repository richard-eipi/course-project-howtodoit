package constants;

/**
 * This class stores all the Enum results of use cases.
 */
public class Enums {
    /**
     * The result of logging in.
     */
    public enum LoginResult {SUCCESS, FAILURE, NO_SUCH_USER}

    /**
     * The result of registering.
     */
    public enum RegisterResult {SUCCESS, FAILURE, NULL_USERNAME}
}
