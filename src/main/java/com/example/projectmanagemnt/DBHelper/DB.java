package com.example.projectmanagemnt.DBHelper;

import com.example.projectmanagemnt.models.Notification;
import com.example.projectmanagemnt.models.Task;
import com.example.projectmanagemnt.models.Ticket;
import com.example.projectmanagemnt.models.company.Employee;
import com.example.projectmanagemnt.models.company.Employee_Project_mapping;
import com.example.projectmanagemnt.models.email.ReceiveEmailModel;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class DB {
    public static LinkedList<ReceiveEmailModel> emails = new LinkedList<>();
    public static LinkedList<Employee_Project_mapping> employee_project_mappings = new LinkedList<>();
    public static LinkedList<Ticket> tickets = new LinkedList<>();
    public static LinkedList<Task> tasks = new LinkedList<>();
    public static LinkedList<Employee> employees = new LinkedList<>();
    public static LinkedList<Notification> notifications = new LinkedList<>();

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }
// email
    public void addEmail(ReceiveEmailModel email){

        emails.forEach(emailModel -> {
            if (email.equals(emailModel)) {
                return;
            }

        });
        email.setId(emails.size());
        emails.add(email);
    }
    public ReceiveEmailModel getEmailById(long emailId){
        AtomicReference<ReceiveEmailModel> model = new AtomicReference<>();
        emails.forEach(emailModel -> {
            if (emailModel.getId() == emailId )
                model.set(emailModel);
        });
        return model.get();
    }

    //ticket
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public List<Ticket> getAllTicketForCompany(long companyId) {
        List<Ticket> list = new LinkedList<>();
        tickets.forEach(ticket -> {
            if (ticket.getCompanyId() == companyId)
                list.add(ticket);
        });
        return list;
    }

    public Ticket getTicketById(long id) {
        AtomicReference<Ticket> ticket = new AtomicReference<>(new Ticket());
        tickets.forEach(ticket1 -> {
            if (ticket1.getId() == id)
                ticket.set(ticket1);
        });
        return ticket.get();
    }

    public List<Ticket> getTicketsForPartOfCompany(long partId) {
        List<Ticket> list = new LinkedList<>();

        tickets.forEach(ticket -> {
            if (ticket.getPartId() == partId)
                list.add(ticket);
        });

        return list;
    }

    public List<Ticket> getTicketsForDestination(long DestinationId) {
        List<Ticket> list = new LinkedList<>();
        tickets.forEach(ticket -> {
            if (ticket.getDestinationId() == DestinationId)
                list.add(ticket);
        });

        return list;
    }

    public List getAllTickets() {
        return tickets;
    }

    //task
    public void addTask(Task task) {
        tasks.add(task);
    }

    public Task getTaskById(long id) {
        List<Task> list = new LinkedList<>();
        tasks.forEach(task1 -> {
            if (task1.getId() == id)
                list.add(task1);
        });
        return list.get(0);
    }

//    public List<Task> getTasksForPart(long partId) {
//        List<Task> list = new LinkedList<>();
//        tasks.forEach(task -> {
//            if (task.getPartId() == partId)
//                list.add(task);
//        });
//        return list;
//    }

    public List<Task> getTasksForDestination(long destinationId) {

        List<Task> list = new LinkedList<>();
        tasks.forEach(task -> {
            if (task.getDestinationId() == destinationId)
                list.add(task);
        });
        return list;
    }

    private List<Task> getTasksOfProject(long projectId) {
        List<Task> list = new LinkedList<>();
        tasks.forEach(task -> {
            if (task.getProjectId() == projectId)
                list.add(task);
        });
        return list;
    }

    //employee
    public Employee getEmployee(long id) {
        AtomicReference<Employee> employee = new AtomicReference<>();
        employees.forEach(e -> {
            if (e.getId() == id)
                employee.set(e);
        });
        return employee.get();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }


}
