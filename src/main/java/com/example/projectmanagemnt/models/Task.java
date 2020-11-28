package com.example.projectmanagemnt.models;

import lombok.Data;

import java.util.Date;

@Data
public class Task {
    private long id;
    private long projectId;
    private Date crateTime;
    private Date endTime;
    private TaskCondition condition;
    private long generatorId;
    private String title;
    private String description;
    private String fileAddress;
    private long destinationId;
    private long partId;
    private long companyId;

    /*•	Id
•	Project id
•	Array of dialog
•	Create time
•	End time
•	Condition (انجام شده / در حال انجام)
•	Generator
•	Title
•	Description
•	Employee id
•	File address
•
*/
}
enum TaskCondition {
}

