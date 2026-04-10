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

    private String getRandomColor() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return String.format("rgb(%d,%d,%d)", r, g, b);
    }


    @FXML
    private void randomize() {
        randomizeItem(vbox1, imageView1);
        randomizeItem(vbox2, imageView2);
        randomizeItem(vbox3, imageView3);
        randomizeItem(vbox4, imageView4);
    }


    private void randomizeItem(VBox vbox, ImageView imageView) {


        vbox.setStyle("-fx-background-color: " + getRandomColor());


        double scale = 0.5 + random.nextDouble();
        double scale2 = 0.5 + random.nextDouble();
        imageView.setScaleX(scale);
        imageView.setScaleY(scale2);


        double opacity = 0.3 + (random.nextDouble() * 0.7);
        imageView.setOpacity(opacity);


        double rotation = random.nextInt(361);
        imageView.setRotate(rotation);
    }

    @FXML
    private void close() {
        Platform.exit();
    }
}