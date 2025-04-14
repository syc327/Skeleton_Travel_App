package data_import;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Data_Import {
    public static void main(String[] args) {
        BufferedReader br = null;
        String url = "jdbc:mysql://localhost:3306/travel_db";
        String username = "root";
        String password = "!123456";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            br = new BufferedReader(new FileReader("./travel.csv"));
            System.out.println(br.readLine());
            String line = null;
            while ((line = br.readLine()) != null){
                String[] lines = line.split(",");
                String no = lines[0];
                String district = lines[1];
                String title = lines[2];
                String desc = lines[3];
                for(int i = 4; i < lines.length-2; i++){
                    desc = desc + ","+ lines[i];
                }
                String address = lines[lines.length-2];
                String phone = lines[lines.length-1];
                String sql = String.format("insert into travel values ('%s', '%s', '%s', '%s', '%s', '%s')",
                        no, district, title, desc.replaceAll("'", "\""), address, phone);
                System.out.println(sql);
                stmt.executeUpdate(sql);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (stmt != null) try { stmt.close(); } catch (SQLException e) {}
            if (conn != null) try { conn.close(); } catch (SQLException e) {}
            if (rs != null) try { rs.close(); } catch (SQLException e) {}
            if (br != null) try { br.close(); } catch (IOException e) {}
        }


    }
}