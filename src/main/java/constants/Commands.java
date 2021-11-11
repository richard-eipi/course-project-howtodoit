package constants;

import driver.commands.*;

import java.util.HashMap;

/**
 * This class stores and initializes all Command objects.
 */
public class Commands {
    public static final HashMap<String, Command> COMMANDS = new HashMap<>();

    /**
     * This class loads all driver.commands.
     */
    public static void loadCommands() {
        COMMANDS.put("modUsn", new ModUsn());
        COMMANDS.put("modPwd", new ModPwd());

        COMMANDS.put("viewTeams", new ViewTeams());
        COMMANDS.put("viewMemsIn", new ViewMemsInTeam());
        COMMANDS.put("viewProj", new ViewProj());
        COMMANDS.put("viewTasks", new ViewTasks());
        COMMANDS.put("viewTasksInProj", new ViewTasksInProj());

        COMMANDS.put("newProj", new NewProj());
        COMMANDS.put("delProj", new DelProj());
        COMMANDS.put("modProj", new ModProj());

        COMMANDS.put("newTeam", new NewTeam());
        COMMANDS.put("modTeam", new ModTeam());
        COMMANDS.put("addMem", new AddMem());
        COMMANDS.put("leaveTeam", new LeaveTeam());
        COMMANDS.put("addAdmin", new AddAdmin());

        COMMANDS.put("newTask", new NewTask());
        COMMANDS.put("completeTask", new CompleteTask());
        COMMANDS.put("star", new Star());
        COMMANDS.put("unstar", new Unstar());
        COMMANDS.put("rename", new Rename());
        COMMANDS.put("redesc", new Redesc());
        COMMANDS.put("retime", new Retime());
        COMMANDS.put("assignTask", new AssignTask());

        COMMANDS.put("undo", new Undo());
        COMMANDS.put("redo", new Redo());
    }
}
