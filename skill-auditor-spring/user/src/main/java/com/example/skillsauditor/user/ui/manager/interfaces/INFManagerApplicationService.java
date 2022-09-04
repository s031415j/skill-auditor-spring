package com.example.skillsauditor.user.ui.manager.interfaces;

import com.example.skillsauditor.user.domain.manager.interfaces.commands.category.INFCreateCategoryCommand;
import com.example.skillsauditor.user.domain.manager.interfaces.commands.category.INFDeleteCategoryCommand;
import com.example.skillsauditor.user.domain.manager.interfaces.commands.category.INFEditCategoryCommand;
import com.example.skillsauditor.user.domain.manager.interfaces.commands.skill.INFCreateSkillCommand;
import com.example.skillsauditor.user.domain.manager.interfaces.commands.skill.INFDeleteSkillCommand;
import com.example.skillsauditor.user.domain.manager.interfaces.commands.skill.INFEditSkillCommand;

public interface INFManagerApplicationService {
    void createCategory(INFCreateCategoryCommand createCategoryCommand);
    void editCategory(INFEditCategoryCommand editCategoryCommand);
    void deleteCategory(INFDeleteCategoryCommand deleteCategoryCommand);
    void createSkill(INFCreateSkillCommand createSkillCommand);
    void editSkill(INFEditSkillCommand editSkillCommand);
    void deleteSkill(INFDeleteSkillCommand deleteSkillCommand);
    void addStaffToTeam(String managerId, String staffId);

}
