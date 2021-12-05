package driver.gui;

import constants.Fonts;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class LoginRegisterScene {
    private static Scene loginRegisterScene;

    public static void setUpScene() {
        // Set up login/register view root and scene
        Pane loginRegisterRoot = new Pane();
        loginRegisterScene = new Scene(loginRegisterRoot, 800, 600);

        // Create greeting title
        setUpTitleText(loginRegisterRoot);


        // Create usn and pwd text areas, split into 2 methods to be more flexible (yeah duplicate code)
        TextArea usnTextArea = getUsnTextArea(loginRegisterRoot);
        PasswordField pwdTextArea = getPswTextArea(loginRegisterRoot);



        // Create login and register buttons, split into 2 methods to be more flexible (yeah duplicate code)
        createLoginButton(loginRegisterRoot, usnTextArea, pwdTextArea);
        createRegisterButton(loginRegisterRoot, usnTextArea, pwdTextArea);
    }

    /**
     * Return loginRegisterScene.
     *
     * @return loginRegisterScene
     */
    public static Scene getScene() {
        return loginRegisterScene;
    }

    /**
     * Set up the title text.
     *
     * @param loginRegisterRoot the view root
     */
    private static void setUpTitleText(Pane loginRegisterRoot) {
        Label titleText = new Label("Welcome to HowTodoit: a virtual to-do-list app!");
        titleText.setFont(Fonts.titleFont);
        titleText.setPrefWidth(700);
        titleText.setLayoutX(xForCenter(loginRegisterRoot, titleText));
        titleText.setLayoutY(50);
        loginRegisterRoot.getChildren().add(titleText);
    }

    /**
     * Return the username text area.
     *
     * @param loginRegisterRoot the view root
     * @return the username text area
     */
    private static TextArea getUsnTextArea(Pane loginRegisterRoot) {
        TextArea usnTextArea = new TextArea();
        usnTextArea.setPrefSize(300, 40);
        usnTextArea.setLayoutX(xForCenter(loginRegisterRoot, usnTextArea));
        usnTextArea.setLayoutY(200);
        usnTextArea.setFont(Fonts.buttonFont);
        loginRegisterRoot.getChildren().add(usnTextArea);
        setUpUsnText(loginRegisterRoot, usnTextArea);
        return usnTextArea;
    }

    /**
     * Set up username text.
     *
     * @param loginRegisterRoot the view root
     * @param usnTextArea       the text area where user enters username
     */
    private static void setUpUsnText(Pane loginRegisterRoot, TextArea usnTextArea) {
        Label usnText = new Label("Username:");
        usnText.setFont(Fonts.buttonFont);
        usnText.setPrefWidth(100);
        usnText.setLayoutX(usnTextArea.getLayoutX() - 120);
        usnText.setLayoutY(usnTextArea.getLayoutY() + 10);
        loginRegisterRoot.getChildren().add(usnText);
    }

    /**
     * Return the password text area.
     *
     * @param loginRegisterRoot the view root
     * @return the password text area
     */
    private static PasswordField getPswTextArea(Pane loginRegisterRoot) {
        PasswordField pwdTextArea = new PasswordField();
        pwdTextArea.setPrefSize(300, 40);
        pwdTextArea.setLayoutX(xForCenter(loginRegisterRoot, pwdTextArea));
        pwdTextArea.setLayoutY(275);
        pwdTextArea.setFont(Fonts.buttonFont);
        loginRegisterRoot.getChildren().add(pwdTextArea);
        setUpPswText(loginRegisterRoot, pwdTextArea);
        return pwdTextArea;
    }

    /**
     * Set up password text.
     *
     * @param loginRegisterRoot the view root
     * @param pwdTextArea       the text area where user enters username
     */
    private static void setUpPswText(Pane loginRegisterRoot, PasswordField pwdTextArea) {
        Label usnText = new Label("Password:");
        usnText.setFont(Fonts.buttonFont);
        usnText.setPrefWidth(100);
        usnText.setLayoutX(pwdTextArea.getLayoutX() - 120);
        usnText.setLayoutY(pwdTextArea.getLayoutY() + 10);
        loginRegisterRoot.getChildren().add(usnText);
    }

    /**
     * Create the log in button.
     *
     * @param loginRegisterRoot the view root
     * @param usnTextArea       the text area where user enters username
     * @param pwdTextArea       the text area where user enters password
     */
    private static void createLoginButton(Pane loginRegisterRoot, TextArea usnTextArea, PasswordField pwdTextArea) {
        Button loginButton = new Button("Log In");
        loginButton.setFont(Fonts.buttonFont);
        loginButton.setPrefSize(200, 30);
        loginButton.setLayoutX(xForCenter(loginRegisterRoot, loginButton));
        loginButton.setLayoutY(400);
        loginRegisterRoot.getChildren().add(loginButton);

        loginButton.setOnAction(value -> {
            loginButton.setText(usnTextArea.getText());
            // GUI.switchToNewScene(UserActivityScene.getScene());
        });
        // loginButton.setId("login"); not the most useful here, but other command buttons will use setId
    }

    /**
     * Create the register button.
     *
     * @param loginRegisterRoot the view root
     * @param usnTextArea       the text area where user enters username
     * @param pwdTextArea       the text area where user enters password
     */
    private static void createRegisterButton(Pane loginRegisterRoot, TextArea usnTextArea, PasswordField pwdTextArea) {
        Button registerButton = new Button("Register & Log In");
        registerButton.setFont(Fonts.buttonFont);
        registerButton.setPrefSize(200, 30);
        registerButton.setLayoutX(xForCenter(loginRegisterRoot, registerButton));
        registerButton.setLayoutY(450);
        loginRegisterRoot.getChildren().add(registerButton);
    }

    /**
     * This class returns the top-left x-position required to center the control horizontally in the given pane.
     *
     * @param pane    the pane view root
     * @param control ex: button, text area, etc.
     * @return the corresponding top-left x-position
     */
    static double xForCenter(Pane pane, Control control) {
        return (pane.getWidth() - control.getPrefWidth()) / 2;
    }
}
