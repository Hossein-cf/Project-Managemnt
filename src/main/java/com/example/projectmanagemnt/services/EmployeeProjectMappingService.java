package com.example.projectmanagemnt.services;

import com.example.projectmanagemnt.DBHelper.DB;
import com.example.projectmanagemnt.models.company.Project;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class EmployeeProjectMappingService {

    @RequestMapping("/getNumberOfEmployeeInCurrentProjects")
    public List<Long> getNumberOfEmployeeInCurrentProjects(@RequestBody ProjectsId ids){
        List<Long> list = new LinkedList<>();
        ids.getList().forEach(id -> {
            list.add(new DB().getNumberOfEmployeeInCurrentProject(id));
        });
        return list;
    }
}

@Data
class ProjectsId{
    List<Long> list ;
}