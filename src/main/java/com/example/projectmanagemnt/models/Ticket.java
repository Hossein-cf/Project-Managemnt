package com.example.projectmanagemnt.models;

import com.example.projectmanagemnt.models.enums.TicketCondition;
import com.example.projectmanagemnt.models.enums.TicketPriority;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class Ticket {

    private long id;
    private long companyId;
    private long partId;
    private String title;
    private TicketPriority ticketPriority;
    private String description;
    private long destinationId;
    private long generatorId;
    private long employeeId;
    private long customerId;
    private long systemId;
    // (to) (میتوانیم درخواست خود را به بخش یا یک نفر مخصوص اسال کنیم)
//    If send to admin just select the admin address else if send to part just select the part else if send to agent just select the part > agent id
//    If we want send ticket to agent and we want to does not show to part
    private String fileAddress;
    private List<Dialog> dialogs;
    private Date generateTime;
    private Date lastUpdateTime;
    private TicketCondition condition;
//•	Condition (بسته شده / درحال انجام /باز/در انتظار مشتری	( اگر مشتری تا 48 ساعت پاسخ ندهد تیکت بسته میشود



}

