package sk.spse.uloha4.procedural;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Random;

public class Application extends javafx.application.Application {

    VBox vbox1 = new VBox();
    VBox vbox2 = new VBox();
    VBox vbox3 = new VBox();
    VBox vbox4 = new VBox();

    Random random = new Random();

    @Override
    public void start(Stage stage) {

        BorderPane root = new BorderPane();

        TilePane tilePane = new TilePane();
        tilePane.setPrefColumns(4);

        Image image = new Image(getClass().getResource("soup2.png").toString());

        ImageView img1 = new ImageView(image);
        ImageView img2 = new ImageView(image);
        ImageView img3 = new ImageView(image);
        ImageView img4 = new ImageView(image);

        img1.setFitWidth(180);
        img2.setFitWidth(180);
        img3.setFitWidth(180);
        img4.setFitWidth(180);

        img1.setPreserveRatio(true);
        img2.setPreserveRatio(true);
        img3.setPreserveRatio(true);
        img4.setPreserveRatio(true);

        vbox1.setAlignment(Pos.CENTER);
        vbox2.setAlignment(Pos.CENTER);
        vbox3.setAlignment(Pos.CENTER);
        vbox4.setAlignment(Pos.CENTER);

        vbox1.getChildren().add(img1);
        vbox2.getChildren().add(img2);
        vbox3.getChildren().add(img3);
        vbox4.getChildren().add(img4);

        vbox1.setStyle("-fx-background-color: blue");
        vbox2.setStyle("-fx-background-color: yellow");
        vbox3.setStyle("-fx-background-color: green");
        vbox4.setStyle("-fx-background-color: red");

        tilePane.getChildren().addAll(vbox1, vbox2, vbox3, vbox4);

        root.setCenter(tilePane);

        Label quote = new Label(
                "\"In the future, everyone will be world-famous for 15 minutes\"\n- Andy Warhol"
        );

        Button randomize = new Button("Randomize");
        Button close = new Button("Close");

        randomize.setOnAction(e -> randomize());
        close.setOnAction(e -> Platform.exit());

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        HBox bottom = new HBox(15, quote, spacer, randomize, close);
        bottom.setStyle("-fx-background-color:#dddddd; -fx-padding:15;");

        root.setBottom(bottom);

        Scene scene = new Scene(root, 900, 400);

        stage.setTitle("Procedural Application 4");
        stage.setScene(scene);
        stage.show();
    }

    private void randomize() {
        vbox1.setStyle("-fx-background-color: " + getRandomColor());
        vbox2.setStyle("-fx-background-color: " + getRandomColor());
        vbox3.setStyle("-fx-background-color: " + getRandomColor());
        vbox4.setStyle("-fx-background-color: " + getRandomColor());
    }

    private String getRandomColor() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);

        return String.format("rgb(%d,%d,%d)", r, g, b);
    }
}