package com.example.skill.infrastructure.skill;

import com.example.skill.application.skill.interfaces.INFSkillRepository;
import com.example.skill.infrastructure.skill.interfaces.CrudSkillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class SkillRepository implements INFSkillRepository {

    private CrudSkillRepository repository;

    @Override
    public Iterable<SkillJpa> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<SkillJpa> findById(String skillId) {
        return repository.findById(skillId);
    }

    @Override
    public Optional<SkillJpa> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<SkillJpa> findByCategoryId(String categoryId) {
        return repository.findAllByCategoryId(categoryId);
    }

    @Override
    public void save(SkillJpa skillJpa) {
        repository.save(skillJpa);
    }

    @Override
    public void delete(SkillJpa skillJpa) {
        repository.delete(skillJpa);
    }
}
