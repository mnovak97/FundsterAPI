package com.mnovak.fundsterapi.serviceTest;

import com.mnovak.fundsterapi.data.UserMockData;
import com.mnovak.fundsterapi.dto.user.UserDTO;
import com.mnovak.fundsterapi.repository.UserRepository;
import com.mnovak.fundsterapi.service.UserService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void getUsers_should_return_users() {
        when(userRepository.findAll()).thenReturn(UserMockData.getUsers());

        List<UserDTO> users = userService.getUsers();

        assertNotNull(users);
        assertEquals(1, users.size());
        verify(userRepository).findAll();
    }

    @Test
    public void updateUser_should_update_user() {
        when(userRepository.findById(any())).thenReturn(Optional.of(UserMockData.getUser()));

        userService.updateUser(any(), UserMockData.getUpdateUser());
        verify(userRepository).findById(any());
        verify(userRepository).save(any());
    }

    @Test
    public void deleteUser_should_delete_user() {
        when(userRepository.findById(any())).thenReturn(Optional.of(UserMockData.getUser()));

        userService.deleteUser(any());

        verify(userRepository).findById(any());
        verify(userRepository).delete(any());
    }
}
