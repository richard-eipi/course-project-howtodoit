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
        COMMANDS.put("register", new Register());
        COMMANDS.put("login", new Login());
        COMMANDS.put("logout", new Logout());
        COMMANDS.put("exit", new Exit());
        COMMANDS.put("regret", new Regret());

        COMMANDS.put("allUsers", new AllUsers());
        COMMANDS.put("allTeams", new AllTeams());
        COMMANDS.put("viewTeams", new ViewTeams());
        COMMANDS.put("viewMemsIn", new ViewMemsIn());
        COMMANDS.put("viewAdminsIn", new ViewAdminsIn());
        COMMANDS.put("viewProj", new ViewProj());
        COMMANDS.put("modUsn", new ModUsn());
        COMMANDS.put("modPwd", new ModPwd());

        COMMANDS.put("viewTasks", new ViewTasks());
        COMMANDS.put("viewTasksInProj", new ViewTasksInProj());

        COMMANDS.put("newProj", new NewProj());
        COMMANDS.put("newTeamProj", new NewTeamProj());
        COMMANDS.put("delProj", new DelProj());
        COMMANDS.put("modProj", new ModProj());

        COMMANDS.put("newTeam", new NewTeam());
        COMMANDS.put("delTeam", new DelTeam());
        COMMANDS.put("modTeam", new ModTeam());
        COMMANDS.put("joinTeam", new JoinTeam());
        COMMANDS.put("leaveTeam", new LeaveTeam());
        COMMANDS.put("addMem", new AddMem());
        COMMANDS.put("delMem", new DelMem());
        COMMANDS.put("addAdmin", new AddAdmin());

        COMMANDS.put("newTask", new NewTask());
        COMMANDS.put("completeTask", new CompleteTask());
        COMMANDS.put("star", new Star());
        COMMANDS.put("unstar", new Unstar());
        COMMANDS.put("rename", new Rename());
        COMMANDS.put("redesc", new Redesc());
        COMMANDS.put("retime", new Retime());
        COMMANDS.put("reproj", new Reproj());


        COMMANDS.put("upcoming", new Upcoming());
        COMMANDS.put("listProj", new ListProj());



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
