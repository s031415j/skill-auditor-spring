package com.example.skill.application.category.interfaces.convertors;

import com.example.skill.domain.skill.Category;
import com.example.skill.infrastructure.category.CategoryJpa;

public interface INFCategoryToCategoryJpaConvertor {
    CategoryJpa convert(Category category);
}
