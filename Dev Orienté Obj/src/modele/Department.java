package modele;

import java.util.ArrayList;

/**
 * Department class
 * Represents one of 4 departments in Britanny, France.
 * A department has an ID, a name, a cultural investment in 2019, and a list of
 * airports.
 * A department can have a list of airports (optional).
 * 
 * @version 1.0
 */
public class Department {

    private int depID;
    private String depName;
    private double cultInvest2019;
    private ArrayList<Airport> airportList;

    /**
     * Department constructor.
     * 
     * @param depID          The department ID.
     * @param depName        The department name.
     * @param cultInvest2019 The cultural investment in 2019.
     * @param airportList    The list of airports in the department.
     */
    public Department(int depID, String depName, double cultInvest2019, ArrayList<Airport> airportList) {
        if ((depID < 0) || (cultInvest2019 < 0) || (depName == null || depName.isEmpty()) || (airportList == null)) {
            throw new IllegalArgumentException("Error in department parameters");
        } else {
            this.depID = depID;
            this.depName = depName;
            this.cultInvest2019 = cultInvest2019;
            this.airportList = airportList;
        }
    }

    /**
     * Returns the department ID.
     * 
     * @return The department ID.
     */
    public int getDepID() {
        return this.depID;
    }

    /**
     * Sets the department ID.
     * 
     * @param depID The department ID.
     */
    public void setDepID(int depID) {
        if (depID < 0) {
            throw new IllegalArgumentException("Department ID cannot be negative");
        } else {
            this.depID = depID;
        }
    }

    /**
     * Returns the department name.
     * 
     * @return The department name.
     */
    public String getDepName() {
        return this.depName;
    }

    /**
     * Sets the department name.
     * 
     * @param depName The department name.
     */
    public void setDepName(String depName) {
        if (depName == null || depName.isEmpty()) {
            throw new IllegalArgumentException("Department name cannot be empty");
        } else {
            this.depName = depName;
        }
    }

    /**
     * Returns the cultural investment in 2019.
     * 
     * @return The cultural investment in 2019.
     */
    public double getCultInvest2019() {
        return this.cultInvest2019;
    }

    /**
     * Sets the cultural investment in 2019.
     * 
     * @param cultinvest2019 The cultural investment in 2019.
     */
    public void setCultInvest2019(double cultinvest2019) {
        if (cultinvest2019 < 0) {
            throw new IllegalArgumentException("Cultural investment cannot be negative");
        } else {
            this.cultInvest2019 = cultinvest2019;
        }
    }

    /**
     * Returns the list of airports in the department.
     * 
     * @return The list of airports in the department.
     */
    public ArrayList<Airport> getAirportList() {
        return this.airportList;
    }

    /**
     * Sets the list of airports in the department.
     * 
     * @param airports The list of airports in the department.
     */
    public void setAirportList(ArrayList<Airport> airports) {
        for (Airport a : airports) {
            this.airportList.add(a);
        }
    }

    /**
     * Adds an airport to the list of airports.
     * 
     * @param airport The airport to add.
     */
    public void addAirport(Airport airport) {
        if (airport == null) {
            throw new IllegalArgumentException("Airport cannot be null");
        } else {
            this.airportList.add(airport);
        }
    }

    /**
     * Removes an airport from the list of airports.
     * 
     * @param airport The airport to remove.
     */
    public void removeAirport(Airport airport) {
        if (airport == null) {
            throw new IllegalArgumentException("Airport cannot be null");
        } else {
            this.airportList.remove(airport);
        }
    }

    /**
     * Returns the number of airports in the department.
     * 
     * @return The number of airports in the department.
     */
    public int getNumberOfAirports() {
        return this.airportList.size();
    }

    public boolean hasAirport(Airport airport) {
        return this.airportList.contains(airport);
    }

    /**
     * print the department
     */
    public String toString() {
        String res = "";
        res += "Departement{ Department ID: " + this.depID + ", Department Name: " + this.depName
                + ", Cultural Investment in 2019: "
                + this.cultInvest2019 + ", Number of airports: " + this.getNumberOfAirports() + " }";
        return res;
    }
}