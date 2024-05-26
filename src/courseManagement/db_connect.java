package courseManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class db_connect {
    Connection c;
    Statement s;

    public db_connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost/coursemanagementsystem", "root", "");
            s = c.createStatement();
        } catch (ClassNotFoundException e) {
            System.err.println("Failed to load MySQL JDBC driver.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }
}