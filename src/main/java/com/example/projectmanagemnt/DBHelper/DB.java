package com.example.projectmanagemnt.DBHelper;

import com.example.projectmanagemnt.models.*;
import com.example.projectmanagemnt.models.company.*;
import com.example.projectmanagemnt.models.email.ReceiveEmailModel;
import com.example.projectmanagemnt.models.enums.ProjectCondition;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class DB {
    public static long id = 1;
    public static LinkedList<ReceiveEmailModel> emails = new LinkedList<>();
    public static LinkedList<Employee_Project_mapping> employee_project_mappings = new LinkedList<>();
    public static LinkedList<Ticket> tickets = new LinkedList<>();
    public static LinkedList<Task> tasks = new LinkedList<>();
    public static LinkedList<Employee> employees = new LinkedList<>();
    public static LinkedList<Notification> notifications = new LinkedList<>();
    public static LinkedList<Customer> customers = new LinkedList<>();
    public static LinkedList<Project> projects = new LinkedList<>();
    public static LinkedList<Part> parts = new LinkedList<>();
    public static LinkedList<Dialog> dialogs = new LinkedList<>();
    public static LinkedList<Company> companies = new LinkedList<>();
    public static LinkedList<File> files = new LinkedList<>();

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }


    //files
    public void addFile(File file) {
        file.setId(id++);
        files.add(file);
    }

    public File addFileByI(long id) {
        AtomicReference<File> file1 = new AtomicReference<>(new File());
        files.forEach(file -> {
            if (file.getId() == id)
                file1.set(file);

        });
        return file1.get();
    }


    // email
    public void addEmail(ReceiveEmailModel email) {

        emails.forEach(emailModel -> {
            if (email.equals(emailModel)) {
                return;
            }

        });
        email.setId(id++);
        emails.add(email);
    }

    public ReceiveEmailModel getEmailById(long emailId) {
        ReceiveEmailModel model1 = emails.getFirst();
        emails.removeIf(emailModel -> emailModel.getId() == emailId);
        AtomicReference<ReceiveEmailModel> model = new AtomicReference<>();
        emails.forEach(emailModel -> {
            if (emailModel.getId() == emailId)
                model.set(emailModel);
        });
        return model.get();

    }

    //ticket
    public void addTicket(Ticket ticket) {
        ticket.setId(id++);
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
        tickets.forEach(task -> {
            if (task.getGeneratorId() == partId || task.getDestinationId() == partId)
                list.add(task);
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

    public List<Ticket> getTicketsForCustomer(long customerId) {

        List<Ticket> list = new LinkedList<>();
        tickets.forEach(task -> {
            if (task.getGeneratorId() == customerId || task.getDestinationId() == customerId)
                list.add(task);
        });
        return list;
    }

    public List getAllTickets() {
        return tickets;
    }

    //task
    public void addTask(Task task) {
        task.setId(id++);
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
    public void deleteEmployee(Employee employee) {
        companies.removeIf(employee1 -> employee1.getId() == employee.getId());

    }

    public Employee getEmployee(long id) {
        AtomicReference<Employee> employee = new AtomicReference<>();
        employees.forEach(e -> {
            if (e.getId() == id)
                employee.set(e);
        });
        return employee.get();
    }

    public Employee getEmployeeByUserPass(String user, String pass) {
        AtomicReference<Employee> employee = new AtomicReference<>(new Employee());
        employees.forEach(e -> {
            if (e.getUsername().equals(user) && e.getPassword().equals(pass)) {
                employee.set(e);
            }
        });
        return employee.get();
    }

    public boolean isManagerForProject(long managerId) {

        AtomicBoolean flag = new AtomicBoolean(false);
        projects.forEach(e -> {
            if (e.getManagerId() == managerId)
                flag.set(true);
        });
        return flag.get();
    }

    public Employee getPartAdmin(String user, String pass) {
        List<Part> parts1 = new LinkedList<>();
        parts.forEach(e -> {
            if (e.getUsername().equals(user) && e.getPassword().equals(pass))
                parts1.add(e);
        });
        if (parts1.size() != 0)
            return getEmployee(parts1.get(0).getAdminId());
        return null;
    }

    public void addEmployee(Employee employee) {
        employee.setId(id++);
        employees.add(employee);
    }

    public List<Employee> getEmployeesForProject(long projectId) {
        List<Long> employeeIds = getEmployeeIdFromMapping(projectId);
        List<Employee> list = new LinkedList<>();
        employeeIds.forEach(item ->
                list.add(getEmployee(item))
        );
        return list;
    }

    public List<Employee> getEmployeesDontHavePart() {
        List<Employee> list = new LinkedList<>();
        employees.forEach(item -> {
            if (item.getPartId() == 0)
                list.add(item);
        });
        return list;
    }

    public List<Employee> getEmployeesForCompany(long companyId) {

        List<Employee> list = new LinkedList<>();

        employees.forEach(item -> {
            if (item.getCompanyId() == companyId)
                list.add(item);
        });
        return list;
    }

    public List<Employee> getEmployeesForPart(long partId) {

        List<Employee> list = new LinkedList<>();

        employees.forEach(item -> {
            if (item.getPartId() == partId)
                list.add(item);
        });
        return list;
    }

    public List<Long> getEmployeeIdFromMapping(long projectId) {
        List<Long> list = new LinkedList<>();
        employee_project_mappings.forEach(employee_project_mapping -> {
            if (employee_project_mapping.getProjectId() == projectId)
                list.add(employee_project_mapping.getEmployeeId());
        });
        return list;
    }

    public void updateEmployee(Employee employee) {
        employees.removeIf(employee1 -> employee1.getId() == employee.getId());
        employees.add(employee);
    }

    //customer
    public void deleteCustomer(Customer customer) {
        companies.removeIf(customer1 -> customer1.getId() == customer.getId());

    }

    public void addCustomer(Customer customer) {
        customer.setId(id++);
        customers.add(customer);

    }

    public void upDate(Customer customer) {
        customers.removeIf(customer1 -> customer1.getId() == customer.getId());
        customers.add(customer);
    }

    public Customer getCustomerByUserPas(String user, String pass) {
        AtomicReference<Customer> customer = new AtomicReference<>(new Customer());
        customers.forEach(customer1 -> {
            if (customer1.getUsername().equals(user) && customer1.getPassword().equals(pass))
                customer.set(customer1);
        });
        return customer.get();

    }

    public List<Customer> getAllCustomersForCompany(long companyId) {
        List<Customer> list = new LinkedList<>();
        customers.forEach(customer1 -> {
            if (customer1.getCompanyId() == companyId)
                list.add(customer1);
        });
        return list;

    }

    public String getCustomerById(long customerId) {
        AtomicReference<String> list = new AtomicReference<>();
        customers.forEach(customer1 -> {
            if (customer1.getId() == customerId)
                list.set(customer1.getName());
        });

        return list.get();

    }

    //
//project

    public void deleteProject(Project project) {
        companies.removeIf(project1 -> project1.getId() == project.getId());

    }

    public void addProject(Project project) {
        project.setId(id++);
        projects.add(project);
    }

    public List<Project> getProjectsForCustomer(long customerId) {
        List<Project> list = new LinkedList<>();
        projects.forEach(project1 -> {
            if (project1.getCustomerId() == customerId)
                list.add(project1);
        });
        return list;
    }

    public List<Project> getProjectsForManager(long managerID) {
        List<Project> list = new LinkedList<>();
        projects.forEach(project1 -> {
            if (project1.getManagerId() == managerID)
                list.add(project1);
        });
        return list;
    }

    public void upDateProject(Project project) {
        projects.removeIf(project1 -> project1.getId() == project.getId());
        projects.add(project);
    }

    public List<Project> getProjectForCompany(long companyId) {
        List<Project> list = new LinkedList<>();
        projects.forEach(project -> {
            if (project.getCompanyId() == companyId)
                list.add(project);
        });
        return list;
    }

    public Project getProjectById(long id) {
        AtomicReference<Project> list = new AtomicReference<>(new Project());
        projects.forEach(project -> {
            if (project.getId() == id)
                list.set(project);
        });
        return list.get();
    }

    public List<Project> getNOT_STARTEDProjects() {
        List<Project> list = new LinkedList<>();
        projects.forEach(project -> {
            if (project.getCondition().equals(ProjectCondition.NOT_STARTED.value))
                list.add(project);
        });
        return list;
    }

    public List<Project> getSTARTEDProjects() {
        List<Project> list = new LinkedList<>();
        projects.forEach(project -> {
            if (project.getCondition().equals(ProjectCondition.IN_PROGRESS.value))
                list.add(project);
        });
        return list;
    }

    //Employee_Project-Mapping
    public long getNumberOfEmployeeInCurrentProject(long projectId) {
        return employee_project_mappings.stream().filter(employee_project_mapping -> employee_project_mapping.getProjectId() == projectId).count();
    }

    //part
    public void deletePart(Part part) {
        companies.removeIf(part1 -> part1.getId() == part.getId());

    }


    public void addPart(Part part) {
        part.setId(id++);
        parts.add(part);
    }

    public long getPartId(String partName) {
        AtomicReference<Part> part1 = new AtomicReference<>(new Part());
        parts.forEach(part -> {
            if (part.getName().contains(partName))
                part1.set(part);
        });
        return part1.get().getId();


    }

    public boolean getCurrentAdminForPart(String partName, long adminId) {
        List<Part> list = new LinkedList<>();
        parts.forEach(part -> {
            if (part.getName().contains(partName) && part.getAdminId() == adminId)
                list.add(part);
        });

        return list.size() > 0;


    }

    public Part getPartById(long partId) {
        AtomicReference<Part> part1 = new AtomicReference<>(new Part());
        parts.forEach(part -> {
            if (part.getId() == partId)
                part1.set(part);
        });
        return part1.get();
    }

    public Part getPartByName(String name) {
        AtomicReference<Part> part1 = new AtomicReference<>(new Part());
        parts.forEach(part -> {
            if (part.getName().equals(name))
                part1.set(part);
        });
        return part1.get();
    }

    public void updatePart(Part part) {
        parts.removeIf(part1 -> part1.getId() == part.getId());
        parts.add(part);
    }

    public List<Part> getAllPartsForCompany(long companyId) {
        List<Part> list = new LinkedList<>();
        parts.forEach(part -> {
            if (part.getCompanyId() == companyId)
                list.add(part);
        });
        return list;
    }


    //dialog
    public void addDialog(Dialog dialog) {
        dialog.setId(id++);
        dialogs.add(dialog);
    }

    public List<Dialog> getDialogsForTask(long taskId) {
        List<Dialog> list = new LinkedList<>();
        dialogs.forEach(dialog -> {
            if (dialog.getTaskId() == taskId)
                list.add(dialog);
        });
        return list;
    }

    public List<Dialog> getDialogsForTiket(long ticketId) {
        List<Dialog> list = new LinkedList<>();
        dialogs.forEach(dialog -> {
            if (dialog.getTaskId() == ticketId)
                list.add(dialog);
        });
        return list;
    }

    //company
    public void deleteCompany(Company company) {
        companies.removeIf(company1 -> company1.getId() == company.getId());

    }

    public void updateCompany(Company company) {
        companies.removeIf(company1 -> company1.getId() == company.getId());
        companies.add(company);
    }

    public Company getCompanyById(long id) {
        AtomicReference<Company> company1 = new AtomicReference<>(new Company());
        companies.forEach(company -> {
            if (company.getId() == id) {
                company1.set(company);
            }
        });
        return company1.get();
    }

    public void addCompany(Company company) {
        company.setId(id++);
        companies.add(company);
    }

    public Company getCompany(String userName, String pass) {
        AtomicReference<Company> company = new AtomicReference<>(new Company());
        companies.forEach(company1 -> {
            if (company1.getUsername().equals(userName) && company1.getPassword().equals(pass))
                company.set(company1);
        });
        return company.get();
    }

    public List<Company> getAllCompanies() {
        return companies;
    }

    //TODO notification

}
