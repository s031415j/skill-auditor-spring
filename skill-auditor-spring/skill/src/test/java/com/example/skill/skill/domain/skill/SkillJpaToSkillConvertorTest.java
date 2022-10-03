package com.example.skill.skill.domain.skill;

import com.example.skill.domain.common.Identity;
import com.example.skill.domain.common.UniqueIdFactory;
import com.example.skill.domain.skill.Skill;
import com.example.skill.domain.skill.convertors.SkillJpaToSkillConvertor;
import com.example.skill.infrastructure.category.CategoryJpa;
import com.example.skill.infrastructure.skill.SkillJpa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SkillJpaToSkillConvertorTest {

    private SkillJpaToSkillConvertor convertor;

    private SkillJpa skillJpa;

    private CategoryJpa categoryJpa;

    private final Identity ID = UniqueIdFactory.createId();
    private final String NAME = "NameTest";

    private final String CATEGORY_ID = "CatIdTest";

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        skillJpa = new SkillJpa(ID.toString(), NAME, new CategoryJpa("CatTestId", "CatTestName"));
        convertor = new SkillJpaToSkillConvertor();
    }

    @Test
    public void convert_When_Given_A_StaffJpa_Return_A_Staff_With_The_Same_Data(){

        Skill skill = convertor.convert(skillJpa);

        assertEquals(ID.toString(), skill.id().toString());
        assertEquals(NAME, skill.getName());
        assertEquals(CATEGORY_ID, skill.getCategoryId());

    }
}
