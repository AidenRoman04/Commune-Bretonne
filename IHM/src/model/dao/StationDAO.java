package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.data.Station;

/**
 * This class creates Station objects and Station arrays using the database
 */
public class StationDAO extends DAO<Station> {
    /**
     * Returns all the stations of a given city
     * 
     * @param cityID the city
     * @return the stations array
     */
    public ArrayList<Station> getStationsFromCity(int cityID) {
        ArrayList<Station> res = new ArrayList<>();
        try {
            Connection co = getConnection();
            PreparedStatement stmt = co.prepareStatement("SELECT * FROM Gare WHERE laCommune=" + cityID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int code = rs.getInt("codeGare");
                String name = rs.getString("nomGare");
                boolean isCargo = rs.getBoolean("estFret");
                boolean isTraveler = rs.getBoolean("estVoyageur");
                res.add(new Station(cityID, code, name, isCargo, isTraveler));
            }
            co.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
    }

    /**
     * Returns all the stations from the database
     * 
     * @return the stations
     */
    public ArrayList<Station> getAllStations() {
        System.out.println("StationDAO.getAllStations()");
        ArrayList<Station> res = new ArrayList<>();
        try {
            Connection co = getConnection();
            PreparedStatement stmt = co.prepareStatement("SELECT * FROM Gare");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int cityID = rs.getInt("laCommune");
                int code = rs.getInt("codeGare");
                String name = rs.getString("nomGare");
                boolean isCargo = rs.getBoolean("estFret");
                boolean isTraveler = rs.getBoolean("estVoyageur");
                res.add(new Station(cityID, code, name, isCargo, isTraveler));
            }
            co.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
    }

    /**
     * Deletes the given station from the database
     * 
     * @param station the station
     */
    public void deleteStation(Station station) {
        if (station != null) {
            try {
                Connection co = getConnection();
                PreparedStatement stmt = co.prepareStatement("DELETE FROM Gare WHERE codeGare=" + station.getCode());
                stmt.executeUpdate();
                co.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Adds the given station to the database
     * 
     * @param station the station
     */
    public void insertStation(Station station) {
        if (station != null) {
            try {
                Connection co = getConnection();
                int code = station.getCode();
                String name = station.getName();
                boolean isCargo = station.isCargo();
                boolean isTraveler = station.isTraveler();
                int cityID = station.getCityID();
                PreparedStatement stmt = co.prepareStatement("INSERT INTO Gare VALUES (" + code + ", " + name + ", "
                        + isCargo + ", " + isTraveler + " , " + cityID + ")");
                stmt.executeUpdate();
                co.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Updates the given station to the new station
     * 
     * @param theStation the station you wan't to update
     * @param newStation the new station
     */
    public void updateStation(Station theStation, Station newStation) {
        if ((newStation != null) && (theStation != null)) {
            try {
                Connection co = getConnection();
                int code = newStation.getCode();
                String name = newStation.getName();
                boolean isCargo = newStation.isCargo();
                boolean isTraveler = newStation.isTraveler();
                int cityID = newStation.getCityID();
                PreparedStatement stmt = co.prepareStatement("UPDATE Gare SET codeGare=" + code + " , nomGare=" + name
                        + " , estFret=" + isCargo + " , estVoyageur=" + isTraveler + " , laCommune=" + cityID
                        + " WHERE codeGare=" + theStation.getCode());
                stmt.executeUpdate();
                co.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
