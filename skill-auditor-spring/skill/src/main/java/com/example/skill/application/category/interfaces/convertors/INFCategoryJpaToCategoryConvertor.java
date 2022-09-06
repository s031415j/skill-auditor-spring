package com.example.skill.application.category.interfaces.convertors;

import com.example.skill.application.category.interfaces.INFCategoryJpa;
import com.example.skill.domain.skill.Category;

public interface INFCategoryJpaToCategoryConvertor {
    Category convert(INFCategoryJpa categoryJpa);
}
