package model.dao;

import java.util.ArrayList;

import model.data.Airport;
import model.data.City;
import model.data.Data;
import model.data.Database;
import model.data.Department;
import model.data.Station;
import model.data.Year;

/**
 * This class initiliazes a Database object
 */
public class DatabaseDAO{
    /**
     * Returns initialized database
     * @return the database
     */
    public Database getDatabase(){
        CityDAO cityDAO = new CityDAO();
        DepartmentDAO departmentDAO = new DepartmentDAO();
        StationDAO stationDAO = new StationDAO();
        YearDAO yearDAO = new YearDAO();
        DataDAO dataDAO = new DataDAO();
        AirportDAO airportDAO = new AirportDAO();
        ArrayList<City> cities = cityDAO.getAllCities();
        ArrayList<Department> departments = departmentDAO.getAllDepartments();
        ArrayList<Station> stations = stationDAO.getAllStations();
        ArrayList<Year> years = yearDAO.getAllYears();
        ArrayList<Data> data = dataDAO.getAllData();
        ArrayList<Airport> airports = airportDAO.getAllAirports();
        return new Database(cities, departments, stations, years, data, airports);
    }
}
