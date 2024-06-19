package controller;

import java.io.IOException;
import java.util.HashMap;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VisualiseController {

    /**
     * Variables pour compter le nombre de données et de villes
     */
    private int countData;

    /**
     * Variables pour compter le nombre de villes
     */
    private int countCity;

    /**
     * Contient les check box
     */
    @FXML
    private VBox vBoxContainer;

    /**
     * Contient les check box des villes
     */
    @FXML
    private Pane cityBlock;

    /**
     * Contient les check box des données
     */
    @FXML
    private Pane dataBlock;

    /**
     * Champ de recherche pour les données
     */
    @FXML
    private TextField dataSearchField;

    /**
     * Champ de recherche pour les villes
     */
    @FXML
    private TextField citySearchField;

    /**
     * Message d'erreur pour les villes
     */
    @FXML
    private Label cityError;

    /**
     * Message d'erreur pour les données
     */
    @FXML
    private Label dataError;

    /**
     * Drapeau pour revenir à la page d'accueil
     */
    @FXML
    private ImageView flagHome;

    /**
     * Label pour le développement admin
     */
    @FXML
    private Label adminLabel;

    /**
     * Bouton pour le développement admin
     */
    @FXML
    private Button adminButton;

    /**
     * HashMap pour stocker les données Data
     */
    private HashMap<Integer, String> data = new HashMap<Integer, String>();

    /**
     * HashMap pour stocker les données City
     */
    private HashMap<Integer, String> city = new HashMap<Integer, String>();

    /**
     * Méthode pour lancer la recherche d'une donnée :
     * 
     * Si le nombre de données est supérieur à 10, un message d'erreur est affiché
     * Si le champ de recherche est vide, un message d'erreur est affiché
     * Sinon, la donnée est ajoutée à la hashmap data et une checkbox est ajoutée à
     * la VBoxData
     * 
     * @see addCheckBoxToVBoxData
     */
    @FXML
    void launchResearchData() {
        if (countData >= 10) {
            dataError.setVisible(true); // Affiche le message d'erreur
            dataError.setText("Vous avez atteint le nombre maximum de Data à comparer (nb max = 10)");

        } else {
            if (!dataSearchField.getText().isEmpty()) {
                dataError.setVisible(false); // Cache le message d'erreur
                data.put(countData, dataSearchField.getText());
                addCheckBoxToVBoxData(dataSearchField.getText(), true); // Utilisez dataSearchField pour le nom de la
                                                                        // ville

                countData++;
            } else {
                dataError.setVisible(true); // Affiche le message d'erreur
                dataError.setText("Veuillez saisir une donnée valide et non vide");
            }

        }
    }

    /**
     * Méthode pour lancer la recherche d'une ville :
     * 
     * Si le nombre de villes est supérieur à 2, un message d'erreur est affiché
     * Si le champ de recherche est vide, un message d'erreur est affiché
     * Sinon, la ville est ajoutée à la hashmap city et une checkbox est ajoutée à
     * la VBoxCity
     * 
     * @see addCheckBoxToVBoxCity
     */
    @FXML
    void launchResearchCity() {
        if (countCity >= 2) {
            cityError.setVisible(true); // Affiche le message d'erreur
            cityError.setText("Vous avez atteint le nombre maximum de villes à comparer (nb max = 2)");
        } else {
            if (!citySearchField.getText().isEmpty()) {
                cityError.setVisible(false); // Cache le message d'erreur
                city.put(countCity, citySearchField.getText());
                addCheckBoxToVBoxCity(citySearchField.getText(), true); // Utilisez citySearchField pour le nom de la
                                                                        // ville

                countCity++;
            } else {
                cityError.setVisible(true); // Affiche le message d'erreur
                cityError.setText("Veuillez saisir une ville valide et non vide");
            }

        }
    }

    /**
     * Méthode d'initialisation
     */
    @FXML
    void initialize() {
        // Méthode d'initialisation
        setupEventHandlers();

        dataError.setVisible(false); // Cache le message d'erreur;
        cityError.setVisible(false); // Cache le message d'erreur

        assert dataSearchField != null
                : "fx:id=\"dataSearchField\" was not injected: check your FXML file 'visualise.fxml'.";
        assert dataError != null : "fx:id=\"dataError\" was not injected: check your FXML file 'visualise.fxml'.";
        assert cityBlock != null : "fx:id=\"cityBlock\" was not injected: check your FXML file 'visualise.fxml'.";
        assert vBoxContainer != null
                : "fx:id=\"vBoxContainer\" was not injected: check your FXML file 'visualise.fxml'.";
        assert dataBlock != null : "fx:id=\"dataBlock\" was not injected: check your FXML file 'visualise.fxml'.";
        assert cityError != null : "fx:id=\"cityError\" was not injected: check your FXML file 'visualise.fxml'.";
        assert citySearchField != null
                : "fx:id=\"citySearchField\" was not injected: check your FXML file 'visualise.fxml'.";
        assert flagHome != null : "fx:id=\"flagHome\" was not injected: check your FXML file 'visualise.fxml'.";
        assert adminLabel != null : "fx:id=\"adminLabel\" was not injected: check your FXML file 'visualise.fxml'.";
        assert adminButton != null : "fx:id=\"admiButton\" was not injected: check your FXML file 'visualise.fxml'.";

        countCity = 0;
        countData = 0;
    }

    /**
     * Méthode pour initialiser les gestionnaires d'événements
     * 
     * LaunchResearchCity : permet de lancer la recherche d'une ville
     * 
     * @see launchResearchCity
     * 
     *      LaunchResearchData : permet de lancer la recherche d'une donnée
     * @see launchResearchData
     */
    private void setupEventHandlers() {
        citySearchField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                launchResearchCity();
            }
        });

        dataSearchField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                launchResearchData();
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
                // Gérez l'exception ici
                e.printStackTrace();
            }
        });

        adminButton.onMouseClickedProperty().set(event -> {
            admin();
        });

    }

    /**
     * Méthode pour ajouter une checkbox à la VBoxCity
     * Attention : cette méthode gere aussi la suppression de la checkbox de façon
     * physique mais egallement dans la hashmap city
     * 
     * GetIndex : permet de récupérer l'index d'une ligne depuis son nom dans city
     * 
     * @see getIndexSinceCityMap
     * 
     * @param cityName
     * @param checked
     */
    private void addCheckBoxToVBoxCity(String cityName, boolean checked) {
        CheckBox checkBox = new CheckBox(cityName);
        checkBox.setSelected(checked); // Coche par défaut
        checkBox.setOnAction(event -> {
            if (!checkBox.isSelected()) {
                city.remove(getIndexSinceCityMap(checkBox.getText())); // Supprime de la Hashmap si décoché
                cityBlock.getChildren().remove(checkBox); // Supprime physiquement si décoché
                countCity--;
                if (countCity <= 2) {
                    cityError.setVisible(false); // Cache le message d'erreur
                }
            }
        });
        cityBlock.getChildren().add(checkBox); // Ajouter à Datablock au lieu de VBoxContainer
        citySearchField.clear(); // Efface le champ de recherche après ajout
    }

    /**
     * Méthode pour ajouter une checkbox à la VBoxData
     * Attention : cette méthode gere aussi la suppression de la checkbox de façon
     * physique mais egallement dans la hashmap data
     * 
     * GetIndex : permet de récupérer l'index d'une ligne depuis son nom dans data
     * 
     * @see getIndexSinceDataMap
     * 
     * @param dataName : nom de la donnée
     * @param checked  : état de la checkbox
     */
    private void addCheckBoxToVBoxData(String dataName, boolean checked) {
        CheckBox checkBox = new CheckBox(dataName);
        checkBox.setSelected(checked); // Coche par défaut
        checkBox.setOnAction(event -> {
            if (!checkBox.isSelected()) {
                data.remove(getIndexSinceDataMap(checkBox.getText())); // Supprime de la Hashmap si décoché
                dataBlock.getChildren().remove(checkBox); // Supprime physiquement si décoché
                countData--;
                if (countData <= 10) {
                    dataError.setVisible(false); // Cache le message d'erreur
                }
            }
        });
        dataBlock.getChildren().add(checkBox); // Ajouter à Datablock au lieu de VBoxContainer
        dataSearchField.clear(); // Efface le champ de recherche après ajout
    }

    /*
     * Méthode pour récupérer l'index d'une ligne depuis son nom dans data
     * 
     * Attention : cette méthode s'arrête à la première occurence trouvée
     */
    public Integer getIndexSinceDataMap(String dataName) {
        Integer index = null;

        for (Integer key : data.keySet()) {
            if (data.get(key).equals(dataName)) {
                index = key;
                break;
            }
        }

        return index;
    }

    /*
     * Méthode pour récupérer l'index d'une ligne depuis son nom dans city
     * 
     * Attention : cette méthode s'arrête à la première occurence trouvée
     */
    public Integer getIndexSinceCityMap(String cityName) {
        Integer Index = null;

        for (Integer name : city.keySet()) {
            if (city.get(name).equals(cityName)) {
                Index = name;
                break;
            }
        }

        return Index;
    }

    /**
     * Méthode pour afficher les villes du hashmap city
     */
    public String afficherCity() {
        String cityList = "";
        for (Integer key : city.keySet()) {
            cityList += "City : " + city.get(key) + "\n";
        }
        if (cityList.isEmpty()) {
            cityList = "No city to display";
        }
        return cityList;
    }

    /**
     * Méthode pour afficher les données du hashmap data
     */
    public String afficherData() {
        String dataList = "";
        for (Integer key : data.keySet()) {
            dataList += "Data : " + data.get(key) + "\n";
        }
        if (dataList.isEmpty()) {
            dataList = "No data to display";

        }
        return dataList;
    }

    /**
     * Méthode pour le devellopement admin
     * 
     * affichage, ajout, suppression de données
     */
    public void admin() {
        adminLabel.setText("" + getIndexSinceCityMap("Vannes") + "\n" + getIndexSinceDataMap("test") + "\n"
                + afficherCity() + "\n" + afficherData());

    }
}
