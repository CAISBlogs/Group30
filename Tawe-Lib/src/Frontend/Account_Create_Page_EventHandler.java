package Frontend;

import javafx.event.Event;
import javafx.event.EventHandler;

public class Account_Create_Page_EventHandler implements EventHandler {

    private Account_Create_Page origin;

    public Account_Create_Page_EventHandler(Account_Create_Page account_create_page) {
        origin = account_create_page;
    }

    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */
    @Override
    public void handle(Event event) {
        if(event.getSource()==origin.getCancelButton()){
            origin.resetFields();
            StageManager.getLogin_page().changeScene();
        }
        else if(event.getSource()==origin.getSubmitButton()){
            if(origin.verifyFields()){
                origin.submitFields();
            }
        }
        else if(event.getSource()==origin.getResetButton()){
            origin.resetFields();
        }

    }
}
