package com.example.projectmanagemnt.models;

import com.example.projectmanagemnt.models.company.Company;

import java.util.List;

public class SystemProperties {
    private String email;
    private List<Company>companies;
    private List<Ticket> ticketsFromCompanies;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public List<Ticket> getTicketsFromCompanies() {
        return ticketsFromCompanies;
    }

    public void setTicketsFromCompanies(List<Ticket> ticketsFromCompanies) {
        this.ticketsFromCompanies = ticketsFromCompanies;
    }
}
