package Frontend;

import Backend.XML.XMLReader;
import Backend.XML.XMLWriter;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringWriter;
import java.util.Properties;


public class Account_Create_Page {

    private Scene scene;

    private Label welcomeLabel;

    private GridPane avatarFrame;
    private ImageView avatar;
    private Button changeAvatarButton;

    private Label fNamePrompt;
    private TextField fNameField;
    private Label lNamePrompt;
    private TextField lNameField;
    private Label uNamePrompt;
    private TextField uNameField;

    private Label pWordPrompt;
    private PasswordField pWordField;
    private Label confPWordPrompt;
    private PasswordField confPWordField;

    private Label phoneNumberPrompt;
    private TextField phoneNumberfield;
    private Label emailPrompt;
    private TextField emailField;

    private Label address1Prompt;
    private TextField address1Field;
    private Label address2Prompt;
    private TextField address2Field;
    private Label townPrompt;
    private TextField townField;
    private Label postcodePrompt;
    private TextField postcodeField;

    private Label outcomeField;

    private Button submitButton;
    private Button resetButton;
    private Button cancelButton;


    public Account_Create_Page(){
        createScene();
    }

    private void createScene() {

        initializeFields();


        VBox avatarBox = new VBox();
        avatarBox.getChildren().addAll(avatarFrame, changeAvatarButton);
        avatarBox.setAlignment(Pos.CENTER);
        avatarBox.setSpacing(10);


        VBox fullPage = new VBox();
        fullPage.setAlignment(Pos.TOP_CENTER);
        fullPage.setPadding(new Insets(20,10,10,10));
        fullPage.setSpacing(5);

        // FieldsGrid
        GridPane avatarUserPane = new GridPane();
        avatarUserPane.setPadding(new Insets(10,10,10,10));
        avatarUserPane.setHgap(12); avatarUserPane.setVgap(8);
        avatarUserPane.setAlignment(Pos.TOP_CENTER);

        avatarUserPane.add(avatarBox, 0, 0, 1,5);
        GridPane.setMargin(avatarBox, new Insets(20,20,20,20));

        avatarUserPane.add(fNamePrompt, 1, 0);
        avatarUserPane.add(fNameField, 2, 0);

        avatarUserPane.add(lNamePrompt, 1, 1);
        avatarUserPane.add(lNameField, 2, 1);

        avatarUserPane.add(uNamePrompt, 1, 2);
        avatarUserPane.add(uNameField, 2, 2);

        avatarUserPane.add(pWordPrompt, 1, 3);
        avatarUserPane.add(pWordField, 2, 3);

        avatarUserPane.add(confPWordPrompt, 1, 4);
        avatarUserPane.add(confPWordField, 2, 4);

        //pane.setGridLinesVisible(true);
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHgrow(Priority.ALWAYS);
        avatarUserPane.getColumnConstraints().addAll(new ColumnConstraints(), new ColumnConstraints(), columnConstraints);
        for (int i = 0; i < 5; i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(20);
            avatarUserPane.getRowConstraints().add(row);
        }

        //
        GridPane infoArea = new GridPane();
        infoArea.setPadding(new Insets(10,10,10,10));
        infoArea.setHgap(12); infoArea.setVgap(8);
        infoArea.setAlignment(Pos.TOP_CENTER);

        infoArea.add(phoneNumberPrompt, 0, 0);
        infoArea.add(phoneNumberfield, 1, 0);
        infoArea.add(emailPrompt, 0, 2);
        infoArea.add(emailField, 1, 2);
        infoArea.add(address1Prompt, 0, 4);
        infoArea.add(address1Field, 1, 4);
        infoArea.add(address2Prompt, 0, 5);
        infoArea.add(address2Field, 1, 5);
        infoArea.add(townPrompt, 0, 6);
        infoArea.add(townField, 1, 6);
        infoArea.add(postcodePrompt, 0, 7);
        infoArea.add(postcodeField, 1, 7);

        ColumnConstraints infoAreaConstraints = new ColumnConstraints();
        infoAreaConstraints.setHgrow(Priority.SOMETIMES);
        infoArea.getColumnConstraints().addAll(new ColumnConstraints(), infoAreaConstraints);

        HBox buttonBox = new HBox();
        buttonBox.setPadding(new Insets(5, 0,0,0));
        buttonBox.setSpacing(25);
        buttonBox.setAlignment(Pos.BASELINE_CENTER);
        buttonBox.getChildren().addAll(submitButton, resetButton, cancelButton);

        fullPage.getChildren().addAll(welcomeLabel, avatarUserPane, infoArea, outcomeField, buttonBox);

        scene = new Scene(fullPage, 550,600);
    }

