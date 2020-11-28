package com.example.projectmanagemnt.models.company;

import lombok.Data;
@Data
public class Customer {
    private long id;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String userName;
    private String password;
    private String email;
    private long companyId;

    /*•	Id
•	Name
•	Last name
•	Phone number
•	User
•	Pass
•	Email

*/
}
