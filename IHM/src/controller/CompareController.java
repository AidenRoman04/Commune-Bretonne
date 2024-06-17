/**
 * Sample Skeleton for 'compare.fxml' Controller Class
 */

package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CompareController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="city1"
    private ComboBox<String> city1; // Value injected by FXMLLoader

    @FXML // fx:id="city2"
    private ComboBox<String> city2; // Value injected by FXMLLoader

    @FXML // fx:id="checkBoxPane"
    private Pane checkBoxPane; // Value injected by FXMLLoader

    @FXML // fx:id="vBoxContainer"
    private VBox vBoxContainer; // Value injected by FXMLLoader

    @FXML // fx:id="flagHome"
    private ImageView flagHome; // Value injected by FXMLLoader

    @FXML // fx:id="city3"
    private ComboBox<String> city3; // Value injected by FXMLLoader

    @FXML // fx:id="citySearchField"
    private TextField citySearchField; // Value injected by FXMLLoader

    private ArrayList<String> cityList = new ArrayList<String>();

    @FXML
    void launchResearchData(ActionEvent event) {
        // le code doit récuperrer les données de la ville dans les ComboBox et grace au
        // DAO afficher les informations generales de la ville (nom, population,
        // superficie, etc.)

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        setupEventHandlers();
        assert city1 != null : "fx:id=\"city1\" was not injected: check your FXML file 'compare.fxml'.";
        assert city2 != null : "fx:id=\"city2\" was not injected: check your FXML file 'compare.fxml'.";
        assert city3 != null : "fx:id=\"city3\" was not injected: check your FXML file 'compare.fxml'.";

        assert checkBoxPane != null : "fx:id=\"checkBoxPane\" was not injected: check your FXML file 'compare.fxml'.";
        assert vBoxContainer != null : "fx:id=\"vBoxContainer\" was not injected: check your FXML file 'compare.fxml'.";
        assert flagHome != null : "fx:id=\"flagHome\" was not injected: check your FXML file 'compare.fxml'.";
        assert citySearchField != null
                : "fx:id=\"citySearchField\" was not injected: check your FXML file 'compare.fxml'.";

    }

    private void setupEventHandlers() {
        // Add event handlers here
        flagHome.onMouseClickedProperty().set(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../ressource/main.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                // Gérez l'exception ici
                e.printStackTrace();
            }
        });
    }

    /**
     * remplit la liste des villes dans les ComboBox depuis une arrayList
     */
    public void fillCityList(ArrayList<String> cityList, ComboBox<String> city1, ComboBox<String> city2,
            ComboBox<String> city3) {
        city1.getItems().add("N/A");
        city2.getItems().add("N/A");
        city3.getItems().add("N/A");
        for (String city : cityList) {
            city1.getItems().add(city);
            city2.getItems().add(city);
            city3.getItems().add(city);
        }
        city1.setValue("N/A");
        city2.setValue("N/A");
        city3.setValue("N/A");
    }

    public void setCityList() {
        // call the methode of the DAO to get the list of cities
    }
}
