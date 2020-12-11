package com.example.projectmanagemnt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "login_System";
    }

    @RequestMapping("/systemDashboard")
    public String goToSystemDashboard() {
        return "Dashbord_System";
    }

    @RequestMapping("/AddCompany_System")
    public String goToAddCompany_System() {
        return "AddCompany_System";
    }
}
