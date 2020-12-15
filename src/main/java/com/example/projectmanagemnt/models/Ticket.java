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
//    private Long partId;
    private String subject;
    private String ticketPriority;
    private String description;
    private long destinationId;
    private long generatorId;
    private String generatorType;
    private String destinationType;
//    private Long employeeId;
//    private Long customerId;
//    private Long systemId;
    // (to) (میتوانیم درخواست خود را به بخش یا یک نفر مخصوص اسال کنیم)
//    If send to admin just select the admin address else if send to part just select the part else if send to agent just select the part > agent id
//    If we want send ticket to agent and we want to does not show to part
    private String fileAddress;
    private List<Dialog> dialogs;
    private String generateTime;
    private String lastUpdateTime;
    private String condition = TicketCondition.NO_ANSWER.value;
//•	Condition (بسته شده / درحال انجام /باز/در انتظار مشتری	( اگر مشتری تا 48 ساعت پاسخ ندهد تیکت بسته میشود


}

