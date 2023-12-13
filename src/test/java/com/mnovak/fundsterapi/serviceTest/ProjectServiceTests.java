package com.mnovak.fundsterapi.serviceTest;

import com.mnovak.fundsterapi.data.ProjectMockData;
import com.mnovak.fundsterapi.dto.project.ProjectDTO;
import com.mnovak.fundsterapi.repository.ProjectRepository;
import com.mnovak.fundsterapi.service.ProjectService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ProjectServiceTests {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;


    @Test
    public void getProjects_should_return_projects() {
        when(projectRepository.findAll()).thenReturn(ProjectMockData.getProjects());

        List<ProjectDTO> projects = projectService.getProjects();

        assertNotNull(projects);
        assertEquals(1, projects.size());
        verify(projectRepository).findAll();
    }

}
