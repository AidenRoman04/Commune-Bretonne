package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.dao.DatabaseDAO;
import model.data.City;
import model.data.Database;

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

    @FXML
    private Label infoCity1; // Value injected by FXMLLoader

    @FXML
    private Label infoCity2; // Value injected by FXMLLoader

    @FXML
    private Label infoCity3; // Value injected by FXMLLoader

    @FXML
    private Label budgetCity1; // Value injected by FXMLLoader

    @FXML
    private Label budgetCity2; // Value injected by FXMLLoader

    @FXML
    private Label budgetCity3; // Value injected by FXMLLoader

    @FXML
    private Button compare; // Value injected by FXMLLoader

    @FXML
    private HBox hboxInfo;

    @FXML
    private HBox hboxBudget;

    private ArrayList<String> cityList = new ArrayList<>();
    private ObservableList<String> observableCityList = FXCollections.observableArrayList();

    private DatabaseDAO dbDAO = new DatabaseDAO();
    private Database database;

    private ArrayList<City> cities;

    @FXML
    void launchResearchData(ActionEvent event) {
        // le code doit récupérer les données de la ville dans les ComboBox et grâce au
        // DAO afficher les informations générales de la ville (nom, population,
        // superficie, etc.)
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        setupEventHandlers();
        initializeDataBase();
        setCityList();
        initializeComboBox(city1);
        initializeComboBox(city2);
        initializeComboBox(city3);

        // Ajouter du padding aux labels
        infoCity1.setStyle("-fx-padding: 5px 0 0 0;");
        infoCity2.setStyle("-fx-padding: 5px 0 0 0;");
        infoCity3.setStyle("-fx-padding: 5px 0 0 0;");

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

        compare.onMouseClickedProperty().set(event -> {
            getInfoCity();
        });
    }

    /**
     * remplit la liste des villes dans les ComboBox depuis une arrayList
     */
    public void fillCityList(ArrayList<String> cityList) {
        this.city1.getItems().add("N/A");
        this.city2.getItems().add("N/A");
        this.city3.getItems().add("N/A");
        for (String city : cityList) {
            this.city1.getItems().add(city);
            this.city2.getItems().add(city);
            this.city3.getItems().add(city);
        }
        this.city1.setValue("N/A");
        this.city2.setValue("N/A");
        this.city3.setValue("N/A");
    }

    public void setCityList() {
        this.cities = database.getCities();
        for (City city : cities) {
            this.cityList.add(city.getCityName());
        }
        this.observableCityList.addAll(cityList);
        fillCityList(cityList);
    }

    public void initializeDataBase() {

        System.out.println("Starting database initialization");
        database = dbDAO.getDatabase();
        System.out.println("Database initialized");

    }

    private void initializeComboBox(ComboBox<String> comboBox) {
        FilteredList<String> filteredItems = new FilteredList<>(observableCityList, p -> true);

        comboBox.setItems(filteredItems);
        comboBox.setEditable(true);
        comboBox.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
            final TextField editor = comboBox.getEditor();
            final String selected = comboBox.getSelectionModel().getSelectedItem();

            // Si l'élément sélectionné n'est pas égal au texte saisi, appliquez le filtre
            if (selected == null || !selected.equals(editor.getText())) {
                filteredItems.setPredicate(item -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    return item.toLowerCase().startsWith(lowerCaseFilter);
                });
            }
        });

        comboBox.setOnAction(event -> {
            if (comboBox.getSelectionModel().getSelectedItem() != null) {
                comboBox.getEditor().setText(comboBox.getSelectionModel().getSelectedItem());
            }
        });
    }

    public void getInfoCity() {
        getInfoCity1();
        getInfoCity2();
        getInfoCity3();
    }

    public void getInfoCity1() {
        String text = "City not found"; // Initialisation avec "City not found"
        String budget = "Budget not found"; // Initialisation avec "City not found
        infoCity1.setText("");
        if (city1.getValue() != null) {
            for (City city : this.cities) {
                city1.setVisible(true);
                if (city.getCityName().equals(city1.getValue())) {
                    text = city.toStringApp();
                    budget = city.toStringAppBudget();
                }
            }
            infoCity1.setText(text); // Définir le texte après la boucle
            budgetCity1.setText(budget);
        }
    }

    public void getInfoCity2() {
        try {
            String text = "City not found"; // Initialisation avec "City not found"
            String budget = "Budget not found"; // Initialisation avec "City not found
            infoCity2.setText("");
            if (city2.getValue() != null) {
                for (City city : this.cities) {
                    city2.setVisible(true);
                    if (city.getCityName().equals(city2.getValue())) {
                        text = city.toStringApp();
                        budget = city.toStringAppBudget();
                    }
                }
                infoCity2.setText(text); // Définir le texte après la boucle
                budgetCity2.setText(budget);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getInfoCity3() {
        String text = "City not found"; // Initialisation avec "City not found"
        String budget = "Budget not found"; // Initialisation avec "City not found
        infoCity3.setText("");
        if (city3.getValue() != null) {
            for (City city : this.cities) {
                city3.setVisible(true);
                if (city.getCityName().equals(city3.getValue())) {
                    text = city.toStringApp();
                    budget = city.toStringAppBudget();
                }
            }
            infoCity3.setText(text); // Définir le texte après la boucle
            budgetCity3.setText(budget);
        }
    }

}
