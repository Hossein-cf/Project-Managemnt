package com.example.projectmanagemnt.test.webservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testWebService {
    @GetMapping("/test")
    public String test (){
        return "uploadview";
    }

}
