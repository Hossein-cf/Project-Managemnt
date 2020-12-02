package com.example.projectmanagemnt.models.email;

import lombok.Data;

@Data
public class SendEmailModel {

    private String to;
    private String subject;
    private String description;
}
