package ru.maxima.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OpenController {
    @GetMapping
    public String open(HttpServletRequest request,
                       Model model){
        System.out.println("Контроллер работает");
     return ("register");
    }


}
