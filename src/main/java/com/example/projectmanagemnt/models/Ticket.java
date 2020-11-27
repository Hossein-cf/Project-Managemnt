package com.example.projectmanagemnt.models;

import java.util.Date;
import java.util.List;

public class Ticket {

    private long id;
    private String title;
    private Priority priority;
    private String description;
    private long generatorId;
    private long destinationId;
    // (to) (میتوانیم درخواست خود را به بخش یا یک نفر مخصوص ارسال کنیم)
//    If send to admin just select the admin address else if send to part just select the part else if send to agent just select the part > agent id
//    If we want send ticket to agent and we want to does not show to part
    private String fileAddress;
    private List<Dialog> dialogs;
    private Date generateTime;
    private Date lastUpdateTime;
    private TicketCondition condition;
//•	Condition (بسته شده / درحال انجام /باز/در انتظار مشتری	( اگر مشتری تا 48 ساعت پاسخ ندهد تیکت بسته میشود

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getGeneratorId() {
        return generatorId;
    }

    public void setGeneratorId(long generatorId) {
        this.generatorId = generatorId;
    }

    public long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(long destinationId) {
        this.destinationId = destinationId;
    }

    public String getFileAddress() {
        return fileAddress;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    public List<Dialog> getDialogs() {
        return dialogs;
    }

    public void setDialogs(List<Dialog> dialogs) {
        this.dialogs = dialogs;
    }

    public Date getGenerateTime() {
        return generateTime;
    }

    public void setGenerateTime(Date generateTime) {
        this.generateTime = generateTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public TicketCondition getCondition() {
        return condition;
    }

    public void setCondition(TicketCondition condition) {
        this.condition = condition;
    }
}
