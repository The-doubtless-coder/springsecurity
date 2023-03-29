package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
public class HomeController {
    @GetMapping("/home")
    public String homePageView() {
        return "homePage";
    }

    @GetMapping("/welcome")
    public String welcomeView() {
        return "welcome";
    }

    @GetMapping("/admin")
    public String adminPageView() {
        return "adminPage";
    }

    @GetMapping("/employee")
    public String employeePageView() {
        return "employeePage";
    }

    @GetMapping("/student")
    public String studentPageView() {
        return "studentPage";
    }
    @GetMapping("/denied")
    public String deniedErrorPage() {
        return "denied";
    }
}
