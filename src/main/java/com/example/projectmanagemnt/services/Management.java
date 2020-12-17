package com.example.projectmanagemnt.services;

import com.example.projectmanagemnt.DBHelper.DB;
import com.example.projectmanagemnt.models.Ticket;
import com.example.projectmanagemnt.models.company.Employee;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Management {
    @PostMapping("/Login_Manager")
    public Employee createTicket(@RequestBody Employee employee) {
        System.out.println("fuckkkkkkkkkkkkkkk");
        Employee employee1 = new DB().getEmployeeByUserPass(employee.getUsername(), employee.getPassword());
        if (new DB().isManagerForProject(employee1.getId())) {
            return employee1;
        }
        return new Employee();

    }
}
