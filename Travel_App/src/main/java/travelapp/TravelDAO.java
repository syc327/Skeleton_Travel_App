package travelapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TravelDAO {
    private Connection conn = null;
    public TravelDAO() {
        String url = "jdbc:mysql://localhost:3306/travel_db";
        String user = "root";
        String password = "!123456";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }



        String all = "select * from travel";
        String nation = "select * from nation where district = ?";
        String search = "select * from travel";

    }
}
