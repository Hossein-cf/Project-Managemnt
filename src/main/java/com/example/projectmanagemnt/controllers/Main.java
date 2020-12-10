package com.example.projectmanagemnt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Main
{


    @RequestMapping("/123")
    public String index(){

        return "login_System";
    }
    @RequestMapping("/1234")
    public String index1(){

        return "uploadview";
    }

}