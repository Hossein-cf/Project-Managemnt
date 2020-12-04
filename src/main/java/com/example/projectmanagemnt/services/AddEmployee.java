package com.example.projectmanagemnt.services;

import com.example.projectmanagemnt.DBHelper.DB;


import com.example.projectmanagemnt.models.company.Employee;
import org.springframework.web.bind.annotation.*;

public class AddEmployee {
    DB dbHelper = new DB();
    @PostMapping(path = "/employeePost",consumes = "application/json",produces = "application/json")
    public void add(@RequestBody Employee employee){
        System.out.println(employee.getId());
        dbHelper.addEmployee(employee);
    }

    @GetMapping(path = "/employeeGet",consumes = "application/json",produces = "application/json")
    public Employee get(@RequestBody long ID){
        System.out.println(ID);
        return dbHelper.getEmployee(ID);
    }

    @DeleteMapping(path = "/EmployeeDelete",consumes = "application/json",produces = "application/json")
    public void delete(@RequestBody Employee employee){
        System.out.println(employee.getId());
        dbHelper.deleteEmployee(employee);
    }
    @PutMapping(path = "/employeePut",consumes = "application/json",produces = "application/json")
    public void update(@RequestBody Employee employee){
        System.out.println(employee.getId());
        dbHelper.updateEmployee(employee);
    }
}
