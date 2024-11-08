package ru.maxima.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OpenController {
    @GetMapping
    public String open(HttpServletRequest request,
                       Model model){
        System.out.println("Контроллер работает");
     return ("signUp");
    }
@PostMapping
    public String register (HttpServletRequest request,
                       Model model){
        System.out.println("Контроллер работает");
        return ("register");
    }

}
