package com.example.projectmanagemnt.services;

import com.example.projectmanagemnt.DBHelper.DB;
import com.example.projectmanagemnt.models.Ticket;
import com.example.projectmanagemnt.models.company.Customer;
import com.example.projectmanagemnt.models.enums.TicketCondition;
import com.example.projectmanagemnt.models.enums.TicketPriority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Ticketing {


    @PostMapping("/addTicket")
    public void createTicket(@RequestBody Ticket ticket) {
        System.out.println("fuckkkkkkkkkkkkkkk");
        new DB().addTicket(ticket);

    }

    @PostMapping("/getTicketsForCustomer")
    public List<Ticket> getTicketsForCustomer(@RequestBody Customer customer) {

        return new DB().getTicketsForCustomer(customer.getId());

    }
    @PostMapping("/getTicketByID")
    public Ticket getTicketByID(@RequestBody Ticket ticket) {

        return new DB().getTicketById(ticket.getId());

    }
}
