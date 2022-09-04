package com.example.skill.infrastructure.skill.interfaces;

import com.example.skill.infrastructure.skill.SkillJpa;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CrudSkillRepository extends CrudRepository<SkillJpa, String> {
    Optional<SkillJpa> findByName(String name);
    List<SkillJpa> findAllByCategoryId(String categoryId);


}
