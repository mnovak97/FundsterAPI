package com.mnovak.fundsterapi.scheduler;

import com.mnovak.fundsterapi.dto.project.ProjectDTO;
import com.mnovak.fundsterapi.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Scheduler {

    private final ProjectService projectService;

    @Scheduled(cron = "*/10 * * * * *")
    public void showProjectsInDatabase() {
        List<ProjectDTO> projects = projectService.getProjects();
        System.out.println("Scheduled method every 30 sec, all projects ->");
        projects.forEach(project -> System.out.println(project.getName()));
    }
}
