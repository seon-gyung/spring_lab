package site.metacoding.second2.web;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController // 데이터를 리턴
public class PostAPIController2 {
    
    // 헤더 O 바디 X
    @GetMapping("/post/{id}")
    public String test1(@PathVariable int id) {
        return "id : " + id;
    }

    // SELECT * FROM post WHERE title = ?
    // http://localhost:8000/post?title=?
    @GetMapping("/post")
    public String search(String title) {
        return "title : " + title;
    }

    @PostMapping("/post")
    public String test2(String title, String content) {
        return "title : " + title + ",content : " + content;
    }
    
    @PutMapping("/post/{id}")
    public String test3(String title, String content, @PathVariable int id) {
        return "title : " + title + ", content : " + content + ", id : " + id;
    }

    @DeleteMapping("/post/{id")
    public String test4 (@PathVariable int id){
        return "id : " + id;
    }
}
