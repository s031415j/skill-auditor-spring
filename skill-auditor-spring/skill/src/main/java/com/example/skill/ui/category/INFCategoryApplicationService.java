package com.example.skill.ui.category;

import com.example.skill.application.category.events.CreateCategoryEvent;
import com.example.skill.application.category.events.DeleteCategoryEvent;
import com.example.skill.application.category.events.EditCategoryEvent;


public interface INFCategoryApplicationService {

    void createCategoryListener(String event);
    void editCategoryListener(String event);
    void deleteCategoryListener(String event);
}
