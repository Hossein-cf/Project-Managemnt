package com.example.projectmanagemnt.services;

import com.example.projectmanagemnt.DBHelper.DB;

import com.example.projectmanagemnt.models.company.Project;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController

public class AddProject {
    DB dbHelper = new DB();
    @PostMapping(path = "/AddProjectPost",consumes = "application/json",produces = "application/json")
    public void add(@RequestBody Project project){
        System.out.println(project.getId());
        dbHelper.addProject(project);
    }

    @GetMapping(path = "/AddProjectGetProjectByCustomerId",consumes = "application/json",produces = "application/json")
    public Project getByCustomerId(@RequestBody long ID){
        System.out.println(ID);
        return dbHelper.getProjectByCustomerId(ID);
    }

    @GetMapping(path = "/AddProjectGetProjectForCompany",consumes = "application/json",produces = "application/json")
    public List getProjectForCompany(@RequestBody long ID){
        System.out.println(ID);
        return dbHelper.getProjectForCompany(ID);
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
