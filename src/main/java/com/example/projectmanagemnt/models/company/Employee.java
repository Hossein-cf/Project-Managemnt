package com.example.projectmanagemnt.models.company;

import com.example.projectmanagemnt.models.Ticket;

import java.util.List;

public class Employee {
    private long id;
    private String userName;
    private String password;
    private String name;
    private String lastName;
    private String nationalNumber;
    private String role;
    private String email;
    private String phoneNumber;
    private List<Ticket> tickets;
    private String imageAddress;
    private Part part;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalNumber() {
        return nationalNumber;
    }

    public void setNationalNumber(String nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    //    Name
//    Last name
//    Id
//    National number
//    roll
//            User
//    Pass
//            Email
//    Phone number
//    Home phone number
//            Address
//    ارایه ای از تیکت های بخش
//    ارایه ای از تیکت های مخصوص فرد
//    Profile image
//    بخش کارمندی

}