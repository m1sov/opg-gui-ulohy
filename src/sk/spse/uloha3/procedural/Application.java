package sk.spse.uloha3.procedural;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;  // **Tento import pridaj**
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.animation.RotateTransition;
import javafx.util.Duration;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.net.URI;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        root.setPrefSize(1100, 650);

        // Título
        Label title = new Label("Stredná priemyselná škola elektrotechnická, Prešov");
        title.setStyle("-fx-font-size: 38px;");
        BorderPane.setAlignment(title, Pos.CENTER);
        BorderPane.setMargin(title, new Insets(20));
        root.setTop(title);

        // Logo
        ImageView logo = new ImageView();
        logo.setFitWidth(320);
        logo.setFitHeight(320);
        logo.setPreserveRatio(true);
        logo.setSmooth(true);
        Image img = new Image(getClass().getResourceAsStream("spse.png"));
        logo.setImage(img);
        BorderPane.setAlignment(logo, Pos.CENTER);
        BorderPane.setMargin(logo, new Insets(20));
        root.setLeft(logo);

        // TextArea a Hyperlink
        TextArea ta = new TextArea(
                "Vážení rodičia a milí žiaci základných škôl,\n\n" +
                        "radi by sme Vás privítali v priestoroch našej školy dňa 10. 02. 2026 (utorok) " +
                        "od 13.00 do 17.00 h na Dni otvorených dverí, kde by sme Vám chceli " +
                        "predstaviť naše študijné odbory."
        );
        ta.setWrapText(true);
        ta.setEditable(false);
        ta.setPrefSize(680, 260);
        ta.setStyle("-fx-font-size: 22px;");

        Hyperlink link = new Hyperlink("https://www.spse-po.sk");
        link.setStyle("-fx-font-size: 22px;");
        link.setOnAction(e -> {
            try {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().browse(new URI(link.getText()));
                }
            } catch (Exception ignored) {}
        });

        VBox center = new VBox(18, ta, link);
        center.setAlignment(Pos.TOP_LEFT);
        center.setPadding(new Insets(20, 30, 20, 30));
        root.setCenter(center);

        // Slider pre otáčanie loga
        Slider slider = new Slider(0, 360, 0);  // Od 0 do 360, počiatočná hodnota 0
        slider.setBlockIncrement(10);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(90);
        slider.setMinorTickCount(9);
        slider.setStyle("-fx-font-size: 22px;");

        slider.valueProperty().addListener((observable, oldValue, newValue) -> rotateLogo(logo, newValue.doubleValue()));

        // Tlačidlo "Beriem na vedomie"
        Button btn = new Button("Beriem na vedomie");
        btn.setStyle("-fx-font-size: 22px;");
        btn.setOnAction(e -> Platform.exit());

        // HBox na spodnú časť
        HBox bottom = new HBox(btn);
        bottom.setAlignment(Pos.CENTER_RIGHT);
        bottom.setPadding(new Insets(20));
        root.setBottom(bottom);

        // Nastavenie scény
        VBox vbox = new VBox(20, slider, root);  // Pridáme Slider na vrch
        Scene scene = new Scene(vbox);
        stage.setTitle("Procedural Application 3");
        stage.setScene(scene);
        stage.show();
    }

    // Metóda na otáčanie loga
    private void rotateLogo(ImageView logo, double angle) {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(0.1), logo);  // 0.1 sekundy pre rýchle otáčanie
        rotateTransition.setByAngle(angle - logo.getRotate());  // Rozdiel medzi aktuálnym a novým uhlom
        rotateTransition.setCycleCount(1);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}