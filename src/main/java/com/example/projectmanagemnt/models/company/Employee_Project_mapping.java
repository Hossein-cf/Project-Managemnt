package com.example.projectmanagemnt.models.company;

import lombok.Data;

@Data
public class Employee_Project_mapping {
    private long id;
    private long employeeId;
    private long projectId;
}
