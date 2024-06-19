/**
 * Sample Skeleton for 'visualise.fxml' Controller Class
 */

package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VisualiseController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="selectGraph"
    private ComboBox<?> selectGraph; // Value injected by FXMLLoader

    @FXML // fx:id="vBoxContainer"
    private VBox vBoxContainer; // Value injected by FXMLLoader

    @FXML // fx:id="flagHome"
    private ImageView flagHome; // Value injected by FXMLLoader

    @FXML // fx:id="buttonSelect"
    private Button buttonSelect; // Value injected by FXMLLoader

    @FXML // fx:id="citySearchField"
    private TextField citySearchField; // Value injected by FXMLLoader

    @FXML
    private ImageView graphimag;

    @FXML
    private ComboBox<String> comboGraph;

    @FXML
    void launchResearchData(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        setupEventHandlers();
        fillComboBox();

        assert buttonSelect != null : "fx:id=\"selectGraph\" was not injected: check your FXML file 'visualise.fxml'.";
        assert vBoxContainer != null
                : "fx:id=\"vBoxContainer\" was not injected: check your FXML file 'visualise.fxml'.";
        assert flagHome != null : "fx:id=\"flagHome\" was not injected: check your FXML file 'visualise.fxml'.";
        assert buttonSelect != null : "fx:id=\"buttonSelect\" was not injected: check your FXML file 'visualise.fxml'.";
        assert citySearchField != null
                : "fx:id=\"citySearchField\" was not injected: check your FXML file 'visualise.fxml'.";

    }

    private void setupEventHandlers() {
        buttonSelect.onMouseClickedProperty().set(event -> {
            try {
                selectGraphmet();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });

        flagHome.onMouseClickedProperty().set(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../ressource/main.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void fillComboBox() {
        comboGraph.getItems().addAll("nb Maison", "nb Appart", "Prix Moyen", "Prix M2 Moyen", "Surface Moyenne",
                "Depense Culturelle Totale", "Budget total", "population", "Distance a une garre");
    }

    public void selectGraphmet() throws FileNotFoundException {
        try {
            if (comboGraph.getValue().equals("nb Maison")) {
                FileInputStream inputStream = new FileInputStream("..\\src\\ressource\\data\\img\\n" + //
                        "bMais.png");
                Image image = new Image(inputStream);
                // Définition de l'image dans l'ImageView
                graphimag.setImage(image);
            } else if (comboGraph.getValue().equals("nb Appart")) {
                FileInputStream inputStream = new FileInputStream("..\\src\\ressource\\data\\img\\n" + //
                        "bApp.png");
                Image image = new Image(inputStream);
                graphimag.setImage(image);
            } else if (comboGraph.getValue().equals("Prix Moyen")) {
                FileInputStream inputStream = new FileInputStream("..\\src\\ressource\\data\\img\\PrixMoy.png");
                Image image = new Image(inputStream);
                graphimag.setImage(image);
            } else if (comboGraph.getValue().equals("Prix M2 Moyen")) {
                FileInputStream inputStream = new FileInputStream("..\\src\\ressource\\data\\img\\PrixM2Moy.png");
                Image image = new Image(inputStream);
                graphimag.setImage(image);
            } else if (comboGraph.getValue().equals("Surface Moyenne")) {
                FileInputStream inputStream = new FileInputStream("..\\src\\ressource\\data\\img\\SurfMoy.png");
                Image image = new Image(inputStream);
                graphimag.setImage(image);
            } else if (comboGraph.getValue().equals("Depense Culturelle Totale")) {
                FileInputStream inputStream = new FileInputStream("..\\src\\ressource\\data\\img\\DepenseCult.png");
                Image image = new Image(inputStream);
                graphimag.setImage(image);
            } else if (comboGraph.getValue().equals("Budget total")) {
                FileInputStream inputStream = new FileInputStream("..\\src\\ressource\\data\\img\\BudgTot.png");
                Image image = new Image(inputStream);
                graphimag.setImage(image);
            } else if (comboGraph.getValue().equals("population")) {
                FileInputStream inputStream = new FileInputStream("..\\src\\ressource\\data\\img\\pop.png");
                Image image = new Image(inputStream);
                graphimag.setImage(image);
            } else if (comboGraph.getValue().equals("Distance a une garre")) {
                FileInputStream inputStream = new FileInputStream("..\\src\\ressource\\data\\img\\DistanceG.png");
                Image image = new Image(inputStream);
                graphimag.setImage(image);
            } else {
                System.out.println("Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
