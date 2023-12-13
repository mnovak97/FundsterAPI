package com.mnovak.fundsterapi.data;

import com.mnovak.fundsterapi.dto.user.UserDTO;
import com.mnovak.fundsterapi.entity.Project;
import com.mnovak.fundsterapi.entity.User;
import com.mnovak.fundsterapi.enumeration.Role;

import java.util.List;

public class UserMockData {

    public static User getUser() {
        return User
                .builder()
                .id(1)
                .name("Martin Novak")
                .email("mail@mail.com")
                .role(Role.ADMIN)
                .profilePictureUrl("")
                .phoneNumber("0919158566")
                .password("password")
                .projects(
                        List.of(Project
                                .builder()
                                .id(1)
                                .name("Project name")
                                .description("Description")
                                .backers(52)
                                .moneyAcquired(1500)
                                .moneyGoal(2000)
                                .projectPictureUrl("")
                                .build())
                )
                .build();

    }
    public static List<User> getUsers() { return List.of(getUser());}

    public static User getUpdateUser() {
        return User
                .builder()
                .email("test@mail.com")
                .name("Update User")
                .role(Role.ADMIN)
                .profilePictureUrl("")
                .phoneNumber("0916558321")
                .password("passdd")
                .build();
    }
}
