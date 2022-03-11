package site.metacoding.serverproject.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import site.metacoding.serverproject.domain.Hospital;

@Controller
public class DownloadController {

    @GetMapping("/download")
    public String download(){

        // 1. URI로 다운로드
        RestTemplate rt = new RestTemplate(); // Spring이 제공해주는 HTTP 통신 템플릿. 동기 방식이다.
        Hospital[] response = 
        rt.getForObject("http://3.38.254.72:5000/api/hospital?sidoCdNm=부산&sgguCdNm=부산사하구", Hospital[].class);
        List<Hospital> list = Arrays.asList(response);
        //System.out.println("========================================");
        //System.out.println(list.get(0));
        
        // 2. DB에 saveAll() + model에 담기

        // 3. 리턴
        return "list";
    }
}
