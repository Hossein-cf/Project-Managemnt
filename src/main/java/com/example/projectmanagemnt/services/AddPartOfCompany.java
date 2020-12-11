package com.example.projectmanagemnt.services;

import com.example.projectmanagemnt.DBHelper.DB;
import com.example.projectmanagemnt.models.company.Part;
import com.example.projectmanagemnt.models.enums.PartActivity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RestController
public class AddPartOfCompany {
    DB dbHelper = new DB();
    @PostMapping(path = "/AddPartOfCompanyPost",consumes = "application/json",produces = "application/json")
    public void add(@RequestBody Part part){
        System.out.println(part.getName());
        dbHelper.addPart(part);
    }

    @PostMapping(path = "/GetPartsOfCompany",consumes = "application/json",produces = "application/json")
    public List<Part> get(Long companyId){
        Part part = new Part();
        part.setId(12);
        part.setName("fani");
        part.setAdminId(2);
        part.setPartActivity(PartActivity.ACTIVE);
        part.setCreateTime(new Date().toString());
        Part part1 = new Part();
        part1.setId(13);
        part1.setName("fani");
        part1.setAdminId(3);
        part1.setPartActivity(PartActivity.ACTIVE);
        part1.setCreateTime(new Date().toString());
        List<Part> list = new LinkedList<>();
        list.add(part);
        list.add(part1);
        return list;
    //return dbHelper.getAllPartsForCompany(companyId);
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
