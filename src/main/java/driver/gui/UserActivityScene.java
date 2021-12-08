package driver.gui;

import constants.Fonts;
import controllers.DataMemoryController;
import driver.commands.CommandExecutor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

import static helpers.GUISceneSetUp.xForCenter;

/**
 * This class represents the scene for user activities.
 */
public class UserActivityScene {
    /**
     * The scene object.
     */
    private static Scene userActivityScene;

    /**
     * Sets the username after logging in
     *
     * @param username the username
     */
    public static void setUsername(String username) {
        CommandExecutor.setUsername(username);
    }

    /**
     * Set up the scene.
     */
    public static void setUpScene() {
        // Set up UserActivity view root and scene
        Pane userActivityRoot = new Pane();
        userActivityScene = new Scene(userActivityRoot, 800, 600);

        // Create greeting title
        setUpUserActivityTitleText(userActivityRoot);

        // Create text area where user can enter commands
        TextArea commandTextArea = getCommandTextArea(userActivityRoot);

        // Create a Label where remote result are displayed
        Label resultLabel = createResultLabel(userActivityRoot);

        // Create undo and redo buttons
        createUndoButton(userActivityRoot, resultLabel);
        createRedoButton(userActivityRoot, resultLabel);

        // Create save and log out buttons
        createSaveButton(userActivityRoot, resultLabel);
        createLogOutButton(userActivityRoot);

        // Create the execute button
        createExecuteButton(userActivityRoot, commandTextArea, resultLabel);

    }

    /**
     * Set up the title text.
     *
     * @param userActivityRoot the view root
     */
    private static void setUpUserActivityTitleText(Pane userActivityRoot) {
        Label userActivity = new Label("Hi there!");
        userActivity.setFont(Fonts.titleFont);
        userActivity.setPrefWidth(150);
        userActivity.setLayoutX(xForCenter(userActivityRoot, userActivity));
        userActivity.setLayoutY(50);
        userActivityRoot.getChildren().add(userActivity);
    }

    /**
     * Return UserActivityScene.
     *
     * @return userActivityScene
     */
    public static Scene getScene() {
        return userActivityScene;
    }

    private static TextArea getCommandTextArea(Pane userActivityRoot) {
        TextArea commandTextArea = new TextArea();
        commandTextArea.setPrefSize(300, 40);
        commandTextArea.setLayoutX(xForCenter(userActivityRoot, commandTextArea));
        commandTextArea.setLayoutY(200);
        commandTextArea.setFont(Fonts.buttonFont);
        userActivityRoot.getChildren().add(commandTextArea);
        setUpCommandText(userActivityRoot, commandTextArea);
        return commandTextArea;
    }

    /**
     * Set up enterCommand text.
     *
     * @param userActivityRoot the view root
     * @param commandTextArea  the text area where user enters username
     */
    private static void setUpCommandText(Pane userActivityRoot, TextArea commandTextArea) {
        Label commandText = new Label("Command:");
        commandText.setFont(Fonts.buttonFont);
        commandText.setPrefWidth(100);
        commandText.setLayoutX(commandTextArea.getLayoutX() - 120);
        commandText.setLayoutY(commandTextArea.getLayoutY() + 10);
        userActivityRoot.getChildren().add(commandText);
    }

    /**
     * Set up the result label.
     *
     * @param userActivityRoot the view root
     * @return the label where results are displayed
     */
    private static Label createResultLabel(Pane userActivityRoot) {
        Label resultLabel = new Label();
        // resultLabel.setBorder(Border.EMPTY);
        resultLabel.setStyle("-fx-border-color: black");
        resultLabel.setPrefSize(600, 150);
        resultLabel.setLayoutX(xForCenter(userActivityRoot, resultLabel));
        resultLabel.setLayoutY(300);
        resultLabel.setFont(Fonts.buttonFont);
        userActivityRoot.getChildren().add(resultLabel);
        return resultLabel;
    }

    /**
     * Create the undo button.
     *
     * @param userActivityRoot the view root
     * @param resultLabel      the label where results are displayed
     */
    private static void createUndoButton(Pane userActivityRoot, Label resultLabel) {
        Button undoButton = new Button("Undo");
        undoButton.setFont(Fonts.buttonFont);
        undoButton.setPrefSize(150, 30);
        undoButton.setLayoutX(50);
        undoButton.setLayoutY(50);
        userActivityRoot.getChildren().add(undoButton);
        undoButton.setOnAction(value -> {
            String output = DataMemoryController.getInstance().undo();
            resultLabel.setText(output);
        });
    }

    /**
     * Create the redo button.
     *
     * @param userActivityRoot the view root
     * @param resultLabel      the label where results are displayed
     */
    private static void createRedoButton(Pane userActivityRoot, Label resultLabel) {
        Button redoButton = new Button("Redo");
        redoButton.setFont(Fonts.buttonFont);
        redoButton.setPrefSize(150, 30);
        redoButton.setLayoutX(50);
        redoButton.setLayoutY(110);
        userActivityRoot.getChildren().add(redoButton);
        redoButton.setOnAction(value -> {
            String output = DataMemoryController.getInstance().redo();
            resultLabel.setText(output);
        });
    }

    /**
     * Create the save button.
     *
     * @param userActivityRoot the view root
     * @param resultLabel      the label where results are displayed
     */
    private static void createSaveButton(Pane userActivityRoot, Label resultLabel) {
        Button saveButton = new Button("Save");
        saveButton.setFont(Fonts.buttonFont);
        saveButton.setPrefSize(150, 30);
        saveButton.setLayoutX(600);
        saveButton.setLayoutY(50);
        userActivityRoot.getChildren().add(saveButton);
        saveButton.setOnAction(value -> {
            String output = DataMemoryController.getInstance().save();
            resultLabel.setText(output);
        });
    }

    /**
     * Create the redo button.
     *
     * @param userActivityRoot the view root
     */
    private static void createLogOutButton(Pane userActivityRoot) {
        Button logOutButton = new Button("Log Out");
        logOutButton.setFont(Fonts.buttonFont);
        logOutButton.setPrefSize(150, 30);
        logOutButton.setLayoutX(600);
        logOutButton.setLayoutY(110);
        userActivityRoot.getChildren().add(logOutButton);
        logOutButton.setOnAction(value -> {
            DataMemoryController.getInstance().save();
            DataMemoryController.getInstance().cleanMemory();
            GUI.switchToNewScene(LoginRegisterScene.getScene());
        });
    }

    /**
     * Create the execute button.
     *
     * @param userActivityRoot the view root
     * @param resultLabel      the label where results are displayed
     */
    private static void createExecuteButton(Pane userActivityRoot, TextArea commandTextArea, Label resultLabel) {
        Button executeButton = new Button("Execute");
        executeButton.setFont(Fonts.buttonFont);
        executeButton.setPrefSize(150, 30);
        executeButton.setLayoutX(600);
        executeButton.setLayoutY(210);
        userActivityRoot.getChildren().add(executeButton);
        executeButton.setOnAction(value -> {
            try {
                String output = CommandExecutor.executeCommand(commandTextArea.getText());
                resultLabel.setText(output);
            } catch (Exception e) {
                resultLabel.setText(e.getMessage());
            }
        });
    }

}
