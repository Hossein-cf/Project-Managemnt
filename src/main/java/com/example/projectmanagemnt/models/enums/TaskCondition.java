package com.example.projectmanagemnt.models.enums;

public enum TaskCondition {

    OPEN(0),
    IN_PROGRESS(1),
    FIXED(2),
    VERIFIED(3);

    private int value;

    private TaskCondition(int value) {
        this.value = value;
    }
}
