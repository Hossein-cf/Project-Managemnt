package com.example.projectmanagemnt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class MainController {
    //system
    @RequestMapping("/")
    public String index() {
        return "login_System";
    }

    @RequestMapping("/systemDashboard")
    public String goToSystemDashboard() {
        return "Dashbord_System";
    }

    @RequestMapping("/SystemMembers_System")
    public String goToSystemMembers_System() {
        return "SystemMembers_System";
    }

    @RequestMapping("/AddCompany_System")
    public String goToAddCompany_System() {

        return "AddCompany_System";
    }

    //company
    @RequestMapping("/Dashbord_Company")
    public String goToDashbord_Company() {

        return "Dashbord_Company";
    }

    @RequestMapping("/Login_Company")
    public String goToLogin_Company() {

        return "login_Company";
    }

    @RequestMapping("/AddDepartment_Company")
    public String goToAddDepartment_Company() {

        return "AddDepartment_Company";
    }
    @RequestMapping("/TicketPage_Company")
    public String goToTicketPage_Company() {

        return "TicketPage_Company";
    }

    @RequestMapping("/AddEmployee_Company")
    public String goToAddEmployee_Company() {

        return "AddEmployee_Company";
    }

    @RequestMapping("/Departments_Company")
    public String goToDepartmentsList() {

        return "Departments_Company";
    }

    @RequestMapping("/TicketsList_Company")
    public String goToTicketsListForCompany() {

        return "TicketsList_Company";
    }

    @RequestMapping("/CreateTicket_Company")
    public String goToCreateTicket_Company() {

        return "CreateTicket_Company";
    }

    @RequestMapping("/customers_Company")
    public String goToCustomers_Company() {

        return "customers_Company";
    }

    //Employee
    @RequestMapping("/dahsbord_Employee")
    public String goToDahsbord_Employee() {

        return "dahsbord_Employee";
    }

    @RequestMapping("/projectsList_Employee")
    public String goToProjectsList_Employee() {

        return "projectsList_Employee";
    }

    @RequestMapping("/emailsInbox_Employee")
    public String goToEmailsInbox_Employee() {

        return "emailsInbox_Employee";
    }

    @RequestMapping("/createTicket_Employee")
    public String goToCreateTicket_Employee() {

        return "createTicket_Employee";
    }

    @RequestMapping("/TicketsList_Employee")
    public String goToTicketsList_Employee() {

        return "TicketsList_Employee";
    }

    //Manager
    @RequestMapping("/dahsbord_Manager")
    public String goToDahsbord_Manager() {

        return "dahsbord_Manager";
    }

    @RequestMapping("/projectsList_Manager")
    public String goToProjectsList_Manager() {

        return "projectsList_Manager";
    }
    @RequestMapping("/projectPage_ManagerprojectPage_Manager")
    public String goToprojectPage_Manager() {

        return "projectPage_Manager";
    }

    @RequestMapping("/TicketsList_Manager")
    public String goToTicketsList_Manager() {

        return "TicketsList_Manager";
    }

    @RequestMapping("/createTicket_Manager")
    public String goToCreateTicket_Manager() {

        return "createTicket_Manager";
    }

    @RequestMapping("/emailsInbox_Manager")
    public String goToEmailsInbox_Manager() {

        return "emailsInbox_Manager";
    }

    //Customer
    //TODO side bar in customer dashboard don't have a dashboard item
    @RequestMapping("/dashbord_Customer")
    public String goToDashbord_Customer() {

        return "dashbord_Customer";
    }

    @RequestMapping("/Login_Customer")
    public String goToCustomerLogin_Customer() {

        return "customerLogin_Customer";
    }

    @RequestMapping("/projectsList_Customer")
    public String goToProjectsList_Customer() {

        return "projectsList_Customer";
    }

    @RequestMapping("/TicketLists_Customer")
    public String goToTicketLists_Customer() {

        return "TicketLists_Customer";
    }

    @RequestMapping("/CreateTicket_Customer")
    public String goToCreateTicket_Customer() {

        return "CreateTicket_Customer";
    }

    @RequestMapping("/requestForProjects_Customer")
    public String goToRequestForProjects_Customer() {

        return "requestForProjects_Customer";
    }

    @RequestMapping("/projectPage_Customer")
    public String goToProjectPage_Customer() {

        return "projectPage_Customer";
    }

    @RequestMapping("/TicketPage_Customer")
    public String goToTicketPage_Customer() {

        return "TicketPage_Customer";
    }

    //  admin
    @RequestMapping("/dahsbord_Admin")
    public String goToDahsbord_Admin() {

        return "dahsbord_Admin";
    }
    @RequestMapping("/ProjectRequestList_Admin")
    public String goToProjectRequestList_Admin() {

        return "ProjectRequestList_Admin";
    }

    @RequestMapping("/employeesList_Admin")
    public String goToEmployeesList_Admin() {

        return "employeesList_Admin";
    }

    @RequestMapping("/projectList_Admin")
    public String goToProjectList_Admin() {

        return "projectList_Admin";
    }

    @RequestMapping("/createProject_Admin")
    public String goToCreateProject_Admin() {

        return "createProject_Admin";
    }

    @RequestMapping("/createTicket_Admin")
    public String goToCreateTicket_Admin() {

        return "createTicket_Admin";
    }

    @RequestMapping("/ticketsList_Admin")
    public String goToTicketsList_Admin() {

        return "ticketsList_Admin";
    }

    @RequestMapping("/44")
    public String uploadPage() {

        return "uploadview";
    }


    @RequestMapping("/Login_Admion")
    public String goToLogin_Admion(){
        return "login_Admin";
    }



    //upload
   // public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/static/uploads";


}
