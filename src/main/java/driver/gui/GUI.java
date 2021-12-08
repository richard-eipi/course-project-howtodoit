package driver.gui;

import constants.Commands;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is our graphical user interface.
 */
public class GUI extends Application {
    private static Stage stage;

    public static void run() {
        launch();
    }

    /**
     * Change the stage to a scene.
     *
     * @param scene new scene to be changed to
     */
    public static void switchToNewScene(Scene scene) {
        stage.setScene(scene);
    }

    /**
     * Start running.
     *
     * @param primaryStage the primary stage for javafx
     */
    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        // Set up the stage (we only need 1 window, so 1 stage only)
        primaryStage.setTitle("HowTodoit");
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);

        // Set up login/register scene
        LoginRegisterScene.setUpScene();
        switchToNewScene(LoginRegisterScene.getScene());

        // Load commands
        Commands.loadCommands();

        // Display the stage window and here we go
        primaryStage.show();
    }
}
