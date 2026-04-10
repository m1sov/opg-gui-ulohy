package sk.spse.uloha4.declarative;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.Random;

public class Controller {

    @FXML private VBox vbox1;
    @FXML private VBox vbox2;
    @FXML private VBox vbox3;
    @FXML private VBox vbox4;

    @FXML private ImageView imageView1;
    @FXML private ImageView imageView2;
    @FXML private ImageView imageView3;
    @FXML private ImageView imageView4;

    private final Random random = new Random();

    @FXML
    private void randomize() {
        vbox1.setStyle("-fx-background-color: " + getRandomColor());
        vbox2.setStyle("-fx-background-color: " + getRandomColor());
        vbox3.setStyle("-fx-background-color: " + getRandomColor());
        vbox4.setStyle("-fx-background-color: " + getRandomColor());

        randomizeImage(imageView1);
        randomizeImage(imageView2);
        randomizeImage(imageView3);
        randomizeImage(imageView4);
    }

    @FXML
    private void closeApp() {
        Platform.exit();
    }

    private void randomizeImage(ImageView iv) {
        iv.setFitWidth(50 + random.nextInt(151));
        iv.setOpacity(0.2 + random.nextDouble() * 0.8);
        iv.setRotate(-180 + random.nextInt(361));
    }

    private String getRandomColor() {
        return "rgb(" + random.nextInt(256) + "," +
                random.nextInt(256) + "," +
                random.nextInt(256) + ")";
    }
}