package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import model.data.City;
import model.data.Data;
import model.data.Department;
import model.data.Station;

/**
 * This class creates City objects and City arrays using the database
 */
public class CityDAO extends DAO {
    private DepartmentDAO departmentDAO = new DepartmentDAO();
    private StationDAO stationDAO = new StationDAO();
    private DataDAO dataDAO = new DataDAO();
    private HashMap<Integer, City> cityCache = new HashMap<Integer, City>();
    private HashMap<Integer, Department> depCache = new HashMap<Integer, Department>();

    /**
     * Returns all the cities of the database
     * 
     * @return an array of cities
     */
    public ArrayList<City> getAllCities() {
        ArrayList<City> res = new ArrayList<>();
        System.out.println("Initializing database City : \t\t1 out of 6");
        try {
            Connection co = getConnection();
            PreparedStatement stmt = co.prepareStatement("SELECT * FROM Commune");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int cityID = rs.getInt("idCommune");
                String cityName = rs.getString("nomCommune");
                int depID = rs.getInt("leDepartement");
                Department dep = null;
                if (this.depCache.containsKey(Integer.valueOf(depID))) {
                    dep = this.depCache.get(Integer.valueOf(depID));
                } else {
                    dep = this.departmentDAO.getDepartment(depID);
                }
                ArrayList<City> neighbours = getNeighboursList(cityID);
                ArrayList<Station> stations = this.stationDAO.getStationsFromCity(cityID);
                ArrayList<Data> data = this.dataDAO.getDataFromCity(cityID);
                City city = new City("" + cityID, cityName, dep, neighbours, stations, data);
                res.add(city);
                cityCache.put(Integer.valueOf(cityID), city);
            }
            co.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
    }

    /**
     * Returns an arrayList that contains all the neighbours of a given city
     * 
     * @param cityID the city
     * @return an arrayList of the neighbours
     */
    public ArrayList<City> getNeighboursList(int cityID) {
        ArrayList<City> res = new ArrayList<>();
        try {
            Connection co = getConnection();
            PreparedStatement stmt = co.prepareStatement("SELECT * FROM Voisinage WHERE Commune=" + cityID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                res.add(getCity(rs.getInt("CommuneVoisine"), false));
            }
            co.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
    }

    /**
     * Returns the given city from it's cityID
     * 
     * @param cityID        the cityID
     * @param getNeighbours a boolean that says if you wan't the neighbours list in
     *                      your City object
     * @return the city
     */
    public City getCity(int cityID, boolean getNeighbours) {
        City res = null;
        if (this.cityCache.containsKey(Integer.valueOf(cityID))) {
            res = this.cityCache.get(Integer.valueOf(cityID));
        } else {
            try {
                Connection co = getConnection();
                PreparedStatement stmt = co.prepareStatement("SELECT * FROM Commune WHERE idCommune=" + cityID);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String cityName = rs.getString("nomCommune");
                    Department dep = this.departmentDAO.getDepartment(rs.getInt("leDepartement"));
                    ArrayList<Station> stations = this.stationDAO.getStationsFromCity(cityID);
                    ArrayList<Data> data = this.dataDAO.getDataFromCity(cityID);
                    ArrayList<City> neighbours = new ArrayList<City>();
                    if (getNeighbours == true) {
                        neighbours = getNeighboursList(cityID);
                    }
                    res = new City("" + cityID, cityName, dep, neighbours, stations, data);
                    cityCache.put(Integer.valueOf(cityID), res);
                }
                co.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return res;
    }

    /**
     * Deletes the given city from the database
     * 
     * @param city the city to delete
     */
    public void deleteCity(City city) {
        if (city != null) {
            try {
                Connection co = getConnection();
                for (City c : city.getNeighborList()) {
                    PreparedStatement stmt1 = co.prepareStatement("DELETE FROM Voisinage WHERE commune="
                            + city.getCityCode() + " AND communeVoisine=" + c.getCityCode());
                    stmt1.executeUpdate();
                }
                PreparedStatement stmt2 = co
                        .prepareStatement("DELETE FROM Commune WHERE idCommune=" + city.getCityCode());
                stmt2.executeUpdate();
                co.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Adds the given city to the database
     * 
     * @param city the city
     */
    public void insertCity(City city) {
        if (city != null) {
            try {
                Connection co = getConnection();
                String code = city.getCityCode();
                String name = city.getCityName();
                int dep = city.getDepartment().getDepID();
                PreparedStatement stmt1 = co
                        .prepareStatement("INSERT INTO Commune VALUES (" + code + ", " + name + ", " + dep + ")");
                stmt1.executeUpdate();
                for (City c : city.getNeighborList()) {
                    PreparedStatement stmt2 = co
                            .prepareStatement("INSERT INTO Voisinage VALUES (" + code + " , " + c.getCityCode() + ")");
                    stmt2.executeUpdate();
                }
                co.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Updates the given city to the new city
     * 
     * @param theCity the city you wan't to update
     * @param newCity the new city
     */
    public void updateCity(City theCity, City newCity) {
        if ((newCity != null) && (theCity != null)) {
            try {
                Connection co = getConnection();
                String code = newCity.getCityCode();
                String name = newCity.getCityName();
                int dep = newCity.getDepartment().getDepID();
                PreparedStatement stmt1 = co.prepareStatement("UPDATE Commune SET idCommune=" + code + " , nomCommune="
                        + name + " , leDepartement=" + dep + " WHERE idCommune=" + theCity.getCityCode());
                stmt1.executeUpdate();
                for (City c : newCity.getNeighborList()) {
                    PreparedStatement stmt2 = co.prepareStatement("UPDATE Voisinage SET commune=" + code
                            + " , communeVoisine=" + c.getCityCode() + " WHERE commune=" + theCity.getCityCode());
                    stmt2.executeUpdate();
                }
                co.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
