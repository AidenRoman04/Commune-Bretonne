package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.data.Data;
import model.data.Year;

/**
 * This class creates Data objects and Data arrays using the database
 */
public class DataDAO extends DAO {
    /**
     * Returns all the data from a given city
     * 
     * @param cityID the city
     * @return an array of data
     */
    public ArrayList<Data> getDataFromCity(int cityID) {
        ArrayList<Data> res = new ArrayList<>();
        try {
            Connection co = getConnection();
            PreparedStatement stmt = co.prepareStatement("SELECT * FROM DonneesAnnuelles WHERE laCommune=" + cityID);
            ResultSet rs = stmt.executeQuery();
            YearDAO yearDAO = new YearDAO();
            while (rs.next()) {
                Year theYear = yearDAO.getYear(rs.getInt("lAnnee"));
                int houseNumber = rs.getInt("nbMaison");
                int flatNumber = rs.getInt("nbAppart");
                float averagePrice = rs.getFloat("prixMoyen");
                float averageM2Price = rs.getFloat("prixM2Moyen");
                float averageSurface = rs.getFloat("SurfaceMoy");
                float totalCulturalSpending = rs.getFloat("depensesCulturellesTotales");
                float totalBudget = rs.getFloat("budgetTotal");
                float population = rs.getFloat("population");
                res.add(new Data(cityID, houseNumber, flatNumber, averagePrice, averageM2Price, averageSurface,
                        totalCulturalSpending, totalBudget, population, theYear));
            }
            co.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
    }

    /**
     * Returns all the data from the database
     * 
     * @return the data array
     */
    public ArrayList<Data> getAllData() {
        ArrayList<Data> res = new ArrayList<>();
        System.out.println("Initializing database Data : \t\t5 out of 6");
        try {
            Connection co = getConnection();
            PreparedStatement stmt = co.prepareStatement("SELECT * FROM DonneesAnnuelles");
            ResultSet rs = stmt.executeQuery();
            YearDAO yearDAO = new YearDAO();
            while (rs.next()) {
                int cityID = rs.getInt("laCommune");
                Year theYear = yearDAO.getYear(rs.getInt("lAnnee"));
                int houseNumber = rs.getInt("nbMaison");
                int flatNumber = rs.getInt("nbAppart");
                float averagePrice = rs.getFloat("prixMoyen");
                float averageM2Price = rs.getFloat("prixM2Moyen");
                float averageSurface = rs.getFloat("SurfaceMoy");
                float totalCulturalSpending = rs.getFloat("depensesCulturellesTotales");
                float totalBudget = rs.getFloat("budgetTotal");
                float population = rs.getFloat("population");
                res.add(new Data(cityID, houseNumber, flatNumber, averagePrice, averageM2Price, averageSurface,
                        totalCulturalSpending, totalBudget, population, theYear));
            }
            co.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
    }

    /**
     * Adds the given data to the database
     * 
     * @param data the data
     */
    public void deleteData(Data data) {
        if (data != null) {
            try {
                Connection co = getConnection();
                PreparedStatement stmt = co.prepareStatement("DELETE FROM DonneesAnnuelles WHERE lAnnee="
                        + data.getYear().getYear() + "AND laCommune=" + data.getCityID());
                stmt.executeUpdate();
                co.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Removes the given data from the database
     * 
     * @param data the data
     */
    public void insertData(Data data) {
        if (data != null) {
            try {
                Connection co = getConnection();
                int year = data.getYear().getYear();
                int cityID = data.getCityID();
                int houseNumber = data.getHouseNumber();
                int flatNumber = data.getFlatNumber();
                float averagePrice = data.getAveragePrice();
                float averageM2Price = data.getAverageM2Price();
                float averageSurface = data.getAverageSurface();
                float totalCulturalSpending = data.getTotalCulturalSpending();
                float totalBudget = data.getTotalBudget();
                float population = data.getPopulation();
                PreparedStatement stmt = co.prepareStatement("INSERT INTO DonneesAnnuelles VALUES (" + year + " , "
                        + cityID + " , " + houseNumber + " , " +
                        flatNumber + " , " + averagePrice + ", " + averageM2Price + ", " + averageSurface + ", " +
                        totalCulturalSpending + " , " + totalBudget + " , " + population + ")");
                stmt.executeUpdate();
                co.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Updates the given data to the new data
     * 
     * @param theData the data you wan't to update
     * @param newData the new data
     */
    public void updateData(Data theData, Data newData) {
        if ((newData != null) && (theData != null)) {
            try {
                Connection co = getConnection();
                int year = newData.getYear().getYear();
                int cityID = newData.getCityID();
                int houseNumber = newData.getHouseNumber();
                int flatNumber = newData.getFlatNumber();
                float averagePrice = newData.getAveragePrice();
                float averageM2Price = newData.getAverageM2Price();
                float averageSurface = newData.getAverageSurface();
                float totalCulturalSpending = newData.getTotalCulturalSpending();
                float totalBudget = newData.getTotalBudget();
                float population = newData.getPopulation();
                PreparedStatement stmt = co.prepareStatement("UPDATE DonneesAnnuelles SET lAnnee=" + year
                        + " , laCommune=" + cityID + " , nbMaison=" +
                        houseNumber + " , nbAppart=" + flatNumber + " , prixMoyen=" + averagePrice + " , prixM2Moyen" +
                        averageM2Price + " , SurfaceMoy=" + averageSurface + " , depensesCulturellesTotales=" +
                        totalCulturalSpending + " , budgetTotal=" + totalBudget + " , population=" + population +
                        " WHERE lAnnee=" + theData.getYear().getYear() + "AND laCommune=" + theData.getCityID());
                stmt.executeUpdate();
                co.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
