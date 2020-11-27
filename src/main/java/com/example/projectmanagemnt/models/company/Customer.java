package com.example.projectmanagemnt.models.company;

import com.example.projectmanagemnt.models.Ticket;
import org.springframework.scheduling.support.SimpleTriggerContext;

import java.util.List;

public class Customer {
    private long id;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String userName;
    private String password;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*•	Id
•	Name
•	Last name
•	Phone number
•	User
•	Pass
•	Email

*/
}
