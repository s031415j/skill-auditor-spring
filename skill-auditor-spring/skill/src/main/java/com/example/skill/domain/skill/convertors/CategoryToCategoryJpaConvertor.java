package com.example.skill.domain.skill.convertors;

import com.example.skill.application.category.interfaces.convertors.INFCategoryToCategoryJpaConvertor;
import com.example.skill.domain.skill.Category;
import com.example.skill.infrastructure.category.CategoryJpa;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryJpaConvertor implements INFCategoryToCategoryJpaConvertor {

    @Override
    public CategoryJpa convert(Category category) {
        return new CategoryJpa(category.id().id(), category.getName());
    }
}
