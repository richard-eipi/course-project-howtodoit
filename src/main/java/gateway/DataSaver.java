package gateway;

/**
 * This interface saves data into local system.
 */
public interface DataSaver {
    /**
     * Saves data into local system.
     *
     * @return String indicating success or failure
     */
    String writeData();
}
