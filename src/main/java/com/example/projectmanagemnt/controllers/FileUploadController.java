package com.example.projectmanagemnt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileUploadController {
    public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

    @RequestMapping("/")
    public String uploadPage(Model model) {

        return "uploadview";
    }

    @RequestMapping("/upload")
    public String upload(Model model, @RequestParam("files") MultipartFile files) {
        StringBuilder fileNames = new StringBuilder();
        System.out.println(files.getSize());


        //  for (MultipartFile file : files) {
        Path fileNameAndPath = Paths.get(uploadDirectory, files.getOriginalFilename());
        fileNames.append(files.getOriginalFilename());
        try {
            Files.write(fileNameAndPath, files.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  }
        model.addAttribute("msg", "succssfully uploaded file" + fileNames.toString());
        model.addAttribute("filePath", fileNameAndPath.toString());
        return "uploadstatusview";
    }
}
