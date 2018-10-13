package Frontend;

import javafx.event.Event;
import javafx.event.EventHandler;

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
            System.out.println("Login with {\n"+
                "U:"+origin.getUsernameField().getText()+"\n"+
                "P:"+origin.getPasswordField().getText()+"\n}"
            );
            origin.setPostLoginPromptFailedLogin();
        }
        if(event.getSource() == origin.getCreateAccountButton()){
            System.out.println("Unimplemented field");
        }

    }
}
