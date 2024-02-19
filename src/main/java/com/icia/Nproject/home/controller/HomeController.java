package com.icia.Nproject.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @GetMapping("/join/individual")
    public String joinIndividual() {
        return "joinIndividual";
    }

    @GetMapping("/join/business")
    public String joinBusiness() {
        return "joinBusiness";
    }
}