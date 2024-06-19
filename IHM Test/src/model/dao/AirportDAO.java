package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.data.Airport;

/**
 * This class creates Airport objects and Airport arrays using the database
 */
public class AirportDAO extends DAO<Airport> {
    /**
     * Returns all the airports from the database
     * 
     * @return an array of airports
     */
    public ArrayList<Airport> getAllAirports() {
        ArrayList<Airport> res = new ArrayList<Airport>();
        System.out.println("AirportDAO.getAllAirports()");
        try {
            Connection co = getConnection();
            PreparedStatement stmt = co.prepareStatement("SELECT * FROM Aeroport");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("nom");
                String adress = rs.getString("adresse");
                int theDep = rs.getInt("leDepartement");
                res.add(new Airport(name, adress, theDep));
            }
            co.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
    }

    /**
     * Returns all the airports from a given department
     * 
     * @param theDep the department's id
     * @return the array of airports
     */
    public ArrayList<Airport> returnAllFromDep(int theDep) {
        ArrayList<Airport> res = new ArrayList<Airport>();
        try {
            Connection co = getConnection();
            PreparedStatement stmt = co.prepareStatement("SELECT * FROM Aeroport WHERE leDepartement=" + theDep);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("nom");
                String adress = rs.getString("adresse");
                res.add(new Airport(name, adress, theDep));
            }
            co.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
    }

    /**
     * Deletes the given airport from the database
     * 
     * @param airport the airport you wan't to delete
     */
    public void deleteAirport(Airport airport) {
        if (airport != null) {
            try {
                Connection co = getConnection();
                PreparedStatement stmt = co.prepareStatement("DELETE FROM Aeroport WHERE nom=" + airport.getName());
                stmt.executeUpdate();
                co.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Adds the given airport to the database
     * 
     * @param airport the airport
     */
    public void insertAirport(Airport airport) {
        if (airport != null) {
            try {
                Connection co = getConnection();
                String name = airport.getName();
                String adress = airport.getAdress();
                int dep = airport.getDepartment();
                PreparedStatement stmt = co
                        .prepareStatement("INSERT INTO Aeroport VALUES (" + name + ", " + adress + ", " + dep + ")");
                stmt.executeUpdate();
                co.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Updates the given airport of the database to a new airport
     * 
     * @param theAirport the airport you wan't to update
     * @param newAirport the new airport
     */
    public void updateAirport(Airport theAirport, Airport newAirport) {
        if ((newAirport != null) && (theAirport != null)) {
            try {
                Connection co = getConnection();
                String name = newAirport.getName();
                String adress = newAirport.getAdress();
                int dep = newAirport.getDepartment();
                PreparedStatement stmt = co.prepareStatement("UPDATE Aeroport SET nom=" + name + " , adresse=" + adress
                        + " , leDepartement=" + dep + " WHERE nom=" + theAirport.getName());
                stmt.executeUpdate();
                co.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
