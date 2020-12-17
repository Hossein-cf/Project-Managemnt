package com.example.projectmanagemnt.services;

import com.example.projectmanagemnt.DBHelper.DB;


import com.example.projectmanagemnt.models.company.Employee;
import com.example.projectmanagemnt.models.company.Part;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.LinkedList;
import java.util.List;

@RestController
public class AddEmployee {
    DB dbHelper = new DB();

    @PostMapping(path = "/employeePost", consumes = "application/json", produces = "application/json")
    public long add(@RequestBody Employee employee) {
        System.out.println(employee.getId());
        dbHelper.addEmployee(employee);
        return DB.id;

    }

    @PostMapping(path = "/getAllEmployeeOfCurrentPart", consumes = "application/json", produces = "application/json")
    public List<Employee> getAllEmployeeOfCurrentPart(@RequestBody Part part) {
        List<Employee> employees = new LinkedList<>();
        Employee employee = new Employee();
        employee.setPartId(part.getId());
        employee.setId(4);
        employee.setName("hossein shkaeri");
        employee.setPhoneNumber("09149570548");
        employee.setEmail("shakryhsyn1@gmail.com");
        System.out.println(part.getId());
        employees.add(employee);
        if (part.getId() == employee.getPartId())
            return employees;
        return dbHelper.getEmployeesForPart(part.getId());


    }

    @PostMapping(path = "/employeeGet", consumes = "application/json", produces = "application/json")
    public Employee get(@RequestBody Employee employee) {
//        Employee employee2 = new Employee();
//        employee2.setName("hossein");
//        employee2.setId(2);
//        Employee employee1 = new Employee();
//        employee1.setName("ali");
//        employee1.setId(3);
//        if (employee.getId() == 2)
//            return employee2;
//        else if (employee.getId() == 3)
//            return employee1;
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

    @PutMapping(path = "/addEmployeeToPart", consumes = "application/json", produces = "application/json")
    public void addEmployeeToPart(@RequestBody AddEmployeeToPart addEmployeeToPart) {
        DB db = new DB();

        addEmployeeToPart.getId().forEach( aLong -> {
          Employee employee=  db.getEmployee(aLong);
          employee.setPartId(addEmployeeToPart.getPartId());
          db.updateEmployee(employee);
        });

    }



}
@Data
class AddEmployeeToPart{
    List<Long> id;
    long partId;
}
