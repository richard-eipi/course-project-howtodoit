package usecasesControllers;

public class TaskController {
    private static final TaskController instance = new TaskController();
    private TaskInputBoundary inputBoundary;

    public TaskController() {

    }

    public static TaskController getInstance(){
        return instance;
    }

    public void setInputBoundary(TaskInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }
}
