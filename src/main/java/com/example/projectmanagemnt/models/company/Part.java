package com.example.projectmanagemnt.models.company;

import com.example.projectmanagemnt.models.Ticket;
import lombok.Data;

import java.util.List;

@Data
public class Part {
    private long id;
    private String name;
    private Long adminId;
    private String description;
    private Activity activity;
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
enum Activity {
}
