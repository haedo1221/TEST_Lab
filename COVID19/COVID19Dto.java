package opendata;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class COVID19Dto {
    private Response response; 

    @AllArgsConstructor
    @Data
    class Response {
        private Header header; 

        private Body body; 

        @AllArgsConstructor
        @Data
        class Header {
            private String resultCode;
            private String resultMsg;

        }

        @AllArgsConstructor
        @Data
        class Body {
            private Items items;
            private int numOfRows;
            private int pageNo;

            private int totalCount;

            @AllArgsConstructor
            @Data
            class Items {

                private List<Item> item;

                @AllArgsConstructor
                @Data
                class Item { // int나 다른 타입으로 안 받은 이유: 지금 숫자들로 계산하지 않을거라서
                    private String accExamCnt; // 누적 의심신고 검사자
                    private String createDt; // 등록일시분초
                    private String deathCnt; // 사망자 수
                    private String decideCnt; // 확진자 수
                    private String seq; //게시글번호(감염현황 고유값)
                    private String stateDt; //기준일
                    private String stateTime; // 기준시간
                    private String updateDt; // 수정일시분초
                }
            }
        }
    }
}