package com.example.projectmanagemnt.services;

import com.example.projectmanagemnt.DBHelper.DB;

import com.example.projectmanagemnt.models.company.Customer;
import com.example.projectmanagemnt.models.company.Project;
import com.example.projectmanagemnt.models.enums.ProjectCondition;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RestController

public class AddProject {
    DB dbHelper = new DB();

    @PostMapping(path = "/AddProjectPost", consumes = "application/json", produces = "application/json")
    public void add(@RequestBody Project project) {
        System.out.println(project.getDocuments());
        dbHelper.addProject(project);
    }

    @PostMapping(path = "/GetProjectsforCustomer", consumes = "application/json", produces = "application/json")
    public List<Project> getByCustomerId(@RequestBody Customer customer) {
        System.out.println(customer.getId());
        return dbHelper.getProjectsForCustomer(customer.getId());
    }

    @PostMapping(path = "/getProjectByID")
    public Project getProjectForCompany(@RequestBody Project project) {
        System.out.println(project.getId());
        return dbHelper.getProjectById(project.getId());
    }

    @GetMapping(path = "/getNotStartedProjects")
    public List<Project> getNotStartedProjects() {
        List<Project> list = new LinkedList<>();
        list = dbHelper.getNOT_STARTEDProjects();
//        Project project = new Project();
//        project.setCustomerId(10);
//        project.setCondition(ProjectCondition.NOT_STARTED.value);
//        project.setSubject("ticketing");
//        project.setGenerateTime(new Date().toString());
//        project.setId(2);
//        list.add(project);
        return list;
    }

    @DeleteMapping(path = "/AddProjectDelete", consumes = "application/json", produces = "application/json")
    public void delete(@RequestBody Project project) {
        System.out.println(project.getId());
        dbHelper.deleteProject(project);
    }

    @PutMapping(path = "/updateProject", consumes = "application/json", produces = "application/json")
    public void update(@RequestBody Project project) {
        Project project1 = dbHelper.getProjectById(project.getId());
        if (project.getManagerId() != 0)
            project1.setManagerId(project.getManagerId());
        if (project.getStartTime() != null)
            project1.setStartTime(project.getStartTime());
        if (project1.getCondition() != null)
            project1.setCondition(project.getCondition());
        //todo
        dbHelper.upDateProject(project1);
    }
}
