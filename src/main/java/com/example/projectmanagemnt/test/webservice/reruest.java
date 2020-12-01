package com.example.projectmanagemnt.test.webservice;

import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class reruest {
    @PostMapping(path = "/test1",consumes = "application/json",produces = "application/json")
    public void test1(@RequestBody User user){
        System.out.println(user.getName()+"\n"+user.getSurname());
    }
}
@Data
class User{
    String name;
    String surname;
}
