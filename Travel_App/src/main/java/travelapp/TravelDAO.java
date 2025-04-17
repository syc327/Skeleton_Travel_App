package travelapp;

import java.sql.*;
import java.util.ArrayList;

public class TravelDAO {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String url = "jdbc:mysql://localhost:3306/travel_db";
    String user = "root";
    String password = "!123456";



    public TravelDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<TravelVO> searchAll(String num) {
        ArrayList<TravelVO> listAll = new ArrayList<>();
        try {
            String lineAll = "select no, district, title, description, address, phone from travel limit ?,?";
            pstmt = conn.prepareStatement(lineAll);
            pstmt.setInt(1, Integer.parseInt(num)*10-10);
            pstmt.setInt(2, 10);
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
    public ArrayList<TravelVO> search(String num) {
        ArrayList<TravelVO> listsSearch = new ArrayList<>();
        try {
            String lineSearch = "select no, district, title, description, address, phone from travel where concat(district, title, description, address) like ?";
            pstmt = conn.prepareStatement(lineSearch);
            pstmt.setString(1, "%" + num + "%");
            rs = pstmt.executeQuery();

            while(rs.next()) {
                TravelVO vo = new TravelVO();
                vo.setNo(rs.getString("no"));
                vo.setDistrict(rs.getString("district"));
                vo.setTitle(rs.getString("title"));
                vo.setDescription(rs.getString("description"));
                vo.setAddress(rs.getString("address"));
                vo.setPhone(rs.getString("phone"));
                listsSearch.add(vo);
            }


        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return listsSearch;
    }
}
