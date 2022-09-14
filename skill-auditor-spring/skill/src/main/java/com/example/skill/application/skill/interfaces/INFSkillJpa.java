package com.example.skill.application.skill.interfaces;

import com.example.skill.infrastructure.category.CategoryJpa;

public interface INFSkillJpa {

    String getId();
    String getName();
    CategoryJpa getCategory();

    void setId(String id);
    void setName(String name);
    void setCategory(CategoryJpa category);

}
