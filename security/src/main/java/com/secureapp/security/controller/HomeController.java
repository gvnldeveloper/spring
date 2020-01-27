package com.secureapp.security.controller;

import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

    public String homePage()
    {
        return "home.jsp";
    }
}
