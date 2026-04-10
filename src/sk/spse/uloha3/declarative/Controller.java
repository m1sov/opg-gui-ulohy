package sk.spse.uloha3.declarative;

import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import java.awt.Desktop;
import java.net.URI;

public class Controller {

    @FXML private ImageView logoImageView;

    private boolean logoEnlarged = false;

    private final double NORMAL_SCALE = 1.0;
    private final double ENLARGED_SCALE = 1.90;
    private final double NORMAL_ROTATION = 15.0;
    private final double STRAIGHT_ROTATION = 0.0;

    @FXML
    public void initialize() {
        logoImageView.setRotate(NORMAL_ROTATION);
    }

    @FXML
    public void onLogoEntered(MouseEvent event) {
        if (!logoEnlarged) {
            rotateTo(STRAIGHT_ROTATION, 250);
            scaleTo(1.08, 250);
        }
    }

    @FXML
    public void onLogoExited(MouseEvent event) {
        if (!logoEnlarged) {
            rotateTo(NORMAL_ROTATION, 250);
            scaleTo(NORMAL_SCALE, 250);
        }
    }

    @FXML
    public void onLogoClicked(MouseEvent event) {
        rotateTo(STRAIGHT_ROTATION, 300);
        scaleTo(ENLARGED_SCALE, 300);
        logoEnlarged = true;
        event.consume();
    }

    @FXML
    public void onBackgroundClicked(MouseEvent event) {
        if (logoEnlarged) {
            rotateTo(NORMAL_ROTATION, 350);
            scaleTo(NORMAL_SCALE, 350);
            logoEnlarged = false;
        }
    }

    private void rotateTo(double targetAngle, int duration) {
        RotateTransition rt = new RotateTransition(Duration.millis(duration), logoImageView);
        rt.setToAngle(targetAngle);
        rt.play();
    }

    private void scaleTo(double targetScale, int duration) {
        ScaleTransition st = new ScaleTransition(Duration.millis(duration), logoImageView);
        st.setToX(targetScale);
        st.setToY(targetScale);
        st.play();
    }

    @FXML
    public void openLink() {
        try {
            Desktop.getDesktop().browse(new URI("https://www.spse-po.sk"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleCloseButtonAction() {
        System.exit(0);
    }
}