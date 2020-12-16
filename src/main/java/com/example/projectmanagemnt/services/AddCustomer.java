package com.example.projectmanagemnt.services;

import com.example.projectmanagemnt.DBHelper.DB;


import com.example.projectmanagemnt.models.company.Customer;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController

public class AddCustomer {

    DB dbHelper = new DB();

    @PostMapping(path = "/customerPost", consumes = "application/json", produces = "application/json")
    public void add(@RequestBody Customer customer) {
        System.out.println(customer.getPassword());
        dbHelper.addCustomer(customer);
    }

    @PostMapping(path = "/getCustomerNameById")
    public List<String> getCustomerNameById(@RequestBody customersId customersId) {
        List<Long> list = customersId.getList();
        List<String> names = new LinkedList<>();

        list.forEach(aLong -> {
            names.add(dbHelper.getCustomerById(aLong));
        });

        return names;
    }

    @PostMapping(path = "/customerGet", consumes = "application/json", produces = "application/json")
    public Customer get(@RequestBody Customer customer) {
        System.out.println(customer.getPassword());
        Customer customer1 = new Customer();
        customer1.setId(1l);
        customer1.setName("hosssein");
        customer1.setLastName("shakeri");
        customer1.setEmail("shakryhsyn1@gmail.com");
        customer1.setPassword("customer");
        customer1.setUsername("customer");
        customer1.setPhoneNumber("0914405206persia");
        new DB().addCustomer(customer1);
        if (customer.getUsername().equals("customer") && customer.getPassword().equals("customer"))
            return customer1;

        return dbHelper.getCustomerByUserPas(customer.getUsername(), customer.getPassword());
    }

    @DeleteMapping(path = "/customerDelete", consumes = "application/json", produces = "application/json")
    public void delete(@RequestBody Customer customer) {
        System.out.println(customer.getCompanyId());
        dbHelper.deleteCustomer(customer);
    }

    @PutMapping(path = "/customerPut", consumes = "application/json", produces = "application/json")
    public void update(@RequestBody Customer customer) {
        System.out.println(customer.getCompanyId());
        dbHelper.upDate(customer);
    }

}
@Data
class customersId{
    List<Long> list ;
}
