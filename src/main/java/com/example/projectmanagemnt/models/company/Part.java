package com.example.projectmanagemnt.models.company;

import com.example.projectmanagemnt.models.Ticket;

import java.util.List;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public List<Employee> getEmployeesForPart() {
        return employeesForPart;
    }

    public void setEmployeesForPart(List<Employee> employeesForPart) {
        this.employeesForPart = employeesForPart;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public double getSatisfactionPercentage() {
        return satisfactionPercentage;
    }

    public void setSatisfactionPercentage(double satisfactionPercentage) {
        this.satisfactionPercentage = satisfactionPercentage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
