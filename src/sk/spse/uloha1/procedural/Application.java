package sk.spse.uloha1.procedural;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) {
        TextField tfCelsius = new TextField();
        tfCelsius.setPromptText("Zadaj °C");

        TextField tfFahrenheit = new TextField();
        tfFahrenheit.setPromptText("Zadaj °F");

        // OnKeyTyped: pri písaní prepočítaj do druhého poľa
        tfCelsius.setOnKeyTyped(e -> onCelsiusKeyTyped(e, tfCelsius, tfFahrenheit));
        tfFahrenheit.setOnKeyTyped(e -> onFahrenheitKeyTyped(e, tfFahrenheit, tfCelsius));

        HBox rowC = new HBox(10,
                new Label("Celsius:") {{ setMinWidth(90); }},
                tfCelsius,
                new Label("°C") {{ setMinWidth(30); }}
        );
        HBox.setHgrow(tfCelsius, Priority.ALWAYS);

        HBox rowF = new HBox(10,
                new Label("Fahrenheit:") {{ setMinWidth(90); }},
                tfFahrenheit,
                new Label("°F") {{ setMinWidth(30); }}
        );
        HBox.setHgrow(tfFahrenheit, Priority.ALWAYS);

        VBox root = new VBox(12, rowC, rowF);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 420, 140);
        stage.setTitle("Procedural Application 1");
        stage.setScene(scene);
        stage.show();
    }

    private static void onCelsiusKeyTyped(KeyEvent e, TextField tfC, TextField tfF) {
        String text = normalize(tfC.getText());

        if (text.isBlank() || text.equals("-") || text.equals(".")) {
            tfF.clear();
            return;
        }

        try {
            double c = Double.parseDouble(text);
            double f = c * 9.0 / 5.0 + 32.0;
            tfF.setText(format(f));
        } catch (NumberFormatException ex) {
            tfF.clear();
        }
    }

    private static void onFahrenheitKeyTyped(KeyEvent e, TextField tfF, TextField tfC) {
        String text = normalize(tfF.getText());

        if (text.isBlank() || text.equals("-") || text.equals(".")) {
            tfC.clear();
            return;
        }

        try {
            double f = Double.parseDouble(text);
            double c = (f - 32.0) * 5.0 / 9.0;
            tfC.setText(format(c));
        } catch (NumberFormatException ex) {
            tfC.clear();
        }
    }

    private static String normalize(String s) {
        // aby fungovala aj desatinná čiarka
        return s == null ? "" : s.trim().replace(',', '.');
    }

    private static String format(double v) {
        // zaokrúhlenie na 2 desatinné miesta, bez zbytočných núl
        double rounded = Math.round(v * 100.0) / 100.0;
        if (rounded == (long) rounded) return Long.toString((long) rounded);
        return Double.toString(rounded);
    }
}
