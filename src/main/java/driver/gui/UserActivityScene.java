package driver.gui;

import constants.Fonts;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;

import static driver.gui.LoginRegisterScene.xForCenter;

public class UserActivityScene {
    private static Scene userActivityScene;

    public static void setUpScene() {
        // Set up UserActivity view root and scene
        Pane userActivityRoot = new Pane();
        userActivityScene = new Scene(userActivityRoot, 800, 600);

        // Create greeting title
        setUpUserActivityTitleText(userActivityRoot);


        // Create text area where user can enter commands

        TextArea commandTextArea = getCommandTextArea(userActivityRoot);

        // Create a Label where remote result are displayed
        Label resultLabel = getResultLabel(userActivityRoot);


        //Create undo and redo buttons
        createUndoButton(userActivityRoot, commandTextArea);
        createRedoButton(userActivityRoot, commandTextArea);

        //Create save and log out buttons
        createSaveButton(userActivityRoot, commandTextArea);
        createLogOutButton(userActivityRoot, commandTextArea);

        //Create the execute button
        createExecuteButton(userActivityRoot, commandTextArea);

    }

    /**
     * Set up the title text.
     *
     * @param userActivityRoot the view root
     */
    private static void setUpUserActivityTitleText(Pane userActivityRoot) {
        Label userActivity = new Label("User Activity");
        userActivity.setFont(Fonts.titleFont);
        userActivity.setPrefWidth(200);
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

    /**
     * Set up the title text.
     *
     * @param userActivityRoot the view root
     */



    private static TextArea getCommandTextArea(Pane userActivityRoot){
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
     * @param commandTextArea       the text area where user enters username
     */
    private static void setUpCommandText(Pane userActivityRoot, TextArea commandTextArea){
        Label commandText = new Label("Command");
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
     */
    private static Label getResultLabel(Pane userActivityRoot){
        Label resultLabel = new Label();
        resultLabel.setBorder(Border.EMPTY);
        resultLabel.setPrefSize(300, 100);
        resultLabel.setLayoutX(xForCenter(userActivityRoot, resultLabel));
        resultLabel.setLayoutY(350);
        resultLabel.setFont(Fonts.buttonFont);
        userActivityRoot.getChildren().add(resultLabel);
        setUpResultText(userActivityRoot, resultLabel);
        return resultLabel;
    }

    /**
     * Set up resultShowing text.
     *
     * @param userActivityRoot the view root
     * @param resultLabel       the text area where user enters username
     */
    private static void setUpResultText(Pane userActivityRoot, Label resultLabel){
        Label resultText = new Label("result");
        resultText.setFont(Fonts.buttonFont);
        resultText.setPrefWidth(100);
        resultText.setLayoutX(resultLabel.getLayoutX() - 120);
        resultText.setLayoutY(resultLabel.getLayoutY() + 10);
        userActivityRoot.getChildren().add(resultText);
    }

    /**
     * Create the undo button.
     *
     * @param userActivityRoot the view root
     */
    private static void createUndoButton(Pane userActivityRoot,  TextArea commandTextArea){
        Button undoButton = new Button("Undo");
        undoButton.setFont(Fonts.buttonFont);
        undoButton.setPrefSize(150,30);
        undoButton.setLayoutX(50);
        undoButton.setLayoutY(50);
        userActivityRoot.getChildren().add(undoButton);
    }





    /**
     * Create the redo button.
     *
     * @param userActivityRoot the view root
     */
    private static void createSaveButton(Pane userActivityRoot, TextArea commandTextArea){
        Button saveButton = new Button("Redo");
        saveButton.setFont(Fonts.buttonFont);
        saveButton.setPrefSize(150,30);
        saveButton.setLayoutX(50);
        saveButton.setLayoutY(110);
        userActivityRoot.getChildren().add(saveButton);
    }





    /**
     * Create the save button.
     *
     * @param userActivityRoot the view root
     */
    private static void createRedoButton(Pane userActivityRoot, TextArea commandTextArea){
        Button redoButton = new Button("Save");
        redoButton.setFont(Fonts.buttonFont);
        redoButton.setPrefSize(150,30);
        redoButton.setLayoutX(600);
        redoButton.setLayoutY(50);
        userActivityRoot.getChildren().add(redoButton);
    }





    /**
     * Create the redo button.
     *
     * @param userActivityRoot the view root
     */
    private static void createLogOutButton(Pane userActivityRoot, TextArea commandTextArea){
        Button logOut = new Button("Log Out");
        logOut.setFont(Fonts.buttonFont);
        logOut.setPrefSize(150,30);
        logOut.setLayoutX(600);
        logOut.setLayoutY(110);
        userActivityRoot.getChildren().add(logOut);
    }




    /**
     * Create the execute button.
     *
     * @param userActivityRoot the view root
     */
    private static void createExecuteButton(Pane userActivityRoot, TextArea commandTextArea){
        Button execute = new Button("Execute");
        execute.setFont(Fonts.buttonFont);
        execute.setPrefSize(150,30);
        execute.setLayoutX(500);
        execute.setLayoutY(210);
        userActivityRoot.getChildren().add(execute);
    }



}
