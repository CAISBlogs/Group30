package Frontend;

import Backend.XML.XMLWriter;
import javafx.event.Event;
import javafx.event.EventHandler;
import org.w3c.dom.Element;

import java.io.StringWriter;


public class Login_Page_EventHandler implements EventHandler {

    private Login_Page origin;

    public Login_Page_EventHandler(Login_Page login_page) {
        origin = login_page;
    }

    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */
    @Override
    public void handle(Event event) {

        // If the "Login" button is pressed
        if(event.getSource() == origin.getLoginButton()){
            XMLWriter xmlWriter = new XMLWriter();
            Element root = xmlWriter.addNode(null, "Login_Request", null);
            xmlWriter.addNode(root, "Username",
                    new String[][]{new String[]{"DataType", "String"}},
                    origin.getUsernameField().getText());
            xmlWriter.addNode(root, "Password",
                    new String[][]{new String[]{"DataType", "String"}},
                    origin.getPasswordField().getText());
            StringWriter sw = new StringWriter();
            xmlWriter.exportFile(sw);
            System.out.println(sw);


            origin.setPostLoginPromptFailedLogin();
        }
        if(event.getSource() == origin.getCreateAccountButton()){
            StageManager.getAccountCreatePage().changeScene();
        }

    }
}
