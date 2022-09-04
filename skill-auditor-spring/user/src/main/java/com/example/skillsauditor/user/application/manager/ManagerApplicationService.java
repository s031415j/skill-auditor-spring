package com.example.skillsauditor.user.application.manager;

import com.example.skillsauditor.user.application.manager.commands.category.CreateCategoryCommand;
import com.example.skillsauditor.user.application.manager.events.category.CreateCategoryEvent;
import com.example.skillsauditor.user.application.manager.interfaces.INFManagerJpaToManagerConvertor;
import com.example.skillsauditor.user.application.manager.interfaces.INFManagerRepository;
import com.example.skillsauditor.user.application.manager.interfaces.INFManagerToManagerJpaConvertor;
import com.example.skillsauditor.user.application.staff.interfaces.INFStaffRepository;
import com.example.skillsauditor.user.domain.common.Identity;
import com.example.skillsauditor.user.domain.common.UniqueIDFactory;
import com.example.skillsauditor.user.domain.manager.interfaces.commands.category.INFCreateCategoryCommand;
import com.example.skillsauditor.user.domain.manager.interfaces.commands.category.INFDeleteCategoryCommand;
import com.example.skillsauditor.user.domain.manager.interfaces.commands.category.INFEditCategoryCommand;
import com.example.skillsauditor.user.domain.manager.interfaces.commands.skill.INFCreateSkillCommand;
import com.example.skillsauditor.user.domain.manager.interfaces.commands.skill.INFDeleteSkillCommand;
import com.example.skillsauditor.user.domain.manager.interfaces.commands.skill.INFEditSkillCommand;
import com.example.skillsauditor.user.ui.manager.interfaces.INFManagerApplicationService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class ManagerApplicationService implements INFManagerApplicationService {

    private INFManagerRepository managerRepository;
    private INFManagerJpaToManagerConvertor managerJpaToManagerConvertor;
    private INFManagerToManagerJpaConvertor managerToManagerJpaConvertor;
    private INFStaffRepository staffRepository;

    private final Logger LOG = LoggerFactory.getLogger(getClass());


    @Override
    public void createCategory(INFCreateCategoryCommand createCategoryCommand) {
        Identity identity = UniqueIDFactory.createID();

        CreateCategoryEvent categoryEvent = new CreateCategoryEvent();
        categoryEvent.setId(identity.id());
        categoryEvent.setName(createCategoryCommand.getName());
        categoryEvent.setCategory(createCategoryCommand.getCategoryId());



    }

    @Override
    public void editCategory(INFEditCategoryCommand editCategoryCommand) {

    }

    @Override
    public void deleteCategory(INFDeleteCategoryCommand deleteCategoryCommand) {

    }

    @Override
    public void createSkill(INFCreateSkillCommand createSkillCommand) {

    }

    @Override
    public void editSkill(INFEditSkillCommand editSkillCommand) {

    }

    @Override
    public void deleteSkill(INFDeleteSkillCommand deleteSkillCommand) {

    }

    @Override
    public void addStaffToTeam(String managerId, String staffId) {

    }
}
