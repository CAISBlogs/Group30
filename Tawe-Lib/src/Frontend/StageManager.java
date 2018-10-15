package Frontend;

import javafx.application.Application;
import javafx.stage.Stage;

public class StageManager extends Application {

    private static Stage primaryStage;
    private static Login_Page login_page;
    private static Account_Create_Page account_create_page;

    public static void create(){
        launch();
    }

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     * <p>
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set. The primary stage will be embedded in
     *                     the browser if the application was launched as an applet.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages and will not be embedded in the browser.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        StageManager.primaryStage = primaryStage;
        initializePages();
        login_page.create();
    }

    private void initializePages() {
        login_page = new Login_Page();
        account_create_page = new Account_Create_Page();
    }


    /**
     * Gets primaryStage
     *
     * @return value of primaryStage
     */
    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static Login_Page getLogin_page(){
        return login_page;
    }

    public static Account_Create_Page getAccountCreatePage() {
        return account_create_page;
    }
}
