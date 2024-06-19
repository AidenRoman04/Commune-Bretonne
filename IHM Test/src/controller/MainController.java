package controller;

import java.io.IOException;

/**
 * Sample Skeleton for 'main.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import javafx.scene.Node; // Import the Node class from the javafx.scene package

public class MainController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Label targetLabel;

    @FXML // bouton pour aller a la page explorer
    void explorer(ActionEvent event) throws IOException {
        // Code to navigate to the explorer page
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/path/to/explorer.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML // bouton pour aller au text about
    void about(ActionEvent event) {
        // Calculer la position de l'élément cible
        double targetY = targetLabel.getBoundsInParent().getMinY();

        // Faire défiler le ScrollPane vers la position cible
        scrollPane.setVvalue(targetY / scrollPane.getContent().getBoundsInLocal().getHeight());
    }

    @FXML // bouton pour aller a la page visualiser
    void visualiser(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ressource/visualise.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML // bouton pour aller a la page comparer
    void comparer(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ressource/compare.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
