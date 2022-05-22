package opendata;

import java.util.List;
import java.util.Scanner;

import opendata.COVID19Dto.Response.Body.Items.Item;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== 코로나 현황 범위를 입력하세요. =====");
        System.out.println("ex) 20220110 시작일");
        System.out.println("ex) 20220115 종료일");
        String createDt = sc.nextLine();
        String updateDt = sc.nextLine();


        List<Item> COVID19List = DownloadCOVID19.getCOVID19List(createDt,updateDt);
        // System.out.println(COVID19List);
        for (int i = COVID19List.size()-1; i >= 0; i--) {
            System.out.println("===========================");
            System.out.println("누적 의심신고 검사자: " + COVID19List.get(i).getAccExamCnt()); 
            System.out.println("등록일시분초: " + COVID19List.get(i).getCreateDt());
            System.out.println("사망자 수: " + COVID19List.get(i).getDeathCnt());
            System.out.println("확진자 수: " + COVID19List.get(i).getDecideCnt());
            System.out.println("게시글번호: " + COVID19List.get(i).getSeq());
            System.out.println("기준일: " + COVID19List.get(i).getStateDt());
            System.out.println("기준시간: " + COVID19List.get(i).getStateTime());
            System.out.println("수정일시분초: " + COVID19List.get(i).getUpdateDt());

            System.out.println("===========================");
        }
    }
}