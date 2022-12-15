package com.cg.spring_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class ExerciseController {

    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("bai1");
    }

    @PostMapping("/bai1")
    public String bai1(@RequestParam("money") Double money,
                       @RequestParam("from") Double from,
                       @RequestParam("to") Double to,
                       Model model) {
        model.addAttribute("result", money * to / from);
        return "bai1";
    }
}
