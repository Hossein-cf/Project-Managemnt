package com.example.projectmanagemnt.models.enums;

public enum EmployeeCondition {
    BUSY("مشغول"),
    WAITING_FOR_PROJECT("در انتظار پروژه");
    public String value;

    private EmployeeCondition(String value) {
        this.value = value;
    }
}
