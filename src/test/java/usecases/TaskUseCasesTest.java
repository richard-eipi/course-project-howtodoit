package usecases;

import entities.Project;
import entities.Task;
import entities.Team;
import entities.User;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TaskUseCasesTest {
    private UserList userList;
    private TaskUseCases taskUseCases;
    private final String username = "Yixy";

    @BeforeEach
    void setUp() {
        userList = new UserList();
        taskUseCases = new TaskUseCases(userList);

        User user = new User(username, "+1=0");
        userList.addUser(user);
        User user2 = new User("Eipi", "0000");
        userList.addUser(user2);

        Project project = new Project("CSC207");
        user.addProject(project);

        Task task = new Task("Phase 1", "2021-11-15", project);
        user.addTask(task);

        Team team = new Team("207 project");
        team.addMem(user);
        team.addAdmin(user);
        user.addTeam(team);
    }

    @AfterEach
    void tearDown() {
    }

    // test if current user already has the task
    @Test
    public void testNewTaskHasTask() {
        assertFalse(this.taskUseCases.newTask(username,
                "Phase 1",
                "2021-11-15",
                "General"),
                "Failure: Task already exists.");
    }

    // test if date format is correct
    @Test
    public void testNewTaskDueDateFormat() {
        assertFalse(this.taskUseCases.newTask(username,
                        "Phase 1",
                        "2021.11.15",
                        "CSC207"),
                "Failure: Wrong due date format");
    }

    // test if due date is valid
    @Test
    public void testNewTaskOverdue() {
        assertFalse(this.taskUseCases.newTask(username,
                        "Phase 1",
                        "2021-10-01",
                        "CSC207"),
                "Failure: Due date had passed");
    }

    // test if task is created
    @Test
    public void testNewTaskSuccess() {
        assertTrue(this.taskUseCases.newTask(username,
                "Phase 2",
                "2021-11-15",
                "CSC207"),
                "Failure: task cannot be created.");
    }

    // test if user does not have the task.
    @Test
    public void testCompleteTaskTaskExist() {
        assertFalse(this.taskUseCases.completeTask(username, "exercise"),
                "Failure: User already has the task.");
    }

    // test if user has the task and completes it.
    @Test
    public void testCompleteTaskSuccess() {
        assertTrue(this.taskUseCases.completeTask(username, "Phase 1"),
                "Failure: Task cannot be completed.");
    }

    // test if user does not have the task.
    @Test
    public void testStarTaskExist() {
        assertFalse(this.taskUseCases.star(username, "exercise"),
                "Failure: User already has the task.");
    }

    // test if user has the task and stars it.
    @Test
    public void testStarTaskSuccess() {
        assertTrue(this.taskUseCases.star(username, "Phase 1"),
                "Failure: Task cannot be stared.");
    }

    // test if user does not have the task.
    @Test
    public void testUntarTaskExist() {
        assertFalse(this.taskUseCases.unstar(username, "exercise"),
                "Failure: User already has the task.");
    }

    // test if user has the task and unstars it.
    @Test
    public void testUntarTaskSuccess() {
        assertTrue(this.taskUseCases.unstar(username, "Phase 1"),
                "Failure: Task cannot be unstared.");
    }

    // test if user does not have the task.
    @Test
    public void testRenameTaskExist() {
        assertFalse(this.taskUseCases.rename(username, "exercise", "exercise1"),
                "Failure: User already has the task.");
    }

    // test if user has the task and renames it.
    @Test
    public void testRenameTaskSuccess() {
        assertTrue(this.taskUseCases.rename(username, "Phase 1", "exercise"),
                "Failure: Task cannot be renamed.");
    }

    // test if user does not have the task.
    @Test
    public void testRetimeTaskExist() {
        assertFalse(this.taskUseCases.retime(username, "exercise", "2021-10-01"),
                "Failure: User already has the task.");
    }

    // test if user has the task and retimed it.
    @Test
    public void testRetimeTaskSuccess() {
        assertTrue(this.taskUseCases.rename(username, "Phase 1", "2021-11-17"),
                "Failure: Task cannot be retimed.");
    }

    // test if user does not have the task.
    @Test
    public void testRedescTaskExist() {
        assertFalse(this.taskUseCases.retime(username, "exercise", "Week 1 exercise"),
                "Failure: User already has the task.");
    }

    // test if user has the task and changes the description.
    @Test
    public void testRedescTaskSuccess() {
        assertTrue(this.taskUseCases.rename(username, "Phase 1", "Phase 1 of project"),
                "Failure: Task cannot be redesced.");
    }

    // test if the user is in this team.
    @Test
    public void testAssignTaskInTeam() {
        assertFalse(this.taskUseCases.assignTask(username,
                "236 project",
                "Eipi",
                "Phase 3",
                "2021-11-17"),
                "Failure: User is already in the team.");
    }

    // test if the user is an admin.
    @Test
    public void testAssignTaskAdmin() {
        assertFalse(this.taskUseCases.assignTask("Eipi",
                        "207 project",
                        username,
                        "Phase 3",
                        "2021-11-17"),
                "Failure: User is an admin.");
    }

    // test if the user2 is a member of the team.
    @Test
    public void testAssignTaskIsMember() {
        assertFalse(this.taskUseCases.assignTask(username,
                        "207 project",
                        "Eipi",
                        "Phase 3",
                        "2021-11-17"),
                "Failure: User2 is a member.");
    }

    // test if date format is correct
    @Test
    public void testAssignTaskDueDateFormat() {
        assertFalse(this.taskUseCases.assignTask(username,
                        "207 project",
                        "Eipi",
                        "Phase 3",
                        "2021.11.17"),
                "Failure: Wrong due date format");
    }

    // test if due date is valid
    @Test
    public void testAssignTaskOverdue() {
        assertFalse(this.taskUseCases.assignTask(username,
                        "207 project",
                        "Eipi",
                        "Phase 3",
                        "2002-11-17"),
                "Failure: Due date had passed");
    }

    // test if user can assign a task to user2
    @Test
    public void testAssignTaskSuccess() {
        Team team = userList.getUser(username).getTeam("207 project");
        User user2 = userList.getUser("Eipi");
        team.addMem(user2);
        user2.addTeam(team);

        assertTrue(this.taskUseCases.assignTask(username,
                        "207 project",
                        "Eipi",
                        "Phase 3",
                        "2021-11-17"),
                "Failure: User cannot assign a task to user2.");
    }
}