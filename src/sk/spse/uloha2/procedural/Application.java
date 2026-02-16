package sk.spse.uloha2.procedural;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) {
        TextField tfMeno = new TextField();
        TextField tfEmail = new TextField();

        ToggleGroup pohlavieGroup = new ToggleGroup();
        RadioButton rbMuz = new RadioButton("Muž");
        RadioButton rbZena = new RadioButton("Žena");
        RadioButton rbIne = new RadioButton("Iné");

        rbMuz.setToggleGroup(pohlavieGroup);
        rbZena.setToggleGroup(pohlavieGroup);
        rbIne.setToggleGroup(pohlavieGroup);
        rbMuz.setSelected(true);

        Button btnRegister = new Button("Registrovať");
        Button btnClose = new Button("Zavrieť");

        btnClose.setOnAction(e -> Platform.exit());

        btnRegister.setOnAction(e -> {
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
        });

        GridPane root = new GridPane();
        root.setHgap(12);
        root.setVgap(10);
        root.setPadding(new Insets(12));

        // 2 stĺpce, 5 riadkov (posledné 2 riadky majú columnSpan=2)
        root.add(new Label("Meno:"), 0, 0);
        root.add(tfMeno, 1, 0);

        root.add(new Label("Email:"), 0, 1);
        root.add(tfEmail, 1, 1);

        root.add(new Label("Pohlavie:"), 0, 2);
        HBox genderBox = new HBox(12, rbMuz, rbZena, rbIne);
        root.add(genderBox, 1, 2);

        HBox buttons = new HBox(12, btnRegister, btnClose);
        root.add(buttons, 0, 3);
        GridPane.setColumnSpan(buttons, 2);

        // 5. riadok necháme ako “spacing” (alebo sem môžeš dať info label)
        // napr. root.add(new Label(""), 0, 4);

        stage.setTitle("Procedural Application 2");
        stage.setScene(new Scene(root, 420, 200));
        stage.show();
    }
}
