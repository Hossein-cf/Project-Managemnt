package com.example.projectmanagemnt.models.email;

import lombok.Data;

import java.util.Objects;

@Data
public class ReceiveEmailModel {
    private long id;
    private String from;
    private String subject;
    private String description;


    @Override
    public boolean equals(Object o) {
        ReceiveEmailModel model = (ReceiveEmailModel) o;
        if (this.description == model.description && this.from == model.from && this.subject == model.subject)
            return true;
        return false;
    }
}

