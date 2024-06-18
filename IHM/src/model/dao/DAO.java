package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class connects to the database and returns the connection
 */
public abstract class DAO<T> {
    private static String url = "jdbc:mysql://localhost:3306/sae201";
    private static String username = "root";
    private static String password = "root";

    /**
     * Returns the connection to the database
     * 
     * @return the connection
     */
    protected Connection getConnection() {
        Connection co = null;
        try {
            co = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return co;
    }
}
