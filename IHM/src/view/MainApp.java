package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Charger le fichier FXML
            Parent root = FXMLLoader.load(getClass().getResource("../ressource/main.fxml"));

            // Créer une nouvelle scène
            Scene scene = new Scene(root, 950, 500);

            // Configurer la scène et afficher la fenêtre principale
            primaryStage.setTitle("DataBreizh - Visualisation des données");

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Application.launch(MainApp.class, args);
    }

}
