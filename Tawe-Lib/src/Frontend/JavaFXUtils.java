package Frontend;

import javafx.scene.image.Image;

public class JavaFXUtils {

    public static Image loadImage(String path){
        return new Image(JavaFXUtils.class.getResourceAsStream(path));
    }
}
