package com.example.projectmanagemnt.models.enums;

public enum TicketCondition {

    NO_ANSWER("پاسخ داده نشده"),
    IN_PROGRESS(" در دست بررسی"),
    CLOSED("بسته شده"),
    WAiTING_FOR_ANSWER(" در انتظار پاسخ ");

    public String value;

    private TicketCondition(String  value) {

        this.value = value;
    }


}
