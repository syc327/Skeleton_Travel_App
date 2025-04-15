package travelapp;

import java.sql.*;
import java.util.ArrayList;

public class TravelService {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

    public ArrayList<TravelVO> searchAll(String num) {
        ArrayList<TravelVO> listAll = new ArrayList<>();
        try {
            String lineAll = "select no, district, title, description, address, phone from travel limit ?,?";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_db", "root", "!123456");
            pstmt = conn.prepareStatement(lineAll);
            pstmt.setInt(1, Integer.parseInt(num)*20-20);
            pstmt.setInt(2, 20);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                TravelVO vo = new TravelVO();
                vo.setNo(rs.getString("no"));
                vo.setDistrict(rs.getString("district"));
                vo.setTitle(rs.getString("title"));
                vo.setDescription(rs.getString("description"));
                vo.setAddress(rs.getString("address"));
                vo.setPhone(rs.getString("phone"));

                listAll.add(vo);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        return listAll;
    }
    public ArrayList<TravelVO> searchDistrict(String num) {
        ArrayList<TravelVO> listsDistrict = new ArrayList<>();
        try {
            String lineDistrict = "select no, district, title, description, address, phone from travel where district like ?";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_db", "root", "!123456");
            pstmt = conn.prepareStatement(lineDistrict);
            pstmt.setString(1, "%"+num+"%");
            rs = pstmt.executeQuery();

            while(rs.next()) {
                TravelVO vo = new TravelVO();
                vo.setNo(rs.getString("no"));
                vo.setDistrict(rs.getString("district"));
                vo.setTitle(rs.getString("title"));
                vo.setDescription(rs.getString("description"));
                vo.setAddress(rs.getString("address"));
                vo.setPhone(rs.getString("phone"));
                listsDistrict.add(vo);
            }


        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return listsDistrict;
    }
}
