package model.dao;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FileExport extends DAO{
    public void exportCities(File file){
        try(PrintWriter out = new PrintWriter(file))
        {
            Connection co = getConnection();
            PreparedStatement stmt = co.prepareStatement("SELECT * FROM Commune");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int cityID = rs.getInt("idCommune");
                String name = rs.getString("nomCommune");
                int depID = rs.getInt("leDepartement");
                out.write(cityID + ";" + name + ";" + depID);
                out.println();
            }
            out.close();
            co.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void exportNeighbours(File file){
        try(PrintWriter out = new PrintWriter(file))
        {
            Connection co = getConnection();
            PreparedStatement stmt = co.prepareStatement("SELECT * FROM Voisinage");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int cityID = rs.getInt("commune");
                int neighbour = rs.getInt("communeVoisine");
                out.write(cityID + ";" + neighbour);
                out.println();
            }
            out.close();
            co.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void exportAirports(File file){
        try(PrintWriter out = new PrintWriter(file))
        {
            Connection co = getConnection();
            PreparedStatement stmt = co.prepareStatement("SELECT * FROM Aeroport");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String name = rs.getString("nom");
                String adress = rs.getString("adresse");
                int dep = rs.getInt("leDepartement");
                out.write(name + ";" + adress + ";" + dep);
                out.println();
            }
            out.close();
            co.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void exportYears(File file){
        try(PrintWriter out = new PrintWriter(file))
        {
            Connection co = getConnection();
            PreparedStatement stmt = co.prepareStatement("SELECT * FROM Annee");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int year = rs.getInt("annee");
                double rate = rs.getDouble("tauxInflation");
                out.write(year + ";" + rate);
                out.println();
            }
            out.close();
            co.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void exportDepartments(File file){
        try(PrintWriter out = new PrintWriter(file))
        {
            Connection co = getConnection();
            PreparedStatement stmt = co.prepareStatement("SELECT * FROM Departement");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("idDep");
                String name = rs.getString("nomDep");
                int cultInvest = rs.getInt("investissementCulturel2019");
                out.write(id + ";" + name + ";" + cultInvest);
                out.println();
            }
            out.close();
            co.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void exportStations(File file){
        try(PrintWriter out = new PrintWriter(file))
        {
            Connection co = getConnection();
            PreparedStatement stmt = co.prepareStatement("SELECT * FROM Gare");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("codeGare");
                String name = rs.getString("nomGare");
                boolean isCargo = rs.getBoolean("estFret");
                boolean isTraveler = rs.getBoolean("estVoyageur");
                int city = rs.getInt("laCommune");
                out.write(id + ";" + name + ";" + isCargo + ";" + isTraveler + ";" + city);
                out.println();
            }
            out.close();
            co.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void exportData(File file){
        try(PrintWriter out = new PrintWriter(file))
        {
            Connection co = getConnection();
            PreparedStatement stmt = co.prepareStatement("SELECT * FROM DonneesAnnuelles");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int year = rs.getInt("lAnnee");
                int city = rs.getInt("laCommune");
                int houseNumber = rs.getInt("nbMaison");
                int flatNumber = rs.getInt("nbAppart");
                float averagePrice = rs.getFloat("prixMoyen");
                float averageM2Price = rs.getFloat("prixM2Moyen");
                float averageSurface = rs.getFloat("SurfaceMoy");
                float totalCulturalSpending = rs.getFloat("depensesCulturellesTotales");
                float totalBudget = rs.getFloat("budgetTotal");
                float population = rs.getFloat("population");
                out.write(year + ";" + city + ";" + houseNumber + ";" + flatNumber + ";" + averagePrice + ";" + averageM2Price + ";" + averageSurface + ";" + totalCulturalSpending + ";" + totalBudget + ";" + population);
                out.println();
            }
            out.close();
            co.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
