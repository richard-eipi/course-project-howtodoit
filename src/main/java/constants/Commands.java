package constants;

import commands.*;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * This class stores and initializes all Executable objects.
 */
public class Commands {
    public static final HashMap<String, Executable> COMMANDS = new HashMap<>();
    public static final TreeSet<String> NON_MUTATING_COMMANDS= new TreeSet<>();

    /**
     * This class loads all commands.
     */
    public static void loadCommands() {
        COMMANDS.put("newtask", new NewTask());
        COMMANDS.put("upcoming", new Upcoming());
        COMMANDS.put("completetask", new CompleteTask());
        COMMANDS.put("star", new Star());
        COMMANDS.put("unstar", new Unstar());
        COMMANDS.put("rename", new Rename());
        COMMANDS.put("retime", new Retime());
        COMMANDS.put("redesc", new Redesc());
        COMMANDS.put("reproj", new Reproj());


        COMMANDS.put("newproj", new NewProj());
        COMMANDS.put("modproj", new ModProj());
        COMMANDS.put("delproj", new DelProj());
        COMMANDS.put("viewproj", new ViewProj());
        COMMANDS.put("listproj", new ListProj());

        COMMANDS.put("regret", new Regret());

        populateNonMutatingCommands();
    }

    private static void populateNonMutatingCommands() {
        NON_MUTATING_COMMANDS.add("upcoming");
        NON_MUTATING_COMMANDS.add("viewproj");
        NON_MUTATING_COMMANDS.add("listproj");
        NON_MUTATING_COMMANDS.add("viewlab");
        NON_MUTATING_COMMANDS.add("listlab");
        NON_MUTATING_COMMANDS.add("regret");
    }
}
