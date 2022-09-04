package com.example.skill.infrastructure.category.interfaces;

import com.example.skill.infrastructure.category.CategoryJpa;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface CrudCategoryRepository extends CrudRepository<CategoryJpa, String> {
    Optional<CategoryJpa> findByName(String name);
}
