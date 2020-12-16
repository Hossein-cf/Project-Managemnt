package com.example.projectmanagemnt.services;

import com.example.projectmanagemnt.DBHelper.DB;
import com.example.projectmanagemnt.models.Ticket;
import com.example.projectmanagemnt.models.company.Customer;
import com.example.projectmanagemnt.models.company.Part;
import com.example.projectmanagemnt.models.enums.RollsInTicket;
import com.example.projectmanagemnt.models.enums.TicketCondition;
import com.example.projectmanagemnt.models.enums.TicketPriority;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
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

    @PostMapping("/getTicketsForPart")
    public List<Ticket> getTicketsForPart(@RequestBody Part part) {

        return new DB().getTicketsForPartOfCompany(new DB().getPartId(part.getName()));


    }

    @PostMapping("/getTicketsGeneratorIdName")
    public List<String> getTicketsDestinationIdName(@RequestBody Tickets tickets) {
        List<String> names = new LinkedList<>();
        tickets.getList().forEach(ticket -> {
            if (ticket.getGeneratorType().equals(RollsInTicket.COMPANY.value)){
                names.add(new DB().getCompanyById(ticket.getGeneratorId()).getName());
            }else  if (ticket.getGeneratorType().equals(RollsInTicket.CUSTOMER.value)){
                names.add(new DB().getCustomerById(ticket.getGeneratorId()));

            }else  if (ticket.getGeneratorType().equals(RollsInTicket.EMPLOYEE.value)){
                names.add(new DB().getEmployee(ticket.getGeneratorId()).getName());

            }else  if (ticket.getGeneratorType().equals(RollsInTicket.MANAGER.value)){
                names.add(new DB().getEmployee(ticket.getGeneratorId()).getName());

            }else  if (ticket.getGeneratorType().equals(RollsInTicket.PART.value)){
                names.add(new DB().getPartById(ticket.getGeneratorId()).getName());

            } if (ticket.getGeneratorType().equals(RollsInTicket.SYSTEM.value)){
                names.add("از طرف سیستم مرکزی");
            }
        });
//        return new DB().getTicketsForPartOfCompany(new DB().getPartId(part.getName()));
        return names;
    }
}
@Data
class Tickets{
    private List<Ticket> list;
}
