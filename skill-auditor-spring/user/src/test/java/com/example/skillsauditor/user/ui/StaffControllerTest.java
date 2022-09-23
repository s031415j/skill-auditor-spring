package com.example.skillsauditor.user.ui;

import com.example.skillsauditor.user.ui.identity.interfaces.INFIdentityService;
import com.example.skillsauditor.user.ui.staff.StaffController;
import com.example.skillsauditor.user.ui.staff.interfaces.INFStaffApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.IOException;
import java.nio.file.Files;

public class StaffControllerTest {

    private INFStaffApplicationService applicationService;
    private INFIdentityService identityService;
    Resource userDetails;

    private MockMvc mockMvc;

    @BeforeEach
    void start(){
        MockitoAnnotations.openMocks(this);
        applicationService = Mockito.mock(INFStaffApplicationService.class);
        identityService = Mockito.mock(INFIdentityService.class);
        StaffController testClass = new StaffController(applicationService, identityService);
        mockMvc = MockMvcBuilders.standaloneSetup(testClass).build();
        userDetails = new ClassPathResource("data/userDetails.json");
    }

    @Test
    public void updateStaffDetails_When_User_Is_Not_Admin_Should_Throw_Unauthorized() throws Exception {
        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(false);


        mockMvc.perform(MockMvcRequestBuilders.put("/staff/editDetails")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content(convertFileToString(userDetails)))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }

    @Test
    public void updateStaffDetails_When_User_Is_Not_Specified_User_Should_Throw_Unauthorized() throws Exception {
        Mockito.when(identityService.isSpecifiedUser(Mockito.any(), Mockito.anyString())).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.put("/staff/editDetails")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content(convertFileToString(userDetails)))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }

    @Test
    public void updateStaffDetails_When_User_Is_Specified_User_EditStaff_Is_Called() throws Exception {
        Mockito.when(identityService.isSpecifiedUser(Mockito.any(), Mockito.anyString())).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.put("/staff/editDetails")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content(convertFileToString(userDetails)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void updateStaffDetails_When_User_Is_Admin_User_EditStaff_Is_Called() throws Exception {
        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.put("/staff/editDetails")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content(convertFileToString(userDetails)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void addStaffSkill_When_User_Is_Not_Admin_Should_Throw_Unauthorized() throws Exception {
        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.post("/staff/staffSkill/add")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content(convertFileToString(userDetails)))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }

    @Test
    public void addStaffSkill_When_User_Not_Specified_User_Should_Throw_Unauthorized() throws Exception {
        Mockito.when(identityService.isSpecifiedUser(Mockito.any(), Mockito.any())).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.post("/staff/staffSkill/add")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content(convertFileToString(userDetails)))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }

    @Test
    public void addStaffSkill_When_User_Is_Admin_addStaffSkill_Is_Called() throws Exception {
        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.post("/staff/staffSkill/add")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content(convertFileToString(userDetails)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void addStaffSkill_When_User_Is_Specified_User_addStaffSkill_Is_Called() throws Exception {
        Mockito.when(identityService.isSpecifiedUser(Mockito.any(), Mockito.any())).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.post("/staff/staffSkill/add")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content(convertFileToString(userDetails)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void updateStaffSkill_When_User_Is_Not_Admin_Should_Throw_Unauthorized() throws Exception {
        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(false);


        mockMvc.perform(MockMvcRequestBuilders.put("/staff/staffSkill/updateSkill")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content(convertFileToString(userDetails)))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }

    @Test
    public void updateStaffSkill_When_User_Is_Not_Specified_User_Should_Throw_Unauthorized() throws Exception {
        Mockito.when(identityService.isSpecifiedUser(Mockito.any(), Mockito.anyString())).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.put("/staff/staffSkill/updateSkill")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content(convertFileToString(userDetails)))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }

    @Test
    public void updateStaffSkill_When_User_Is_Specified_User_EditStaff_Is_Called() throws Exception {
        Mockito.when(identityService.isSpecifiedUser(Mockito.any(), Mockito.anyString())).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.put("/staff/staffSkill/updateSkill")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content(convertFileToString(userDetails)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void updateStaffSkill_When_User_Is_Admin_User_EditStaff_Is_Called() throws Exception {
        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.put("/staff/staffSkill/updateSkill")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content(convertFileToString(userDetails)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void removeStaffSkill_When_User_Is_Not_Admin_Should_Throw_Unauthorized() throws Exception {
        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(false);


        mockMvc.perform(MockMvcRequestBuilders.delete("/staff/staffSkill/deleteStaffSkill")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content(convertFileToString(userDetails)))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }

    @Test
    public void removeStaffSkill_When_User_Is_Not_Specified_User_Should_Throw_Unauthorized() throws Exception {
        Mockito.when(identityService.isSpecifiedUser(Mockito.any(), Mockito.anyString())).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.delete("/staff/staffSkill/deleteStaffSkill")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content(convertFileToString(userDetails)))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }

    @Test
    public void removeStaffSkill_When_User_Is_Specified_User_EditStaff_Is_Called() throws Exception {
        Mockito.when(identityService.isSpecifiedUser(Mockito.any(), Mockito.anyString())).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.delete("/staff/staffSkill/deleteStaffSkill")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content(convertFileToString(userDetails)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void removeStaffSkill_When_User_Is_Admin_User_EditStaff_Is_Called() throws Exception {
        Mockito.when(identityService.isAdmin(Mockito.any())).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.delete("/staff/staffSkill/deleteStaffSkill")
                        .header("Content-Type", "application/json;charset=utf-8")
                        .content(convertFileToString(userDetails)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    private String convertFileToString(Resource resource) throws IOException {
        return new String(Files.readAllBytes(resource.getFile().toPath()));
    }

}
