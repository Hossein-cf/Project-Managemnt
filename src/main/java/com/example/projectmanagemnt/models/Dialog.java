package com.example.projectmanagemnt.models;

import java.util.Date;

public class Dialog {
    private long id;
    private long generatorId;
    private long taskId;
    private long ticketId;
    private Date generateTime;
    private String text;
    private String fileAddress;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGeneratorId() {
        return generatorId;
    }

    public void setGeneratorId(long generatorId) {
        this.generatorId = generatorId;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public Date getGenerateTime() {
        return generateTime;
    }

    public void setGenerateTime(Date generateTime) {
        this.generateTime = generateTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFileAddress() {
        return fileAddress;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
    }
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
