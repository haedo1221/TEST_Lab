package site.metacoding.serverproject.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import site.metacoding.serverproject.domain.Hospital;
import site.metacoding.serverproject.domain.HospitalRepository;

@RequiredArgsConstructor
@Controller

public class DownloadController {

    private final HospitalRepository hospitalRepository;

    // 메인 페이지
    @GetMapping("/")
    public String downloadMain() {
        return "download";
    }

    // 리스트 페이지
    @GetMapping("/list")
    public String downloadList(Model model) {

        // 1. 연결
        RestTemplate rt = new RestTemplate();
        Hospital[] response = rt.getForObject("http://3.38.254.72:5000/api/hospital?sidoCdNm=부산&sgguCdNm=부산사하구",
                Hospital[].class);

        List<Hospital> list = Arrays.asList(response);
        // System.out.println("===============");

        // 2. DB: saveAll()
        hospitalRepository.saveAll(list);

        // 3. model: findAll()
        model.addAttribute("hospitals", hospitalRepository.findAll());

        // 4. 리턴
        return "list";
    }
}