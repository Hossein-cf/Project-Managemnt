package com.example.projectmanagemnt.models;

import java.util.Date;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public Date getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(Date crateTime) {
        this.crateTime = crateTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public TaskCondition getCondition() {
        return condition;
    }

    public void setCondition(TaskCondition condition) {
        this.condition = condition;
    }

    public long getGeneratorId() {
        return generatorId;
    }

    public void setGeneratorId(long generatorId) {
        this.generatorId = generatorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileAddress() {
        return fileAddress;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    public long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(long destinationId) {
        this.destinationId = destinationId;
    }

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
