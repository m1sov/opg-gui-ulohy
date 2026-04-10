package sk.spse.uloha2.declarative;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;


public class Controller {

    @FXML
    public TextField userNameField;
    public ToggleGroup pohlavieGroup;
    public PasswordField hesloField;

    @FXML
    private void registruj() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registrácia užívateľa");
        alert.setHeaderText("Registrácia prebehla úspešne");
        String pohlavie = ((RadioButton)pohlavieGroup.getSelectedToggle()).getText();
        String message = String.format("Užívateľ %s (%s) s heslom %s bol pridaný do systému",
                userNameField.getText(), pohlavie, hesloField.getText());
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void zatvor() {
        Platform.exit();
    }
}
