package com.example.projectmanagemnt.models;

import com.example.projectmanagemnt.models.company.Company;
import com.example.projectmanagemnt.models.company.Part;
import com.example.projectmanagemnt.models.enums.PartActivity;
import lombok.Data;

import java.util.List;

@Data
public class SystemProperties {
    private String email;
    private List<Company>companies;
    private List<Ticket> ticketsFromCompanies;

}
