package com.example.projectmanagemnt.services;

import com.example.projectmanagemnt.DBHelper.DB;
import com.example.projectmanagemnt.models.company.Company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddCompany {
    DB dbHelper = new DB();

    @PostMapping(path = "/companyPost", consumes = "application/json", produces = "application/json")
    public void add(@RequestBody Company company) {
        System.out.println(company.getName());
        System.out.println(company.getPassword());
        dbHelper.addCompany(company);

    }

    @PostMapping(path = "/companyGet", consumes = "application/json",produces = "application/json")
    public @ResponseBody Company get(@RequestBody Company userPass ) {
        System.out.println(userPass.getPassword());
        System.out.println(userPass.getUsername());
        Company company = new Company();
        company.setName("fuck");
        company.setEmail("fuck1");
        company.setPassword("admin");
        company.setUsername("admin");
        company.setCreateTime("fuck3");
        if (userPass.getPassword().trim().equals("admin") || userPass.getUsername().trim().equals("admin"))
       // return dbHelper.getCompany(userPass.Username,userPass.Password);
        return company;
        else
            return new Company();

    }

    @GetMapping(path = "/companySize")
    public int getSize()  {

        return DB.companies.size();

    }

    @DeleteMapping(path = "/companyDelete", consumes = "application/json", produces = "application/json")
    public void delete(@RequestBody Company company) {
        System.out.println(company.getId());
        dbHelper.deleteCompany(company);
    }

    @PutMapping(path = "/companyPut", consumes = "application/json", produces = "application/json")
    public void update(@RequestBody Company company) {
        System.out.println(company.getId());
        dbHelper.updateCompany(company);
    }
}
