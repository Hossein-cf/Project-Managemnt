package com.example.projectmanagemnt.models.company;

import com.example.projectmanagemnt.models.Task;
import com.example.projectmanagemnt.models.Ticket;
import com.example.projectmanagemnt.models.enums.ProjectCondition;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Project {

    private long id;
    private String subject;
    private String deadLine;
    private String document;
    private long managerId;
   // private List<Employee> employeesForProject;
    private List<Task> tasks;
    private List<Ticket> tickets;
    private ProjectCondition condition;
    private Date startTime;
    private long customerId;
    private String budget;
    private double satisfactionPercentage;//    درصد رضایت
    private long companyId;

/*•	Id
•	Subject
•	Dead line
•	Customer Document
•	Project manager
•	Array for agents (team members)
•	Array of tasks and for project
•	Condition (تمام شده / درحال انجام /شروع نشده	)
•	Start time
•	End time
•	Customer id
•	project budget
•	میزان رضایت
*/
}

