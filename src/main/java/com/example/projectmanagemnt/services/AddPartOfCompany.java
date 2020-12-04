package com.example.projectmanagemnt.services;

import com.example.projectmanagemnt.DBHelper.DB;
import com.example.projectmanagemnt.models.company.Part;
import org.springframework.web.bind.annotation.*;

public class AddPartOfCompany {
    DB dbHelper = new DB();
    @PostMapping(path = "/AddPartOfCompanyPost",consumes = "application/json",produces = "application/json")
    public void add(@RequestBody Part part){
        System.out.println(part.getId());
        dbHelper.addPart(part);
    }

    @GetMapping(path = "/AddPartOfCompanyGet",consumes = "application/json",produces = "application/json")
    public Part get(@RequestBody long ID){
        System.out.println(ID);
        return dbHelper.getPartById(ID);
    }

    @DeleteMapping(path = "/AddPartOfCompanyDelete",consumes = "application/json",produces = "application/json")
    public void delete(@RequestBody Part part){
        System.out.println(part.getId());
        dbHelper.deletePart(part);
    }
    @PutMapping(path = "/AddPartOfCompanyPut",consumes = "application/json",produces = "application/json")
    public void update(@RequestBody Part part){
        System.out.println(part.getId());
        dbHelper.updatePart(part);
    }
}
