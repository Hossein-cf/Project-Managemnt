package com.example.projectmanagemnt.models.company;

import com.example.projectmanagemnt.models.ProjectCondition;
import com.example.projectmanagemnt.models.Task;
import com.example.projectmanagemnt.models.Ticket;

import java.util.Date;
import java.util.List;

public class Project {

    private long id;
    private String subject;
    private String deadLine;
    private String document;
    private Employee manager;
    private List<Employee> employeesForProject;
    private List<Task> tasks;
    private List<Ticket> tickets;
    private ProjectCondition condition;
    private Date startTime;
    private long customerId;
    private String budget;
    private double satisfactionPercentage;//    درصد رضایت

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public List<Employee> getEmployeesForProject() {
        return employeesForProject;
    }

    public void setEmployeesForProject(List<Employee> employeesForProject) {
        this.employeesForProject = employeesForProject;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public ProjectCondition getCondition() {
        return condition;
    }

    public void setCondition(ProjectCondition condition) {
        this.condition = condition;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public double getSatisfactionPercentage() {
        return satisfactionPercentage;
    }

    public void setSatisfactionPercentage(double satisfactionPercentage) {
        this.satisfactionPercentage = satisfactionPercentage;
    }
/*•	Id
•	Subject
•	Dead line
•	Customer Document
•	Project manager
•	Array for agents (team members)
•	Array of tasks and for project
•	Condition (تمام شده / درحال انجام /شروع نشده	)
•	Start time
•	End time
•	Customer id
•	project budget
•	میزان رضایت
*/
}
