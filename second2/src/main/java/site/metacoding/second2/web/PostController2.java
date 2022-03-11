package site.metacoding.second2.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 파일 리턴
public class PostController2 {
    
    @GetMapping("/post/writeForm")
    public String writeForm(){
        return "post/writeForm";
    }

    @GetMapping
    public String list(Model model){
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post
    }
}
