package com.example.skill.infrastructure.category;

import com.example.skill.application.category.interfaces.INFCategoryRepository;
import com.example.skill.infrastructure.category.interfaces.CrudCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
@AllArgsConstructor
public class CategoryRepository implements INFCategoryRepository {

    private CrudCategoryRepository repository;


    @Override
    public Optional<CategoryJpa> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Optional<CategoryJpa> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void save(CategoryJpa category) {
        repository.save(category);
    }

    @Override
    public void delete(CategoryJpa category) {
        repository.delete(category);
    }

}
