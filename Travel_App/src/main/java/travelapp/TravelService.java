package travelapp;

import java.sql.*;
import java.util.ArrayList;

public class TravelService {
    TravelDAO dao = new TravelDAO();
    public ArrayList<TravelVO> searchAll(String num) {
        ArrayList<TravelVO> listsAll = new ArrayList<>();
        listsAll = dao.searchAll(num);
        return listsAll;
    }

    public ArrayList<TravelVO> searchDistrict(String num) {
        ArrayList<TravelVO> listsDistrict = new ArrayList<>();
        listsDistrict = dao.searchDistrict(num);
        return listsDistrict;
    }

    public ArrayList<TravelVO> search(String num) {
        ArrayList<TravelVO> lists = new ArrayList<>();
        lists = dao.search(num);
        return lists;
    }
}
