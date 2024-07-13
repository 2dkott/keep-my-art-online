package com.konivan.services;


import com.konivan.domain.ProjectInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.PanelUI;
import java.time.LocalDate;
import java.util.UUID;

@RestController()
@RequestMapping("project-info")
public class ProjectInfoRestController {

    @PostMapping
    public String postNewProjectInfo() {
        ProjectInfo projectInfo = new ProjectInfo(LocalDate.now(), UUID.randomUUID().toString());
        new ProjectInfoProducer().putNewProject(projectInfo);
        return "";
    }

}
