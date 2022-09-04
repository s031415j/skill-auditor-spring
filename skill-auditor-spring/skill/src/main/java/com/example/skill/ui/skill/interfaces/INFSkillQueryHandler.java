package com.example.skill.ui.skill.interfaces;

import com.example.skill.application.skill.DTO.SkillDTOList;
import com.example.skill.infrastructure.skill.SkillJpa;

import java.util.Optional;

public interface INFSkillQueryHandler {
    Iterable<SkillJpa> findAll();
    Optional<SkillJpa> findBySkillId(String skillId);
    SkillDTOList findByCategoryId(String categoryId);
}
