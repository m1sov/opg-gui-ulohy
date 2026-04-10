package sk.spse.uloha1.declarative;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class Controller {

    @FXML
    private TextField tfCelsius;

    @FXML
    private TextField tfFahrenheit;

    @FXML
    private void onCelsiusKeyTyped(KeyEvent e) {
        String text = normalize(tfCelsius.getText());

        if (invalid(text)) {
            tfFahrenheit.clear();
            return;
        }

        try {
            double c = Double.parseDouble(text);
            double f = c * 9.0 / 5.0 + 32.0;
            tfFahrenheit.setText(format(f));
        } catch (NumberFormatException ex) {
            tfFahrenheit.clear();
        }
    }

    @FXML
    private void onFahrenheitKeyTyped(KeyEvent e) {
        String text = normalize(tfFahrenheit.getText());

        if (invalid(text)) {
            tfCelsius.clear();
            return;
        }

        try {
            double f = Double.parseDouble(text);
            double c = (f - 32.0) * 5.0 / 9.0;
            tfCelsius.setText(format(c));
        } catch (NumberFormatException ex) {
            tfCelsius.clear();
        }
    }

    private boolean invalid(String text) {
        return text.isBlank() || text.equals("-") || text.equals(".");
    }

    private static String normalize(String s) {
        return s == null ? "" : s.trim().replace(',', '.');
    }

    private static String format(double v) {
        double rounded = Math.round(v * 100.0) / 100.0;
        if (rounded == (long) rounded) return Long.toString((long) rounded);
        return Double.toString(rounded);
    }
}