package com.fastcampus.ch4.controller;

import com.fastcampus.ch4.domain.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;



//  @RequestBody(ajax에서 보내주는 객체)  메서드에 @ResponseBody(json으로 보내기) 어노테이션 작성
// 메서드가 여러개인 상황에서 @RequestBody 가 여러개 쓰일 경우
// @RestController 를 작성 하면  @ResponseBody는 작성 하지 않아도된다.
@Controller
public class SimpleRestController {
//    @GetMapping("/ajax")
//    public String ajax() {
//        return "ajax";
//    }
    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping("/send")
    @ResponseBody
    public Person test(@RequestBody Person p) {
        System.out.println("p = " + p);
        p.setName("ABC");
        p.setAge(p.getAge() + 10);

        return p;
    }
}