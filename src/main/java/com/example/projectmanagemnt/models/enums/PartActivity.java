package com.example.projectmanagemnt.models.enums;

public enum PartActivity {
    ACTIVE("فعال"),
    INACTIVE("غیر فعال");
    public String value;

    private PartActivity(String value) {
        this.value = value;
    }
}
