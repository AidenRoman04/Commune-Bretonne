package model.data;

import java.util.ArrayList;

/**
 * This class stores all the data from the database
 */
public class Database {
    private ArrayList<City> cities;
    private ArrayList<Department> departments;
    private ArrayList<Station> stations;
    private ArrayList<Year> years;
    private ArrayList<Data> data;
    private ArrayList<Airport> airports;

    /**
     * Database constructor
     * @param cities cities list
     * @param departments departments list
     * @param stations stations list
     * @param years years list
     * @param data data list
     * @param airports airports list
     */
    public Database(ArrayList<City> cities, ArrayList<Department> departments, ArrayList<Station> stations, ArrayList<Year> years,
                    ArrayList<Data> data, ArrayList<Airport> airports)
        {
            if((cities != null) && (departments != null) && (stations != null) && (years != null) && (data != null) && (airports != null)){
                this.cities = cities;
                this.departments = departments;
                this.stations = stations;
                this.years = years;
                this.data = data;
                this.airports = airports;
            }else{
                throw new IllegalArgumentException("Parameters cannot be null");
            }
    }
    public ArrayList<City> getCities(){
        return this.cities;
    }
    public void addCity(City city){
        if(city == null){
            throw new IllegalArgumentException("City cannot be null");
        }else{
            this.cities.add(city);
        }
    }
    public void removeCity(City city){
        if(city != null){
            this.cities.remove(city);
        }
    }
    public ArrayList<Department> getDepartments(){
        return this.departments;
    }
    public void addDepartment(Department dep){
        if(dep == null){
            throw new IllegalArgumentException("Department cannot be null");
        }else{
            this.departments.add(dep);
        }
    }
    public void removeDepartment(Department dep){
        if(dep != null){
            this.departments.remove(dep);
        }
    }
    public ArrayList<Station> getStations(){
        return this.stations;
    }
    public void addStation(Station station){
        if(station == null){
            throw new IllegalArgumentException("Station cannot be null");
        }else{
            this.stations.add(station);
        }
    }
    public void removeStation(Station station){
        if(station != null){
            this.stations.remove(station);
        }
    }
    public ArrayList<Year> getYears(){
        return this.years;
    }
    public void addYear(Year year){
        if(years == null){
            throw new IllegalArgumentException("Year cannot be null");
        }else{
            this.years.add(year);
        }
    }
    public void removeYear(Year year){
        if(year != null){
            this.years.remove(year);
        }
    }
    public ArrayList<Data> getData(){
        return this.data;
    }
    public void addData(Data data){
        if(data == null){
            throw new IllegalArgumentException("Data cannot be null");
        }else{
            this.data.add(data);
        }
    }
    public void removeCity(Data data){
        if(data != null){
            this.data.remove(data);
        }
    }
    public ArrayList<Airport> getAirports(){
        return this.airports;
    }
    public void addAirport(Airport airport){
        if(airport == null){
            throw new IllegalArgumentException("Airport cannot be null");
        }else{
            this.airports.add(airport);
        }
    }
    public void removeCity(Airport airport){
        if(airport != null){
            this.airports.remove(airport);
        }
    }
}
