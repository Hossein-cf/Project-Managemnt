package com.example.projectmanagemnt.models.company;

import com.example.projectmanagemnt.models.Ticket;

import javax.swing.*;
import java.util.Date;
import java.util.List;

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

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public double getSatisfactionPercentage() {
        return satisfactionPercentage;
    }

    public void setSatisfactionPercentage(double satisfactionPercentage) {
        this.satisfactionPercentage = satisfactionPercentage;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
