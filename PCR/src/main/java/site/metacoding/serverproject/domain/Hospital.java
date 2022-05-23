package site.metacoding.serverproject.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Hospital {
    @Id
    private Integer id;

    private String addr; // 의료기관 주소
    private Integer mgtStaDd; // 운영 시작 일자
    private String pcrPsblYn; // PCR 검사 가능 여부
    private String ratPsblYn; // 신속항원검사 가능 여부
    private Integer recuClCd; // 요양종별코드_11: 종합병원 21: 병원 31: 의원
    private String sgguCdNm; // 시군구명
    private String sidoCdNm; // 시도명
    private String yadmNm; // 요양기관명
    private String ykihoEnc;// 암호화된 요양 기호
    private String xposWgs84; // 세계지구 x좌표
    private String yposWgs84; // 세계지구 y좌표
    private String xpos; // x 좌표
    private String ypos; // y 좌표

}