package weathertest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import weathertest.ResponseDto.Response.Body.Items.Item;

public class DownloadWeather {
    public static Map<String, String> getWeatherList(String baseDate, String baseTime) { // 날짜와 시간데이터를 받아와, url의 쿼리 스트링
                                                                                         // 값 바꿔주기
        Map<String, String> weatherMap = new HashMap<>(); // 날씨코드와 온도를 뽑아낼 Map 선언

        try {
            URL url = new URL(
                    "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst?serviceKey=090tbpV1s%2F%2F2YJxMEkGWsGycvC6GQRKrIXFNzkv44vZejXWfuwu0yzNcVUOUEnn5QgU9fXb9yuJfArubBmvWpg%3D%3D&pageNo=1&numOfRows=1000&dataType=JSON&base_date="
                            + baseDate + "&base_time=" + baseTime + "&nx=97&ny=75&type=json");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // 선 연결

            BufferedReader br = new BufferedReader( // 읽어오기
                    new InputStreamReader(conn.getInputStream(), "utf-8"));

            String responseJson = br.readLine(); // 버퍼 비우기
            Gson gson = new Gson();
            ResponseDto responseDto = gson.fromJson(responseJson, ResponseDto.class); // json -> 자바 오브젝트로 옮기기

            List<Item> result = responseDto.getResponse().getBody().getItems().getItem(); // 받아온 데이터를 list에 옮기기

            for (int i = 0; i < result.size(); i++) {
                weatherMap.put(result.get(i).getCategory(), result.get(i).getObsrValue()); // map에 날씨코드:온도 저장
            }

            return weatherMap; // map 리턴

        } catch (Exception e) {
            System.out.println("주소 입력이 잘못되었습니다.");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }

        return null;
    }
}
