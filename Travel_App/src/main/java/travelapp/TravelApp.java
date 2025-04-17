package travelapp;

import java.util.ArrayList;
import java.util.Scanner;

public class TravelApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("번호를 입력하세요 (1 : 전체보기 / 2 : 구역 검색 / 3 : 키워드 검색 / exit : 종료) : ");
            String num = sc.nextLine();
            if (num.equals("1")) {
                while (true) {
                    System.out.print("페이지 입력 (이전으로 돌아가고 싶다면 quit): ");
                    num = sc.nextLine();
                    if (num.equals("quit")) {
                        System.out.println("이전페이지로 돌아갑니다.");
                        break;
                    }
                    System.out.println(num + " 페이지");
                    TravelService travelAll = new TravelService();
                    ArrayList<TravelVO> listsAll = travelAll.searchAll(num);
                    for (TravelVO travel : listsAll) {
                        System.out.println((String.format("번호 [%s]\t지역 : %s\t 제목 : %s\n%s\n주소 : %s\n전화번호 : %s",
                                travel.getNo(), travel.getDistrict(), travel.getTitle(), travel.getDescription(),
                                travel.getAddress(), travel.getPhone())));
                    }
                }
            }
            if (num.equals("2")) {
                while (true) {
                    System.out.print("구역 검색 (수도, 충청, 전라, 경상, 강원, 제주 // quit) : ");
                    num = sc.nextLine();
                    if (num.equals("quit")) {
                        System.out.println("이전페이지로 돌아갑니다.");
                        break;
                    }
                    System.out.println(num + " 관광지");
                    TravelService travelDistrict = new TravelService();
                    ArrayList<TravelVO> listsDistrict = travelDistrict.searchDistrict(num);
                    for (TravelVO travelD : listsDistrict) {
                        System.out.println((String.format("번호 [%s]\t지역 : %s\t 제목 : %s\n%s\n주소 : %s\n전화번호 : %s",
                                travelD.getNo(), travelD.getDistrict(), travelD.getTitle(), travelD.getDescription(),
                                travelD.getAddress(), travelD.getPhone())));
                    }
                }
            }
            if (num.equals("3")) {
                while (true) {
                    System.out.print("키워드를 입력해주세요 // quit) : ");
                    num = sc.nextLine();
                    if (num.equals("quit")) {
                        System.out.println("이전페이지로 돌아갑니다.");
                        break;
                    }
                    System.out.println(num + " 을 포함한 검색 결과");
                    TravelService travelSearch = new TravelService();
                    ArrayList<TravelVO> listsSearch = travelSearch.search(num);
                    for (TravelVO travelS : listsSearch) {
                        System.out.println((String.format("번호 [%s]\t지역 : %s\t 제목 : %s\n%s\n주소 : %s\n전화번호 : %s",
                                travelS.getNo(), travelS.getDistrict(), travelS.getTitle(), travelS.getDescription(),
                                travelS.getAddress(), travelS.getPhone())));
                    }
                }
            }
            if(num.equals("quit")) {
                System.out.print("번호를 입력하세요 (1 : 전체보기 / 2 : 구역 검색 / 3 : 키워드 검색 / exit : 종료) : ");
                num = sc.nextLine();
            }
            if (num.equals("exit")) {
                System.out.println("종료");
                System.exit(0);
            }
            else {
                System.out.println("올바른 키워드를 입력하세요.");
            }
        }
    }
}
