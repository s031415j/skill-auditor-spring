package com.example.skill.application.skill.interfaces;

import com.example.skill.infrastructure.skill.SkillJpa;

import java.util.List;
import java.util.Optional;

public interface INFSkillRepository {

    Iterable<SkillJpa> findAll();
    Optional<SkillJpa> findById(String id);
    Optional<SkillJpa> findByName(String name);
    List<SkillJpa> findByCategoryId(String categoryId);

    void save(SkillJpa skillJpa);
    void delete(SkillJpa skillJpa);
}
