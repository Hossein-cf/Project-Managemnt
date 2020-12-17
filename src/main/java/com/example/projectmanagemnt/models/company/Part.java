package com.example.projectmanagemnt.models.company;

import com.example.projectmanagemnt.models.Ticket;
import com.example.projectmanagemnt.models.enums.PartActivity;
import lombok.Data;

import java.util.List;

@Data
public class Part {
    private long id;
    private String name;
    private long adminId;
    private String description;
    private String createTime;
    private String username;
    private String password;
    private String partActivity=PartActivity.ACTIVE.value;
    private List<Employee> employeesForPart;
    private List<Ticket> tickets;
    private double satisfactionPercentage;//    درصد رضایت
    private String email;
    private long companyId;


    //    •	Id
//•	Name
//•	Admin id
//•	Description
//•	فعال/غیر فعال
//•	Array for agents
//•	Array for tickets
//•	درصد رضایت
//•	email

}
