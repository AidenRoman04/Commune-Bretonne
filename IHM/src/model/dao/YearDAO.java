package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.data.Year;

/**
 * This class creates Year objects and Year arrays using the database
 */
public class YearDAO extends DAO<Year> {
    /**
     * Returns the given year
     * 
     * @param theYear the year
     * @return the year
     */
    public Year getYear(int theYear) {
        Year res = null;
        try {
            Connection co = getConnection();
            PreparedStatement stmt = co.prepareStatement("SELECT * FROM Annee WHERE annee=" + theYear);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                float rate = rs.getFloat("tauxInflation");
                res = new Year(theYear, rate);
            }
            co.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
    }

    /**
     * Returns all the years from the database
     * 
     * @return the years
     */
    public ArrayList<Year> getAllYears() {
        System.out.println("YearDAO.getAllYears()");
        ArrayList<Year> res = new ArrayList<Year>();
        try {
            Connection co = getConnection();
            PreparedStatement stmt = co.prepareStatement("SELECT * FROM Annee");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int year = rs.getInt("annee");
                float rate = rs.getFloat("tauxInflation");
                res.add(new Year(year, rate));
            }
            co.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
    }

    /**
     * Deletes the given year from the database
     * 
     * @param year the year
     */
    public void deleteYear(Year year) {
        if (year != null) {
            try {
                Connection co = getConnection();
                PreparedStatement stmt = co.prepareStatement("DELETE FROM Annee WHERE annee=" + year.getYear());
                stmt.executeUpdate();
                co.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Adds the given year to the database
     * 
     * @param year the year
     */
    public void insertYear(Year year) {
        if (year != null) {
            try {
                Connection co = getConnection();
                PreparedStatement stmt = co.prepareStatement(
                        "INSERT INTO Annee VALUES (" + year.getYear() + "," + year.getInflationRate() + ")");
                stmt.executeUpdate();
                co.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Updates the given year to the new year
     * 
     * @param theYear the year you wan't to update
     * @param newYear the new year
     */
    public void updateYear(Year theYear, Year newYear) {
        if ((newYear != null) && (theYear != null)) {
            try {
                Connection co = getConnection();
                int year = newYear.getYear();
                double rate = newYear.getInflationRate();
                PreparedStatement stmt = co.prepareStatement("UPDATE Annee SET annee=" + year + ", tauxInflation="
                        + rate + " WHERE annee=" + theYear.getYear());
                stmt.executeUpdate();
                co.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
