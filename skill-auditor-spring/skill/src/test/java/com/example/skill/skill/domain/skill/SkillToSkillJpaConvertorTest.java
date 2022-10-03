package com.example.skill.skill.domain.skill;

import com.example.skill.domain.common.Identity;
import com.example.skill.domain.common.UniqueIdFactory;
import com.example.skill.domain.skill.Skill;
import com.example.skill.domain.skill.convertors.SkillToSkillJpaConvertor;
import com.example.skill.infrastructure.category.CategoryJpa;
import com.example.skill.infrastructure.skill.SkillJpa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SkillToSkillJpaConvertorTest {

    private SkillToSkillJpaConvertor convertor;

    private Skill skill;
    private final Identity ID = UniqueIdFactory.createId();
    private final String NAME = "NameTest";
    private final String CATEGORY_ID = "CatIdTest";

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);

        skill = new Skill(ID, NAME, CATEGORY_ID);
        convertor = new SkillToSkillJpaConvertor();
    }


    @Test
    public void convert_When_Given_A_Skill_Return_A_SkillJpa_With_The_Same_Data(){

        SkillJpa skillJpa = convertor.convert(skill, createCategoryJpaMock());

        assertEquals(ID.id(), skillJpa.getId());
        assertEquals(NAME, skillJpa.getName());
        assertEquals(CATEGORY_ID, skillJpa.getCategory().getId());

    }

    private CategoryJpa createCategoryJpaMock() {
        return new CategoryJpa("CatIdTest", "CatName");
    }


}
