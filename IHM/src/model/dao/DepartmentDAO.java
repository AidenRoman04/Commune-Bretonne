package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.data.Airport;
import model.data.Department;

/**
 * This class creates Department objects and Department arrays using the
 * database
 */
public class DepartmentDAO extends DAO {
    /**
     * Returns the department from his id
     * 
     * @param depID the id
     * @return the department
     */
    public Department getDepartment(int depID) {
        Department res = null;
        try {
            Connection co = getConnection();
            PreparedStatement stmt = co.prepareStatement("SELECT * FROM Departement WHERE idDep=" + depID);
            ResultSet rs = stmt.executeQuery();
            AirportDAO airportDAO = new AirportDAO();
            while (rs.next()) {
                String name = rs.getString("nomDep");
                int cultInvest = rs.getInt("investissementCulturel2019");
                ArrayList<Airport> airportList = airportDAO.returnAllFromDep(depID);
                res = new Department(depID, name, cultInvest, airportList);
            }
            co.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
    }

    /**
     * Returns all the departments from the database
     * 
     * @return an array of departments
     */
    public ArrayList<Department> getAllDepartments() {
        ArrayList<Department> res = new ArrayList<Department>();
        System.out.println("Initializing database Department : \t2 out of 6");
        try {
            Connection co = getConnection();
            PreparedStatement stmt = co.prepareStatement("SELECT * FROM Departement");
            ResultSet rs = stmt.executeQuery();
            AirportDAO airportDAO = new AirportDAO();
            while (rs.next()) {
                int depID = rs.getInt("idDep");
                String depName = rs.getString("nomDep");
                int cultInvest = rs.getInt("investissementCulturel2019");
                ArrayList<Airport> airportList = airportDAO.returnAllFromDep(depID);
                res.add(new Department(depID, depName, cultInvest, airportList));
            }
            co.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
    }

    /**
     * Deletes the given department from the database
     * 
     * @param department the department
     */
    public void deleteDepartment(Department department) {
        if (department != null) {
            try {
                Connection co = getConnection();
                PreparedStatement stmt = co
                        .prepareStatement("DELETE FROM Departement WHERE idDep=" + department.getDepID());
                stmt.executeUpdate();
                co.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Adds the given department to the database
     * 
     * @param department the department
     */
    public void insertDepartment(Department department) {
        if (department != null) {
            try {
                Connection co = getConnection();
                int depID = department.getDepID();
                String depName = department.getDepName();
                double cultInvest = department.getCultInvest2019();
                PreparedStatement stmt = co.prepareStatement(
                        "INSERT INTO Departement VALUES (" + depID + ", " + depName + ", " + cultInvest + ")");
                stmt.executeUpdate();
                co.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Updates the given department to the new department
     * 
     * @param theDepartment the department you wan't to update
     * @param newDepartment the new department
     */
    public void updateDepartment(Department theDepartment, Department newDepartment) {
        if ((newDepartment != null) && (theDepartment != null)) {
            try {
                Connection co = getConnection();
                int depID = newDepartment.getDepID();
                String depName = newDepartment.getDepName();
                double cultInvest = newDepartment.getCultInvest2019();
                PreparedStatement stmt = co.prepareStatement("UPDATE Departement SET idDep=" + depID + " , nomDep="
                        + depName + " , investissementCulturel2019=" + cultInvest + " WHERE idDep="
                        + theDepartment.getDepID());
                stmt.executeUpdate();
                co.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
