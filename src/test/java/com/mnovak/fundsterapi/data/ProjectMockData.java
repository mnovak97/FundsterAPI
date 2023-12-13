package com.mnovak.fundsterapi.data;

import com.mnovak.fundsterapi.entity.Project;
import com.mnovak.fundsterapi.entity.User;
import com.mnovak.fundsterapi.enumeration.Role;

import java.util.List;

public class ProjectMockData {

    public static Project getProject() {
        return Project
                .builder()
                .id(1)
                .name("Test")
                .description("Description test")
                .projectPictureUrl("")
                .moneyGoal(1240)
                .moneyAcquired(1000)
                .backers(25)
                .user(User
                        .builder()
                        .id(1)
                        .role(Role.ADMIN)
                        .name("Test")
                        .email("test@mail.com")
                        .phoneNumber("091914355")
                        .build())
                .build();
    }

    public static List<Project> getProjects() { return List.of(getProject()); }



}
