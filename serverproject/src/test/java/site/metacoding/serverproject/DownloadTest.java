package site.metacoding.serverproject;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import site.metacoding.serverproject.domain.Hospital;

public class DownloadTest {

    @Test
    public void 다운로드(){
        RestTemplate rt = new RestTemplate();
        Hospital[] response = 
        rt.getForObject("http://3.38.254.72:5000/api/hospital?sidoCdNm=부산&sgguCdNm=부산사하구", Hospital[].class);
        List<Hospital> list = Arrays.asList(response);
        System.out.println("========================================");
        System.out.println(list.get(0));
    }
}