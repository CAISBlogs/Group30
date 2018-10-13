import Backend.API;
import Frontend.Login_Page;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Main {

    public static void main(String[] args){

        API.init(args);
        Login_Page.create();

    }
}
