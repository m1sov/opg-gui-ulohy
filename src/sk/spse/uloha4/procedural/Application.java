package sk.spse.uloha4.procedural;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

///
/// Trieda pre procedurálne vytvorené GUI
///
/// Upravujte túto triedu
///

public class Application extends javafx.application.Application {

    private int counter = 0;

    @Override
    public void start(Stage stage) {
        Label label = new Label("Počítadlo:");

        TextField textField = new TextField("0");

        Button button = new Button("Plus 1");

        button.setOnAction(e -> {
            counter++;
            textField.setText(String.valueOf(counter));
        });

        HBox root = new HBox(20, label, textField, button);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root);

        stage.setTitle("Procedural Application 4");
        stage.setScene(scene);
        stage.show();
    }
}