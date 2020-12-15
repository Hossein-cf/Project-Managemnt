package com.example.projectmanagemnt.models.company;

import lombok.Data;
@Data
public class Customer {
    private Long id;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String username;
    private String password;
    private String email;
    private Long companyId;

    /*•	Id
•	Name
•	Last name
•	Phone number
•	User
•	Pass
•	Email

*/
}
