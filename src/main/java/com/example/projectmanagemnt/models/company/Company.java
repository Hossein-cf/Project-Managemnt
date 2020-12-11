package com.example.projectmanagemnt.models.company;

import com.example.projectmanagemnt.models.Ticket;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class Company {
    private long id;
    private String name;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String createTime;
    private String validityDate;
    private List<Part> parts;
    private double satisfactionPercentage;//    درصد رضایت
    private List<Ticket> tickets;


}
