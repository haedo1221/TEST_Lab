package site.metacoding;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AttractionWeatherController {

    @GetMapping("/")
    public String main() {
        return "/main";
    }

}
