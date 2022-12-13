package com.cg.spring_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//các từ khóa đi kèm @ được gọi là các Annotation, có nhiệm vụ quy định chức năng của lớp
//@Controller: đánh dấu đây là 1 controller của dự án
//@RequestMapping: đánh dấu đường dẫn URL ở cấp độ class
//@Get,@Put,@Post + Mapping: đánh dấu đường dẫn URL + method của URL,
//cấp độ phương thức
@Controller
public class GreetingController {
    @GetMapping("/greeting")
    public String greeting() {
        return "index";
    }

    @RequestMapping(value = "/greeting1", method = RequestMethod.GET)
    public String greeting1() {
        return "index";
    }
}
