package com.example.projectmanagemnt.services;

import com.example.projectmanagemnt.DBHelper.DB;
import com.example.projectmanagemnt.models.company.Company;

import org.springframework.web.bind.annotation.*;

public class AddCompany  {
    DB dbHelper = new DB();
    @PostMapping(path = "/companyPost",consumes = "application/json",produces = "application/json")
    public void add(@RequestBody Company company){
        System.out.println(company.getId());
        dbHelper.addCompany(company);

    }
    @GetMapping(path = "/companyGet",consumes = "application/json",produces = "application/json")
   public Company get(@RequestBody long ID){
        System.out.println(ID);
        return dbHelper.getCompany(ID);

    }
    @DeleteMapping(path = "/companyDelete",consumes = "application/json",produces = "application/json")
    public void delete(@RequestBody Company company){
        System.out.println(company.getId());
        dbHelper.deleteCompany(company);
    }
    @PutMapping(path = "/companyPut",consumes = "application/json",produces = "application/json")
    public void update(@RequestBody Company company){
        System.out.println(company.getId());
        dbHelper.updateCompany(company);
    }
}
