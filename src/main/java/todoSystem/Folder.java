package todoSystem;

import java.io.Serializable;
import java.util.HashMap;

/**
 * This class stores a collection of tasks.
 */
public class Folder implements Serializable {
    private String name;
    private final HashMap<String, Task> tasks = new HashMap<>();
    private final boolean isProj;

    public Folder(String name, boolean isProj) {
        this.name = name;
        this.isProj = isProj;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Task> getTasks() {
        return this.tasks;
    }

    public boolean getIsProj() {
        return isProj;
    }

}
