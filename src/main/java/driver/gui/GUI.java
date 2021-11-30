package driver.gui;

import constants.Fonts;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * This is our graphical user interface.
 */
public class GUI extends Application {
    public static void run() {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Set up the stage (we only need 1 window, so 1 stage only)
        primaryStage.setTitle("HowTodoit");
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);

        // Set up login/register view root and scene
        Pane loginRegisterRoot = new Pane();
        Scene loginRegisterScene = new Scene(loginRegisterRoot, 800, 600);
        primaryStage.setScene(loginRegisterScene);

        // Create greeting title
        setUpTitleText(loginRegisterRoot);

        // Create usn and pwd text areas, split into 2 methods to be more flexible (yeah duplicate code)
        TextArea usnTextArea = getUsnTextArea(loginRegisterRoot);
        TextArea pwdTextArea = getPswTextArea(loginRegisterRoot);

        // Create login and register buttons, split into 2 methods to be more flexible (yeah duplicate code)
        createLoginButton(loginRegisterRoot, usnTextArea, pwdTextArea);
        createRegisterButton(loginRegisterRoot, usnTextArea, pwdTextArea);

        // Deal with events exmaple
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED,  (event) -> {
            System.out.println("Key pressed: " + event.toString());

            switch(event.getCode().getCode()) {
                case 27 : { // ESC key
                    primaryStage.close();
                    break;
                }
                case 10 : { // Return
                    System.out.println("pressed return");
                }
                default:  {
                    System.out.println("Unrecognized key");
                }
            }
        });

        // Display the stage window and here we go
        primaryStage.show();
    }

    /**
     * Set up the title text.
     * @param loginRegisterRoot the view root
     */
    private void setUpTitleText(Pane loginRegisterRoot) {
        Label titleText = new Label("Welcome to HowTodoit: a virtual to-do-list app!");
        titleText.setFont(Fonts.titleFont);
        titleText.setPrefWidth(700);
        titleText.setLayoutX(xForCenter(loginRegisterRoot, titleText));
        titleText.setLayoutY(50);
        loginRegisterRoot.getChildren().add(titleText);
    }

    /**
     * Return the username text area.
     * @param loginRegisterRoot the view root
     * @return the username text area
     */
    private TextArea getUsnTextArea(Pane loginRegisterRoot) {
        TextArea usnTextArea = new TextArea();
        usnTextArea.setPrefSize(300, 50);
        usnTextArea.setLayoutX(xForCenter(loginRegisterRoot, usnTextArea));
        usnTextArea.setLayoutY(200);
        loginRegisterRoot.getChildren().add(usnTextArea);
        setUpUsnText(loginRegisterRoot, usnTextArea);
        return usnTextArea;
    }

    /**
     * Set up username text.
     * @param loginRegisterRoot the view root
     * @param usnTextArea the text area where user enters username
     */
    private void setUpUsnText(Pane loginRegisterRoot, TextArea usnTextArea) {
        Label usnText = new Label("Username:");
        usnText.setFont(Fonts.buttonFont);
        usnText.setPrefWidth(100);
        usnText.setLayoutX(usnTextArea.getLayoutX()-120);
        usnText.setLayoutY(usnTextArea.getLayoutY()+10);
        loginRegisterRoot.getChildren().add(usnText);
    }

    /**
     * Return the password text area.
     * @param loginRegisterRoot the view root
     * @return the password text area
     */
    private TextArea getPswTextArea(Pane loginRegisterRoot) {
        TextArea pwdTextArea = new TextArea();
        pwdTextArea.setPrefSize(300, 50);
        pwdTextArea.setLayoutX(xForCenter(loginRegisterRoot, pwdTextArea));
        pwdTextArea.setLayoutY(275);
        loginRegisterRoot.getChildren().add(pwdTextArea);
        setUpPswText(loginRegisterRoot, pwdTextArea);
        return pwdTextArea;
    }

    /**
     * Set up password text.
     * @param loginRegisterRoot the view root
     * @param pwdTextArea the text area where user enters username
     */
    private void setUpPswText(Pane loginRegisterRoot, TextArea pwdTextArea) {
        Label usnText = new Label("Password:");
        usnText.setFont(Fonts.buttonFont);
        usnText.setPrefWidth(100);
        usnText.setLayoutX(pwdTextArea.getLayoutX()-120);
        usnText.setLayoutY(pwdTextArea.getLayoutY()+10);
        loginRegisterRoot.getChildren().add(usnText);
    }

    /**
     * Create the log in button.
     * @param loginRegisterRoot the view root
     * @param usnTextArea the text area where user enters username
     * @param pwdTextArea the text area where user enters password
     */
    private void createLoginButton(Pane loginRegisterRoot, TextArea usnTextArea, TextArea pwdTextArea) {
        Button loginButton = new Button("Log In");
        loginButton.setFont(Fonts.buttonFont);
        loginButton.setPrefSize(200, 30);
        loginButton.setLayoutX(xForCenter(loginRegisterRoot, loginButton));
        loginButton.setLayoutY(400);
        loginRegisterRoot.getChildren().add(loginButton);

        loginButton.setOnAction(value ->  {
            loginButton.setText(usnTextArea.getText());
        });
        // loginButton.setId("login"); not the most useful here, but other command buttons will use setId
    }

    /**
     * Create the register button.
     * @param loginRegisterRoot the view root
     * @param usnTextArea the text area where user enters username
     * @param pwdTextArea the text area where user enters password
     */
    private void createRegisterButton(Pane loginRegisterRoot, TextArea usnTextArea, TextArea pwdTextArea) {
        Button registerButton = new Button("Register & Log In");
        registerButton.setFont(Fonts.buttonFont);
        registerButton.setPrefSize(200, 30);
        registerButton.setLayoutX(xForCenter(loginRegisterRoot, registerButton));
        registerButton.setLayoutY(450);
        loginRegisterRoot.getChildren().add(registerButton);
    }

    /**
     * This class returns the top-left x-position required to center the control horizontally in the given pane.
     * @param pane the pane view root
     * @param control ex: button, text area, etc.
     * @return the corresponding top-left x-position
     */
    private double xForCenter(Pane pane, Control control) {
        return (pane.getWidth() - control.getPrefWidth()) / 2;
    }
}
