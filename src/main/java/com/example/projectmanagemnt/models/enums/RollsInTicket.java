package com.example.projectmanagemnt.models.enums;

public enum RollsInTicket {
    EMPLOYEE("کارمند"),
    PART("بخش"),
    CUSTOMER("مشتری"),
    COMPANY("شرکت"),
    SYSTEM("سیستم"),
    MANAGER("مدیر پروژه");

    public String value;
    private RollsInTicket(String value) {
        this.value = value;
    }


}
