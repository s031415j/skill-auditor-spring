package com.example.skill.domain.skill.convertors;

import com.example.skill.application.skill.interfaces.INFSkillToSkillJpaConvertor;
import com.example.skill.domain.skill.Skill;
import com.example.skill.infrastructure.category.CategoryJpa;
import com.example.skill.infrastructure.skill.SkillJpa;
import org.springframework.stereotype.Component;

@Component
public class SkillToSkillJpaConvertor implements INFSkillToSkillJpaConvertor {

    @Override
    public SkillJpa convert(Skill skill, CategoryJpa categoryJpa){
        CategoryJpa category = CategoryJpa.categoryOf(categoryJpa.getId(), categoryJpa.getName());

            return SkillJpa.skillOf(skill.id().id(), skill.getName(), category);
        }
}
