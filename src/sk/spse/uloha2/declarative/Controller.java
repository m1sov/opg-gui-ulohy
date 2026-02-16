package sk.spse.uloha2.declarative;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    @FXML private TextField tfMeno;
    @FXML private TextField tfEmail;

    @FXML private RadioButton rbMuz;
    @FXML private RadioButton rbZena;
    @FXML private RadioButton rbIne;

    private final ToggleGroup pohlavieGroup = new ToggleGroup();

    @FXML
    private void initialize() {
        // ak by sa náhodou načítal iný FXML, nech je chyba hneď jasná
        if (rbMuz == null || rbZena == null || rbIne == null) {
            throw new IllegalStateException("Chýbajú fx:id rbMuz/rbZena/rbIne v primary.fxml (kontroluj, že beží správny FXML).");
        }

        rbMuz.setToggleGroup(pohlavieGroup);
        rbZena.setToggleGroup(pohlavieGroup);
        rbIne.setToggleGroup(pohlavieGroup);

        rbMuz.setSelected(true);
    }

    @FXML
    private void onClose() {
        Platform.exit();
    }

    @FXML
    private void onRegister() {
        String meno = tfMeno.getText().trim();
        String email = tfEmail.getText().trim();

        String pohlavie = "";
        if (pohlavieGroup.getSelectedToggle() != null) {
            pohlavie = ((RadioButton) pohlavieGroup.getSelectedToggle()).getText();
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Uloha 14.2 – Registrácia");
        alert.setHeaderText("Zadané údaje");
        alert.setContentText(
                "Meno: " + meno + "\n" +
                        "Email: " + email + "\n" +
                        "Pohlavie: " + pohlavie
        );
        alert.showAndWait();
    }
}
