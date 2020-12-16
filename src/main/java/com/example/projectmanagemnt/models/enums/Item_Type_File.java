package com.example.projectmanagemnt.models.enums;

public enum Item_Type_File {
    TICKET("Ticket"),
    TASK("Task"),
    PROJECT("Project"),
    DIALOG("Dialog");
    public String value;

    private Item_Type_File(String value) {
        this.value = value;
    }
}
