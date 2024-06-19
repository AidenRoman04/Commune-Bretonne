package model.data;

import java.util.ArrayList;

/**
 * This class represents a department
 */
public class Department {

    private int depID;
    private String depName;
    private double cultInvest2019;
    private ArrayList<Airport> airportList;

    /**
     * Department constructor
     * 
     * @param depID          depID
     * @param depName        name of the department
     * @param cultInvest2019 2019 cultural invest
     * @param airportList    airport list
     */
    public Department(int depID, String depName, double cultInvest2019, ArrayList<Airport> airportList) {
        if ((depID < 0) || (cultInvest2019 < 0) || (depName == null || depName.isEmpty()) || (airportList == null)) {
            throw new IllegalArgumentException("Department ID cannot be negative");
        } else {
            this.depID = depID;
            this.depName = depName;
            this.cultInvest2019 = cultInvest2019;
            this.airportList = airportList;
        }
    }

    public int getDepID() {
        return this.depID;
    }

    public void setDepID(int depID) {
        if (depID < 0) {
            throw new IllegalArgumentException("Department ID cannot be negative");
        } else {
            this.depID = depID;
        }
    }

    public String getDepName() {
        return this.depName;
    }

    public void setDepName(String depName) {
        if (depName == null || depName.isEmpty()) {
            throw new IllegalArgumentException("Department name cannot be empty");
        } else {
            this.depName = depName;
        }
    }

    public double getCultInvest2019() {
        return this.cultInvest2019;
    }

    public void setCultInvest2019(double cultinvest2019) {
        if (cultinvest2019 < 0) {
            throw new IllegalArgumentException("Cultural investment cannot be negative");
        } else {
            this.cultInvest2019 = cultinvest2019;
        }
    }

    public ArrayList<Airport> getAirportList() {
        return this.airportList;
    }

    public void setAirportList(ArrayList<Airport> airports) {
        for (Airport a : airports) {
            this.airportList.add(a);
        }
    }

    public String toString() {
        String res = this.depName + " : ";
        res += "\ndepId = " + this.depID + ", ";
        res += "\ncultInvest = " + this.cultInvest2019 + ", ";
        res += "\nairportList : ";
        for (Airport a : this.airportList) {
            res += a.toString() + ",\n";
        }
        return res;
    }

    public String toStringApp() {
        String res = " ";
        res += "" + this.depName;
        return res;
    }

    public String toStringAppBudget() {
        String res = "";
        if (this.cultInvest2019 != -1.0) {
            res += "" + this.cultInvest2019 + ",\n";
        } else {
            res += "No cultural investment data available";
        }
        return res;
    }
}