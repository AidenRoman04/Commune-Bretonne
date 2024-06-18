package model.data;

import java.util.ArrayList;

/**
 * This class represents a city
 */
public class City {

    private String cityCode;
    private String cityName;
    private Department department;
    private ArrayList<City> neighbourList;
    private ArrayList<Station> stations;
    private ArrayList<Data> data;

    /**
     * City constructor
     * 
     * @param cityCode      cityID
     * @param cityName      name of the city
     * @param department    department of the city
     * @param neighbourList neighbour list
     * @param stations      station list
     * @param data          data list
     */
    public City(String cityCode, String cityName, Department department, ArrayList<City> neighbourList,
            ArrayList<Station> stations, ArrayList<Data> data) {
        if (cityCode == null || cityCode.isEmpty() || cityName == null || cityName.isEmpty() || neighbourList == null
                || stations == null || data == null) {
            throw new IllegalArgumentException(
                    "City code, name, department, stations, data and neighbourList cannot be empty");
        } else {
            this.cityCode = cityCode;
            this.cityName = cityName;
            this.department = department;
            this.neighbourList = neighbourList;
            this.stations = stations;
            this.data = data;
        }
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public void setCityCode(String cityCode) {
        if (cityCode == null || cityCode.isEmpty()) {
            throw new IllegalArgumentException("City code cannot be empty");
        } else {
            this.cityCode = cityCode;
        }
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        if (cityName == null || cityName.isEmpty()) {
            throw new IllegalArgumentException("City name cannot be empty");
        } else {
            this.cityName = cityName;
        }
    }

    public String toString() {
        String res = "City Code: " + cityCode + ",\n City Name: " + cityName;
        res += ",\n Department : " + this.department.toString();
        res += ",\n Stations : ";
        if (this.stations.isEmpty()) {
            res += "No stations";
        } else {
            for (Station s : this.stations) {
                res += s.toString() + "\n";
            }
        }
        res += ",\n Data : ";
        for (Data d : this.data) {
            res += d.toString() + "\n";
        }
        return res;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("Department cannot be empty");
        } else {
            this.department = department;
        }
    }

    public ArrayList<City> getNeighborList() {
        return this.neighbourList;
    }

    public void setNeighborList(ArrayList<City> neighbours) {
        for (City c : neighbours) {
            this.neighbourList.add(c);
        }
    }

    public boolean isNeighbour(City otherCity) {
        if (otherCity == null) {
            throw new IllegalArgumentException("City cannot be empty");
        } else {
            return this.neighbourList.contains(otherCity);
        }
    }

    /**
     * print the city information for the app :
     * hab, km²,hab/km², dep and the airports/stations
     * 
     * @return
     */
    public String toStringApp() {
        String res = "";
        res += "City name : " + this.cityName + ",\n";
        res += "Department : " + this.department.toStringApp() + ",\n";
        for (Data d : this.data) {
            res += d.toStringDataApp();
        }

        return res;
    }

    public String toStringAppBudget() {
        String res = "";
        for (Data d : this.data) {
            res += d.toStringDataAppBudgetData();
        }
        res += "\nDepartment (2019) : " + this.department.toStringAppBudget() + ",\n";
        return res;
    }
}