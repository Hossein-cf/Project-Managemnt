package com.example.projectmanagemnt.models.enums;

public enum PartActivity {
    ACTIVE(1),
    INACTIVE(0);
    private int value;

    private PartActivity(int value) {
        this.value = value;
    }
}
