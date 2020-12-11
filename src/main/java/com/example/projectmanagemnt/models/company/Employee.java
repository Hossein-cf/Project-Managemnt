package com.example.projectmanagemnt.models.company;

import com.example.projectmanagemnt.models.Ticket;
import lombok.Data;

import java.util.List;

@Data
public class Employee {
    private long id;
    private String userName;
    private String password;
    private String fatherName;
    private String address;
    private String bornPlace;
    private String name;
    private String lastName;
    private String nationalNumber;
    private List<String> roleList;
    private String email;
    private String phoneNumber;
    private String homePhoneNumber;
    private List<Ticket> tickets;
    private String imageAddress;
    private long partId;
    private long companyId;



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