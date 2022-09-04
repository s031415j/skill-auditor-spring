package com.example.skill.application.category.interfaces;

import com.example.skill.infrastructure.category.CategoryJpa;
import java.util.Optional;

public interface INFCategoryRepository {

    Optional<CategoryJpa> findById(String id);
    Optional<CategoryJpa> findByName(String name);

    void save(CategoryJpa category);
    void delete(CategoryJpa category);
}

