package com.example.projectmanagemnt.services;

import com.example.projectmanagemnt.DBHelper.DB;

import com.example.projectmanagemnt.models.company.Customer;
import com.example.projectmanagemnt.models.company.Project;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController

public class AddProject {
    DB dbHelper = new DB();
    @PostMapping(path = "/AddProjectPost",consumes = "application/json",produces = "application/json")
    public void add(@RequestBody Project project){
        System.out.println(project.getDeadLine());
        dbHelper.addProject(project);
    }

    @PostMapping(path = "/GetProjectsforCustomer",consumes = "application/json",produces = "application/json")
    public List<Project> getByCustomerId(@RequestBody Customer customer){
        System.out.println(customer.getId());
        return dbHelper.getProjectsForCustomer(customer.getId());
    }

    @PostMapping(path = "/getProjectByID",consumes = "application/json",produces = "application/json")
    public List getProjectForCompany(@RequestBody Project project){
        System.out.println(project.getId());
        return dbHelper.getProjectById(project.getId());
    }

    @DeleteMapping(path = "/AddProjectDelete",consumes = "application/json",produces = "application/json")
    public void delete(@RequestBody Project project){
        System.out.println(project.getId());
        dbHelper.deleteProject(project);
    }
    @PutMapping(path = "/AddProjectPut",consumes = "application/json",produces = "application/json")
    public void update(@RequestBody Project project){
        System.out.println(project.getId());
        dbHelper.upDateProject(project);
    }
}
