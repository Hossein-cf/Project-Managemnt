package com.example.projectmanagemnt.models.enums;

import com.example.projectmanagemnt.models.Ticket;

public enum TicketPriority {
    Critical(4),
    High(3),
    Normal(2),
    Low(1);
    private int value;

    private TicketPriority(int value) {
        this.value = value;

    }
}
