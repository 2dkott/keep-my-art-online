package com.konivan.services;


import com.konivan.domain.ProjectInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@RestController()
@RequestMapping("project-info")
public class ProjectInfoRestController {

    @PostMapping
    public void postNewProjectInfo(@RequestBody ProjectInfo projectInfo) throws ExecutionException, InterruptedException {
        new ProjectInfoProducer().putNewProject(projectInfo);
    }

}
