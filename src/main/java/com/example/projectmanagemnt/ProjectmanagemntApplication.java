package com.example.projectmanagemnt;

import com.example.projectmanagemnt.controllers.FileUploadController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication

public class ProjectmanagemntApplication {

    public static void main(String[] args) {
        System.out.println( System.getProperty("user.dir") + "/src/main/resources/templates/company%20dashboard/Pages/login_System.html");
        new File(FileUploadController.uploadDirectory).mkdir();
        SpringApplication.run(ProjectmanagemntApplication.class, args);
    }

}
