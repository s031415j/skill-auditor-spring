package com.example.skill.skill.ui;

import com.example.skill.application.category.DTO.CategoryDTO;
import com.example.skill.application.skill.DTO.SkillDTO;
import com.example.skill.application.skill.DTO.SkillDTOList;
import com.example.skill.ui.skill.SkillController;
import com.example.skill.ui.skill.interfaces.INFSkillQueryHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.Resource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SkillControllerTest {

    private INFSkillQueryHandler queryHandler;

    private MockMvc mockMvc;

    @BeforeEach
    void start(){
        MockitoAnnotations.openMocks(this);
        queryHandler = Mockito.mock(INFSkillQueryHandler.class);
        SkillController skillController = new SkillController(queryHandler);
        mockMvc = MockMvcBuilders.standaloneSetup(skillController).build();
    }

    @Test
    public void getSkillById_When_Given_A_Skill_Id_Return_Skills() throws Exception {

        SkillDTO skillDTO = createSkillDTOMock();

        Mockito.when(queryHandler.findBySkillId(Mockito.anyString())).thenReturn(Optional.of(skillDTO));

        mockMvc.perform(MockMvcRequestBuilders.get("/skill/{skill_id}", "SkillTestId")
                .header("Content-Type", "application/json;charset=utf-8")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getSkillById_When_A_Skill_Id_Is_Empty_Should_Throw_Not_Found() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/skill/{skill_id}", "SkillTestId")
                .header("Content-Type", "application/json;charset=utf-8")).andExpect(MockMvcResultMatchers.status().isNotFound());
    }
    @Test
    public void getSkillsByCategoryId_When_Given_A_Category_Id_Return_Skills() throws Exception {

        SkillDTOList skillDTOList = new SkillDTOList();
        List<SkillDTO> skills = new ArrayList<>();
        SkillDTO skill1 = createSkillDTOMock();

        skills.add(skill1);
        skillDTOList.setSkills(skills);

        Mockito.when(queryHandler.findByCategoryId(Mockito.anyString())).thenReturn(skillDTOList);

        mockMvc.perform(MockMvcRequestBuilders.get("/skill/findSkillsByCategory/{category_id}", "CatTestId")
                .header("Content-Type", "application/json;charset=utf-8")).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void getSkillsByCategoryId_When_A_Category_Id_Is_Empty_Should_Throw_Not_Found() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/findSkillsByCategory/{category_id}", "CatTestId")
                .header("Content-Type", "application/json;charset=utf-8")).andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    private SkillDTO createSkillDTOMock() {
        return new SkillDTO("SkillTestId", "SkillTestName", createCategoryDTOMock());
    }

    private CategoryDTO createCategoryDTOMock() {
        return new CategoryDTO("CatTestId", "CatTestName");
    }

}
