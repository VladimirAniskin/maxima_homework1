package ru.maxima.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import ru.maxima.app.dto.AccountDto;
import ru.maxima.app.model.Account;
import ru.maxima.app.service.AccountService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SignUpController implements Controller {
    private final AccountService accountService;

    @Autowired
    public SignUpController(AccountService accountService) {

        this.accountService = accountService;
    }


    @Override
    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        if (request.getMethod().equalsIgnoreCase("post")) {
            Account account = accountService.signUp(AccountDto.builder()
                    .email(request.getParameter("email"))
                    .password(request.getParameter("password"))
                    .build());
            if (account != null) {
                modelAndView.setViewName("profile");
                modelAndView.addObject("account", AccountDto.builder()
                        .email(account.getEmail())
                        .firstName(account.getFirstName())
                        .lastName(account.getLastName())
                        .password(account.getPassword())
                        .build());
            } else {
                modelAndView.setViewName("signUp");
            }
        }
        return modelAndView;
    }


}