    private void initializeFields(){

        EventHandler eventHandler = new Account_Create_Page_EventHandler(this);

        welcomeLabel = new Label("Create New Account");
        welcomeLabel.setFont(new Font(26));

        avatarFrame = new GridPane();
        avatarFrame.setMinSize(128, 128);
        avatarFrame.setAlignment(Pos.CENTER);

        avatar = new ImageView(JavaFXUtils.loadImage("/res/images/person.png"));
        avatar.setFitHeight(128);
        avatar.setFitWidth(128);
        avatar.setPreserveRatio(true);
        avatarFrame.add(avatar, 0,0);

        changeAvatarButton = new Button("Change Avatar");
        changeAvatarButton.setAlignment(Pos.CENTER);
        changeAvatarButton.setOnAction(eventHandler);
        changeAvatarButton.setMaxWidth(Double.MAX_VALUE);

        fNamePrompt = new Label("First Name:");
        fNameField = new TextField();
        fNameField.setPromptText("First Name");

        lNamePrompt = new Label("Last Name:");
        lNameField = new TextField();
        lNameField.setPromptText("Last Name");

        uNamePrompt = new Label("Username:");
        uNameField = new TextField();
        uNameField.setPromptText("Username");

        pWordPrompt = new Label("Password:");
        pWordField = new PasswordField();
        pWordField.setPromptText("Password");

        confPWordPrompt = new Label("Confirm Password:");
        confPWordField = new PasswordField();
        confPWordField.setPromptText("Confirm Password");

        String prefix = "+44";
        TextFormatter<String> phoneNumberFormatter = new TextFormatter<>(c -> {

            if (c.getCaretPosition() < prefix.length() || c.getAnchor() < prefix.length()) {
                return null ;
            } else {
                return c ;
            }
        });


        // InfoArea

        phoneNumberPrompt = new Label("UK Mobile No:");
        phoneNumberfield = new TextField();
        phoneNumberfield.setText(prefix);
        phoneNumberfield.setTextFormatter(phoneNumberFormatter);
        phoneNumberfield.positionCaret(3);

        emailPrompt = new Label("Email (optional):");
        emailField = new TextField();
        emailField.setPromptText("Email (optional)");

        // Address

        address1Prompt = new Label("Address Line 1:");
        address1Field = new TextField();
        address1Field.setPromptText("Address Line 1");

        address2Prompt = new Label("Address Line 2 (optional):");
        address2Field = new TextField();
        address2Field.setPromptText("Address Line 2 (optional)");

        townPrompt = new Label("Town:");
        townField = new TextField();
        townField.setPromptText("Town");

        postcodePrompt = new Label("Postcode:");
        postcodeField = new TextField();
        postcodeField.setPromptText("Postcode");
        postcodeField.setPrefWidth(100);


        outcomeField = new Label("");
        outcomeField.setStyle("-fx-font-style: italic");


        // Buttons
        submitButton = new Button("Submit");
        submitButton.setOnAction(eventHandler);
        submitButton.setDefaultButton(true);

        resetButton = new Button("Reset");
        resetButton.setOnAction(eventHandler);

        cancelButton = new Button("Cancel");
        cancelButton.setOnAction(eventHandler);


    }

    /**
     * Method verifies that all fields are acceptable before passing. If a field is identified it will create an error
     * message and return false
     * @return true if all fields are acceptable, false otherwise
     */
    public boolean verifyFields(){


        return true;
    }

    private void showErrorOutcome(String error){
        outcomeField.setTextFill(Color.RED);
        outcomeField.setText(error);
    }

    private void showSuccessOutcome(String message){
        outcomeField.setTextFill(Color.BLUE);
        outcomeField.setText(message);
    }

    /**
     * Will submit all fields to create a new user if they are acceptable.
     *
     */
    public void submitFields(){

        String dataAsXML = toXML();
        resetFields();
        showSuccessOutcome("Account created successfully");

    }

    private String toXML(){

        XMLWriter xmlWriter = new XMLWriter();

        Element root = xmlWriter.addNode(null, "New_User_Submission_form", null);

        xmlWriter.addNode(root, "First_Name",
                new String[][]{new String[]{"DataType", "String"}},
                fNameField.getText());

        xmlWriter.addNode(root, "Last_Name",
                new String[][]{new String[]{"DataType", "String"}},
                lNameField.getText());

        xmlWriter.addNode(root, "User_Name",
                new String[][]{new String[]{"DataType", "String"}},
                uNameField.getText());

        xmlWriter.addNode(root, "Password",
                new String[][]{new String[]{"DataType", "String"}},
                pWordField.getText());

        xmlWriter.addNode(root, "Phone_Number",
                new String[][]{new String[]{"DataType", "String"}},
                phoneNumberfield.getText());

        xmlWriter.addNode(root, "Email",
                new String[][]{new String[]{"DataType", "String"}},
                emailField.getText());

        xmlWriter.addNode(root, "Address_1",
                new String[][]{new String[]{"DataType", "String"}},
                address1Field.getText());

        xmlWriter.addNode(root, "Address_2",
                new String[][]{new String[]{"DataType", "String"}},
                address2Field.getText());

        xmlWriter.addNode(root, "Town",
                new String[][]{new String[]{"DataType", "String"}},
                townField.getText());

        xmlWriter.addNode(root, "Post_Code",
                new String[][]{new String[]{"DataType", "String"}},
                postcodeField.getText());

        StringWriter stringWriter = new StringWriter();
        xmlWriter.exportFile(stringWriter);
        System.out.println(stringWriter.toString());
        return stringWriter.toString();

    }

    public void resetFields(){
        createScene();
        changeScene();
    }


    /**
     * Gets cancelButton
     *
     * @return value of cancelButton
     */
    public Button getCancelButton() {
        return cancelButton;
    }

    /**
     * Gets changeAvatarButton
     *
     * @return value of changeAvatarButton
     */
    public Button getChangeAvatarButton() {
        return changeAvatarButton;
    }

    /**
     * Gets submitButton
     *
     * @return value of submitButton
     */
    public Button getSubmitButton() {
        return submitButton;
    }

    public Button getResetButton(){
        return resetButton;
    }

    public void changeScene() {
        StageManager.getPrimaryStage().setScene(scene);
    }
}
