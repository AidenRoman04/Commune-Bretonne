package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.dao.DatabaseDAO;
import model.dao.DataDAO;
import model.data.City;
import model.data.Data;
import model.data.Database;

public class Compare2Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> city1;

    @FXML
    private ComboBox<String> city2;

    @FXML
    private ComboBox<String> city3;

    @FXML
    private ComboBox<String> variableComboBox;

    @FXML
    private Button compare;

    @FXML
    private LineChart<String, Number> lineChart;

    private ArrayList<String> cityList = new ArrayList<>();
    private ObservableList<String> observableCityList = FXCollections.observableArrayList();

    private DatabaseDAO dbDAO = new DatabaseDAO();
    private DataDAO dataDAO = new DataDAO();
    private Database database;

    private ArrayList<City> cities;

    @FXML
    void initialize() {
        setupEventHandlers();
        initializeDataBase();
        setCityList();
        initializeComboBox(city1);
        initializeComboBox(city2);
        initializeComboBox(city3);
        initializeVariableComboBox();
    }

    private void setupEventHandlers() {
        compare.onMouseClickedProperty().set(event -> plotData());
    }

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

    private void initializeVariableComboBox() {
        ObservableList<String> variables = FXCollections.observableArrayList(
                "House Number", "Flat Number", "Average Price", "Average M2 Price", 
                "Average Surface", "Total Cultural Spending", "Total Budget", "Population");
        variableComboBox.setItems(variables);
        variableComboBox.setValue("Population");
    }

    private void plotData() {
        lineChart.getData().clear();
        String selectedVariable = variableComboBox.getValue();
        plotCityData(city1.getValue(), "City 1", selectedVariable);
        plotCityData(city2.getValue(), "City 2", selectedVariable);
        plotCityData(city3.getValue(), "City 3", selectedVariable);
    }

    private void plotCityData(String cityName, String seriesName, String variable) {
        if (cityName == null || cityName.equals("N/A")) {
            return;
        }

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName(seriesName);

        City city = getCityByName(cityName);
        if (city != null) {
            ArrayList<Data> dataList = dataDAO.getDataFromCity(Integer.parseInt(city.getCityCode()));
            for (Data data : dataList) {
                Number value = getVariableValue(data, variable);
                series.getData().add(new XYChart.Data<>(String.valueOf(data.getYear().getYear()), value));
            }
        }

        lineChart.getData().add(series);
    }

    private Number getVariableValue(Data data, String variable) {
        switch (variable) {
            case "House Number":
                return data.getHouseNumber();
            case "Flat Number":
                return data.getFlatNumber();
            case "Average Price":
                return data.getAveragePrice();
            case "Average M2 Price":
                return data.getAverageM2Price();
            case "Average Surface":
                return data.getAverageSurface();
            case "Total Cultural Spending":
                return data.getTotalCulturalSpending();
            case "Total Budget":
                return data.getTotalBudget();
            case "Population":
                return data.getPopulation();
            default:
                return 0;
        }
    }

    private City getCityByName(String cityName) {
        for (City city : cities) {
            if (city.getCityName().equals(cityName)) {
                return city;
            }
        }
        return null;
    }
}
