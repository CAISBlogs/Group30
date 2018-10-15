import Backend.API;
import Frontend.Login_Page;
import Frontend.StageManager;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Main {

    public static void main(String[] args){

        API.init(args);
        StageManager.create();

    }
}
