package com.example.projectmanagemnt.models.enums;

public enum ProjectCondition {
    NOT_STARTED("شروع نشده"),
    IN_PROGRESS("در حال انجام"),
    DONE("انجام شده");
    public String value;
    private ProjectCondition(String value){
        this.value=value;
    }

}
