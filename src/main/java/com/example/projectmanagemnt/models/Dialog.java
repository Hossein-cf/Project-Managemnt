package com.example.projectmanagemnt.models;

import lombok.Data;

import java.util.Date;
@Data
public class Dialog {

    private long id;
    private long generatorId;
    private long taskId;
    private long ticketId;
    private Date generateTime;
    private String text;
    private String fileAddress;
    private long companyId;


    /*•	Id
•	Generator
•	Task id
•	Generate Time
•	Ticket id
•	Text
•	File address
•
*/
}
