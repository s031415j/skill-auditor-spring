package com.example.skillsauditor.user.ui;

import com.example.skillsauditor.user.domain.common.FullName;
import com.example.skillsauditor.user.domain.manager.ManagerTeam;
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
import java.util.ArrayList;
import java.util.List;

@AutoConfigureMockMvc
@SpringBootTest
public class ManagerControllerTest {


    private INFManagerQueryHandler queryHandler;
    private INFManagerApplicationService applicationService;
    private INFIdentityService identityService;
    Resource userDetails;
    private MockMvc mockMvc;

    private final String FIRST_NAME = "FirstTest";
    private final String SURNAME = "SurTest";

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
    public void getTeam_When_User_Is_Not_Admin_UnAuthorized_Error_Returned() throws Exception {
        String id = "1";
        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.post("/manager/team/findTeamByManager/{manager_id}", id)
                .header("Content-Type", "application/json;charset=utf-8")
                .content(convertFileToString(userDetails)))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }

    @Test
    public void getTeam_When_User_Is_Admin_And_Team_Member_Is_Present_Status_Is_Ok() throws Exception {

        List<ManagerTeam> teamMemberList = new ArrayList<>();
        teamMemberList.add(createManagerTeamMock());

        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(true);
        Mockito.when(queryHandler.findTeamMembersByManagerId(Mockito.anyString())).thenReturn(teamMemberList);

        mockMvc.perform(MockMvcRequestBuilders.post("/manager/team/findTeamByManagerId/{manager_id}", "123")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content((convertFileToString(userDetails))))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }


    @Test
    public void getTeamMembersBySkillId_When_User_Is_Not_Admin_Throw_UnAuthorized() throws Exception {
        String id = "1";
        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.post("/manager/team/bySkill/{skill_id}", id)
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content(convertFileToString(userDetails)))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());

    }

    @Test
    public void getTeamMembersBySkillId_When_User_Is_Admin_And_Team_Member_Not_Found_Return_Status_Not_Found() throws Exception {
        String id = "1";

        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(true);
        Mockito.when(queryHandler.findTeamMembersBySkillId(Mockito.anyString(), Mockito.anyString())).thenReturn(new ArrayList<>());

        mockMvc.perform(MockMvcRequestBuilders.post("/manager/team/bySkill/{skill_id}", id)
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content(convertFileToString(userDetails)))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

    }

    @Test
    public void getAllTeamMembersWithExpiredSkills_When_User_Is_Not_Admin_Throw_Unauthorised() throws Exception {

        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.post("/team/expiredSkills")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content((convertFileToString(userDetails))))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());

    }

    @Test
    public void getAllTeamMembersWithExpiredSkills_When_User_Is_Admin_And_Has_No_Expired_Skills_Return_Not_Found() throws Exception {

        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(true);
        Mockito.when(queryHandler.findAllWithExpiredSkills()).thenReturn(new ArrayList<>());

        mockMvc.perform(MockMvcRequestBuilders.post("/team/expiredSkills")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content((convertFileToString(userDetails))))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

    }

    @Test
    public void updateManagerTeam_When_User_Is_Not_Admin_Throw_Unauthorised() throws Exception {

        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.post("/team/addToTeam/{staff_id}", "1")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content((convertFileToString(userDetails))))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());

    }

    @Test
    public void createSkill_When_User_Is_Admin_Return_Is_Ok() throws Exception {

        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.post("/manager/createSkill")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content((convertFileToString(userDetails))))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void createSkill_When_User_Is_Not_Admin_Throw_Unauthorised() throws Exception {

        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.post("/manager/createSkill")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content((convertFileToString(userDetails))))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());

    }



    @Test
    public void updateManagerTeam_When_User_Is_Admin_Status_Is_Ok() throws Exception {

        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.post("/team/addToTeam/{staff_id}", "1")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content((convertFileToString(userDetails))))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void editSkill_When_User_Is_Not_Admin_Throw_Unauthorised() throws Exception {

        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.post("/manager/editSkill")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content((convertFileToString(userDetails))))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());

    }

    @Test
    public void editSkill_When_User_Is_Admin_Return_Is_Ok() throws Exception {

        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.post("/manager/editSkill")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content((convertFileToString(userDetails))))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void deleteSkill_When_User_Is_Not_Admin_Throw_Unauthorised() throws Exception {

        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.post("/manager/deleteSkill")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content((convertFileToString(userDetails))))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());

    }

    @Test
    public void deleteSkill_When_User_Is_Admin_Return_Is_Ok() throws Exception {

        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.post("/manager/deleteSkill")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content((convertFileToString(userDetails))))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void createCategory_When_User_Is_Not_Admin_Throw_Unauthorised() throws Exception {

        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.post("/manager/createCategory")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content((convertFileToString(userDetails))))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());

    }

    @Test
    public void createCategory_When_User_Is_Admin_Return_Is_Ok() throws Exception {

        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.post("/manager/createCategory")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content((convertFileToString(userDetails))))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void editCategory_When_User_Is_Not_Admin_Throw_Unauthorised() throws Exception {

        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.post("/manager/editCategory")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content((convertFileToString(userDetails))))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());

    }

    @Test
    public void editCategory_When_User_Is_Admin_Return_Is_Ok() throws Exception {

        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.post("/manager/editCategory")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content((convertFileToString(userDetails))))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
    @Test
    public void deleteCategory_When_User_Is_Not_Admin_Throw_Unauthorised() throws Exception {

        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.post("/manager/deleteCategory")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content((convertFileToString(userDetails))))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());

    }

    @Test
    public void deleteCategory_When_User_Is_Admin_Return_Is_Ok() throws Exception {

        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.post("/manager/deleteCategory")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content((convertFileToString(userDetails))))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void getTeam_When_User_Is_Admin_And_Team_Member_Is_Empty_Throw_Unauthorised() throws Exception {
        String id = "1";

        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(true);
        Mockito.when(queryHandler.findTeamMembersByManagerId(Mockito.anyString())).thenReturn(new ArrayList<>());

        mockMvc.perform(MockMvcRequestBuilders.post("/manager/team/findTeamByManager/{manager_id}", id)
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content(convertFileToString(userDetails)))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());

    }

    private ManagerTeam createManagerTeamMock() {
        FullName fullName = new FullName(FIRST_NAME, SURNAME);
        return new ManagerTeam("1", "1", fullName);
    }


    private String convertFileToString(Resource resource) throws IOException {
        return new String(Files.readAllBytes(resource.getFile().toPath()));
    }
}
