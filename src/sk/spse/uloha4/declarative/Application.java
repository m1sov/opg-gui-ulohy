package sk.spse.uloha4.declarative;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("primary.fxml")
        );

        Scene scene = new Scene(loader.load(), 800, 400);

        stage.setTitle("Declarative Application 4");
        stage.setScene(scene);
        stage.show();
    }
}