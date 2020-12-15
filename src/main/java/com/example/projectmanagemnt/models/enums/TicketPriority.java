package com.example.projectmanagemnt.models.enums;

import com.example.projectmanagemnt.models.Ticket;

public enum TicketPriority {
    Critical("ضروری"),
    High("بالا"),
    Normal("متوسط"),
    Low("کم");
    public final String value;

    private TicketPriority(String value) {
        this.value = value;

    }

}
