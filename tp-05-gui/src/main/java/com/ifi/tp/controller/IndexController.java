package com.ifi.tp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/registerTrainer")
    ModelAndView registerNewTrainer(String trainerName){
        var modelAndView = new ModelAndView("register");
        modelAndView.addObject("name", trainerName);

        return modelAndView;
    }
}
