package com.example.projectmanagemnt.services;

import com.example.projectmanagemnt.DBHelper.DB;


import com.example.projectmanagemnt.models.company.Employee;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;

@RestController
public class AddEmployee {
    DB dbHelper = new DB();

    @PostMapping(path = "/employeePost", consumes = "application/json", produces = "application/json")
    public long add(@RequestBody Employee employee) {
        System.out.println(employee.getId());
        dbHelper.addEmployee(employee);
        return DB.id;

    }

    @PostMapping(path = "/employeeGet", consumes = "application/json", produces = "application/json")
    public Employee get(@RequestBody Employee employee) {
        Employee employee2 = new Employee();
        employee2.setName("hossein");
        employee2.setId(2);
        Employee employee1 = new Employee();
        employee1.setName("ali");
        employee1.setId(3);
        if (employee.getId() == 2)
            return employee2;
        else if (employee.getId() == 3)
            return employee1;
        return dbHelper.getEmployee(employee.getId());
    }

    @DeleteMapping(path = "/EmployeeDelete", consumes = "application/json", produces = "application/json")
    public void delete(@RequestBody Employee employee) {
        System.out.println(employee.getId());
        dbHelper.deleteEmployee(employee);
    }

    @PutMapping(path = "/employeePut", consumes = "application/json", produces = "application/json")
    public void update(@RequestBody Employee employee) {
        System.out.println(employee.getId());
        dbHelper.updateEmployee(employee);
    }
}
