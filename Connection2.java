package project3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection2 {
    private static final String URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String USER = "root";
    private static final String PASSWORD = "290816@123";

    // ✅ Method to return database connection
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL Driver
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // ✅ Main Method to Test Connection
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("✅ Database Connection Successful!");
        } else {
            System.out.println("❌ Database Connection Failed!");
        }
    }
}
