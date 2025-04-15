package travelapp;

import java.util.ArrayList;
import java.util.Scanner;

public class TravelApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("번호를 입력하세요 (1 : 전체보기 / 2 : 구역 검색 / 3 : 키워드 검색) : " );
        String num = sc.nextLine();
        if(num.equals("1")) {
            while(true) {
                System.out.print("페이지 입력 (종료를 원할 시 exit): ");
                num = sc.nextLine();
                System.out.println(num + " 페이지");
                if(num.equals("exit")){break;}
                TravelService travelAll = new TravelService();
                ArrayList<TravelVO> listsAll = travelAll.searchAll(num);
                for (TravelVO travel : listsAll) {
                    System.out.println((String.format("%s\t%s\t%s\t%s\t%s\t%s",
                            travel.getNo(), travel.getDistrict(), travel.getTitle(), travel.getDescription(),
                            travel.getAddress(), travel.getPhone())));
                }

            }
        }
        if(num.equals("2")){
            while(true) {
                System.out.print("구역 검색 (수도, 충청, 전라, 경상, 강원, 제주) : ");
                num = sc.nextLine();
                System.out.println(num+ " 관광지");
                TravelService travelDistrict = new TravelService();
                ArrayList<TravelVO> listsDistrict = travelDistrict.searchDistrict(num);
                for (TravelVO travelD : listsDistrict) {
                    System.out.println((String.format("%s\t%s\t%s\t%s\t%s\t%s",
                            travelD.getNo(), travelD.getDistrict(), travelD.getTitle(), travelD.getDescription(),
                            travelD.getAddress(), travelD.getPhone())));
                }
            }
        }
        System.out.println("종료");
    }
}
