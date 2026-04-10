package sk.spse.uloha3.declarative;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.control.Slider;
import javafx.animation.RotateTransition;
import javafx.util.Duration;
import java.awt.Desktop;
import java.net.URI;

public class Controller {

    @FXML
    private ImageView logoImageView;  // Odkaz na logo ImageView

    @FXML
    private Slider slider;  // Odkaz na Slider

    // Inicializácia metódy
    @FXML
    public void initialize() {
        // Poslucháč na zmenu hodnoty Slidera
        slider.valueProperty().addListener((observable, oldValue, newValue) -> rotateLogo(newValue.doubleValue()));
    }

    // Metóda na otáčanie loga
    private void rotateLogo(double angle) {
        // Vytvorenie animácie otáčania
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(0.1), logoImageView);
        rotateTransition.setByAngle(angle - logoImageView.getRotate()); // Získame rozdiel od aktuálnej hodnoty
        rotateTransition.setCycleCount(1);
        rotateTransition.setAutoReverse(false);

        // Spustenie animácie
        rotateTransition.play();
    }

    // Metóda pre otvorenie odkazu
    @FXML
    public void openLink() {
        try {
            // Otvorenie odkazu v predvoleného webovom prehliadači
            URI uri = new URI("https://www.spse-po.sk");
            Desktop.getDesktop().browse(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Ďalšia metóda pre akciu "Beriem na vedomie"
    @FXML
    public void exitApp() {
        System.exit(0);  // Zatvorenie aplikácie
    }
}