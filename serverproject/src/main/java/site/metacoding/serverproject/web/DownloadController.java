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

    @GetMapping("/download")
    public String download(Model model){

        // 1. URI로 다운로드
        RestTemplate rt = new RestTemplate(); // Spring이 제공해주는 HTTP 통신 템플릿. 동기 방식이다.
        Hospital[] response = 
        rt.getForObject("http://3.38.254.72:5000/api/hospital?sidoCdNm=부산&sgguCdNm=부산사하구", Hospital[].class);
        List<Hospital> list = Arrays.asList(response);
        // System.out.println("========================================");
        // System.out.println(list.get(0));

        // 2. DB에 saveAll()으로 INSERT 한번에 처리하기
        hospitalRepository.saveAll(list);
        System.out.println(hospitalRepository.saveAll(list));

        // 2. model에 담기 (findAll()은 SELECT * FROM hospital과 같다)
        model.addAttribute("hospitals", hospitalRepository.findAll());

        // 3. 리턴
        return "list";
    }
}