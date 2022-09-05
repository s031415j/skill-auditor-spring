package com.example.skill.application.skill.interfaces;

import com.example.skill.domain.skill.Skill;
import com.example.skill.infrastructure.category.CategoryJpa;
import com.example.skill.infrastructure.skill.SkillJpa;

public interface INFSkillToSkillJpaConvertor {
    SkillJpa convert(Skill skill, CategoryJpa category);
}
