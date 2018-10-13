package Frontend;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.net.URL;

public class Login_Page extends Application {

    private int WIDTH = 450;
    private int HEIGHT = 235;

    private ImageView taweLibIcon;
    private Label welcomeLabel;
    private Label promptLabel;
    private Label postLoginPrompt;
    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;
    private Button createAccountButton;

    public static void create(){
        launch();
    }

    public void start(Stage primaryStage) throws Exception{

        layout(primaryStage);

    }

    public void setPostLoginPromptFailedLogin(){
        String invUnPass = "Invalid username or password";
        postLoginPrompt.setText(invUnPass);
        postLoginPrompt.setTextFill(Color.RED);
        postLoginPrompt.setStyle("-fx-font-style: italic");
        passwordField.setText("");
    }

    private void layout(Stage primaryStage){

        // Create EventHandler
        EventHandler eventHandler = new Login_Page_EventHandler(this);

        // Decorate Window
        primaryStage.setTitle("Welcome to Tawe-Lib");
        primaryStage.getIcons().add(loadImage("/res/images/TL.png"));
        primaryStage.setResizable(false);

        // Row 1
        taweLibIcon = new ImageView(loadImage("/res/images/TL.png"));
        taweLibIcon.setPreserveRatio(true);
        taweLibIcon.setFitWidth(50);
        taweLibIcon.setFitHeight(50);

        // Row 2
        welcomeLabel = new Label("Welcome to TAWE-LIB");
        welcomeLabel.setFont(new Font(18));

        // Row 3
        promptLabel = new Label("To continue please enter your username and password");
        promptLabel.setFont(new Font(12));

        // Row 4
        usernameField = new TextField();
        usernameField.setPromptText("Username");

        // Row 5
        passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        // Row 6
        loginButton = new Button("Login");
        createAccountButton = new Button("Create new account");

        loginButton.setOnAction(eventHandler);
        loginButton.setDefaultButton(true);
        createAccountButton.setOnAction(eventHandler);

        HBox buttonBox = new HBox();
        buttonBox.setSpacing(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(loginButton, createAccountButton);

        // Row 7
        postLoginPrompt = new Label("");
        postLoginPrompt.setFont(new Font(12));

        VBox layout = new VBox();
        layout.setPadding(new Insets(10,20,10,20));
        layout.setSpacing(5);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.getChildren().addAll(
                taweLibIcon,
                welcomeLabel,
                promptLabel,
                usernameField,
                passwordField,
                buttonBox,
                postLoginPrompt
        );

        Scene scene = new Scene(layout, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private Image loadImage(String path){
        return new Image(getClass().getResourceAsStream(path));
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public Button getCreateAccountButton() {
        return createAccountButton;
    }
}
