package com.example.projectmanagemnt.models.company;

import com.example.projectmanagemnt.models.Ticket;
import lombok.Data;


import java.util.Date;
import java.util.List;
@Data
public class Company {
    private long id;
    private String name;
    private String Username;
    private String Password;
    private String Email;
    private Date createTime;
    private Date validityDate;
    private List<Part> parts;
    private double satisfactionPercentage;//    درصد رضایت
    private List<Ticket> tickets;

}
