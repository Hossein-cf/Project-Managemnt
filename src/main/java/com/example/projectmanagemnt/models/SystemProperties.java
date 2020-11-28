package com.example.projectmanagemnt.models;

import com.example.projectmanagemnt.models.company.Company;
import lombok.Data;

import java.util.List;

@Data
public class SystemProperties {
    private String email;
    private List<Company>companies;
    private List<Ticket> ticketsFromCompanies;


}
