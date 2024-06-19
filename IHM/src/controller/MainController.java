package controller;

import java.io.File;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.dao.FileExport;
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

    @FXML
    private Button exportButton;

    @FXML
    private ComboBox<String> exportBox;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert exportButton != null : "fx:id=\"exportButton\" was not injected: check your FXML file 'main.fxml'.";
        assert targetLabel != null : "fx:id=\"targetLabel\" was not injected: check your FXML file 'main.fxml'.";
        assert exportBox != null : "fx:id=\"exportBox\" was not injected: check your FXML file 'main.fxml'.";

        fillBox();
        setupEventHandlers();
    }

    @FXML // bouton pour aller a la page explorer
    void explorer(ActionEvent event) throws IOException {
        // Code to navigate to the explorer page
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/path/to/explorer.fxml"));// pas encore implémenter
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void setupEventHandlers() {
        exportButton.setOnAction(e -> exportCSV());
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

    @FXML // bouton pour aller a la page comparer
    void comparerGraphe(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ressource/Compare2.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void fillBox() {
        exportBox.getItems().addAll("aeroport", "annee", "commune", "departement", "donneesannuelles", "gare",
                "voisinage");
    }

    public void exportCSV() {
        FileExport fileExport = new FileExport();
        if (exportBox.getValue().equals("aeroport")) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Destination File");
            fileChooser.setInitialFileName("aeroport.csv");
            File selectedFile = fileChooser.showSaveDialog(null);
            if (selectedFile != null) {
                fileExport.exportAirports(selectedFile);
            }
        } else if (exportBox.getValue().equals("annee")) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Destination File");
            fileChooser.setInitialFileName("annee.csv");
            File selectedFile = fileChooser.showSaveDialog(null);
            if (selectedFile != null) {
                fileExport.exportYears(selectedFile);
            }
        } else if (exportBox.getValue().equals("commune")) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Destination File");
            fileChooser.setInitialFileName("commune.csv");
            File selectedFile = fileChooser.showSaveDialog(null);
            if (selectedFile != null) {
                fileExport.exportCities(selectedFile);
            }
        } else if (exportBox.getValue().equals("departement")) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Destination File");
            fileChooser.setInitialFileName("departement.csv");
            File selectedFile = fileChooser.showSaveDialog(null);
            if (selectedFile != null) {
                fileExport.exportDepartments(selectedFile);
            }
        } else if (exportBox.getValue().equals("donneesannuelles")) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Destination File");
            fileChooser.setInitialFileName("donneesannuelles.csv");
            File selectedFile = fileChooser.showSaveDialog(null);
            if (selectedFile != null) {
                fileExport.exportData(selectedFile);
            }
        } else if (exportBox.getValue().equals("gare")) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Destination File");
            fileChooser.setInitialFileName("gare.csv");
            File selectedFile = fileChooser.showSaveDialog(null);
            if (selectedFile != null) {
                fileExport.exportStations(selectedFile);
            }
        } else if (exportBox.getValue().equals("voisinage")) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Destination File");
            fileChooser.setInitialFileName("voisinage.csv");
            File selectedFile = fileChooser.showSaveDialog(null);
            if (selectedFile != null) {
                fileExport.exportCities(selectedFile);
            }
        } else {
            System.out.println("Invalid selection");
        }
    }
}
