package com.example.skillsauditor.user.ui;

import com.example.skillsauditor.user.domain.manager.Manager;
import com.example.skillsauditor.user.ui.identity.interfaces.INFIdentityService;
import com.example.skillsauditor.user.ui.manager.ManagerController;
import com.example.skillsauditor.user.ui.manager.interfaces.INFManagerApplicationService;
import com.example.skillsauditor.user.ui.manager.interfaces.INFManagerQueryHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.IOException;
import java.nio.file.Files;

@AutoConfigureMockMvc
@SpringBootTest
public class ManagerControllerTest {


    private INFManagerQueryHandler queryHandler;
    private INFManagerApplicationService applicationService;
    private INFIdentityService identityService;
    Resource userDetails;
    private MockMvc mockMvc;

    @BeforeEach
    void start(){
        MockitoAnnotations.openMocks(this);
        queryHandler = Mockito.mock(INFManagerQueryHandler.class);
        applicationService = Mockito.mock(INFManagerApplicationService.class);
        identityService = Mockito.mock(INFIdentityService.class);
        ManagerController testClass = new ManagerController(queryHandler, applicationService, identityService);
        mockMvc = MockMvcBuilders.standaloneSetup(testClass).build();
        userDetails = new ClassPathResource("data/userDetails.json");
    }

    @Test
    public void test01_When_User_Is_Not_Admin_UnAuthorized_Error_Returned() throws Exception {
        String id = "1";
        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.post("/manager/team/findTeamByManager/{manager_id}", id)
                .header("Content-Type", "application/json;charset=utf-8")
                .content(convertFileToString(userDetails)))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }

    @Test
    public void test02_When_User_Is_Admin_UnAuthorized_Error_Returned() throws Exception {
        String id = "1";
        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.post("/manager/team/findTeamByManager/{manager_id}", id)
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content(convertFileToString(userDetails)))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }

    @Test
    public void test02_When_Team_Member_List_Is_Not_Empty_Return_List(){

    }

    private String convertFileToString(Resource resource) throws IOException {
        return new String(Files.readAllBytes(resource.getFile().toPath()));
    }
}
