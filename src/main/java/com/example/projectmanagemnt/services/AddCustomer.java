package com.example.projectmanagemnt.services;

import com.example.projectmanagemnt.DBHelper.DB;


import com.example.projectmanagemnt.models.company.Customer;
import org.springframework.web.bind.annotation.*;
@RestController

public class AddCustomer {

    DB dbHelper = new DB();

    @PostMapping(path = "/customerPost",consumes = "application/json",produces = "application/json")
    public void add(@RequestBody Customer customer){
        System.out.println(customer.getPassword());
        dbHelper.addCustomer(customer);
    }

    @GetMapping(path = "/customerGet",consumes = "application/json",produces = "application/json")
    public Customer get(@RequestBody long ID){
        System.out.println(ID);
        return dbHelper.getCustomerById(ID);
    }

    @DeleteMapping(path = "/customerDelete",consumes = "application/json",produces = "application/json")
    public void delete(@RequestBody Customer customer){
        System.out.println(customer.getCompanyId());
        dbHelper.deleteCustomer(customer);
    }

    @PutMapping(path = "/customerPut",consumes = "application/json",produces = "application/json")
    public void update(@RequestBody Customer customer){
        System.out.println(customer.getCompanyId());
        dbHelper.upDate(customer);
    }

}
