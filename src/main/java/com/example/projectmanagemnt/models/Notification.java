package com.example.projectmanagemnt.models;

import lombok.Data;

@Data
public class Notification {
    private long id;
    private String text;
    private String title;
    private long generatorId;
    private long destinationId;
    private long companyId;

    /*•	Id
•	Text
•	Title
•	Generator (from)
•	Destination (to)
*/
}
