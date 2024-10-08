package com.example.skillsauditor.user.application.manager;

import com.example.skillsauditor.user.application.manager.commands.skill.EditSkillCommand;
import com.example.skillsauditor.user.application.manager.events.category.CreateCategoryEvent;
import com.example.skillsauditor.user.application.manager.events.category.DeleteCategoryEvent;
import com.example.skillsauditor.user.application.manager.events.category.EditCategoryEvent;
import com.example.skillsauditor.user.application.manager.events.skill.CreateSkillEvent;
import com.example.skillsauditor.user.application.manager.events.skill.DeleteSkillEvent;
import com.example.skillsauditor.user.application.manager.interfaces.INFManagerJpaToManagerConvertor;
import com.example.skillsauditor.user.application.manager.interfaces.INFManagerRepository;
import com.example.skillsauditor.user.application.manager.interfaces.INFManagerToManagerJpaConvertor;
import com.example.skillsauditor.user.application.staff.interfaces.INFStaffJpaToStaffConvertor;
import com.example.skillsauditor.user.application.staff.interfaces.INFStaffRepository;
import com.example.skillsauditor.user.domain.common.Identity;
import com.example.skillsauditor.user.domain.common.UniqueIDFactory;
import com.example.skillsauditor.user.domain.common.FullName;
import com.example.skillsauditor.user.domain.common.Staff;
import com.example.skillsauditor.user.domain.manager.Manager;
import com.example.skillsauditor.user.domain.manager.ManagerTeam;
import com.example.skillsauditor.user.domain.manager.interfaces.commands.category.INFCreateCategoryCommand;
import com.example.skillsauditor.user.domain.manager.interfaces.commands.category.INFDeleteCategoryCommand;
import com.example.skillsauditor.user.domain.manager.interfaces.commands.category.INFEditCategoryCommand;
import com.example.skillsauditor.user.domain.manager.interfaces.commands.skill.INFCreateSkillCommand;
import com.example.skillsauditor.user.domain.manager.interfaces.commands.skill.INFDeleteSkillCommand;
import com.example.skillsauditor.user.domain.manager.interfaces.commands.skill.INFEditSkillCommand;
import com.example.skillsauditor.user.infrastructure.manager.ManagerJpa;
import com.example.skillsauditor.user.infrastructure.manager.ManagerTeamJpa;
import com.example.skillsauditor.user.infrastructure.staff.StaffJpa;
import com.example.skillsauditor.user.ui.manager.interfaces.INFManagerApplicationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class ManagerApplicationService implements INFManagerApplicationService {

    private INFManagerRepository managerRepository;
    private INFManagerJpaToManagerConvertor managerJpaToManagerConvertor;
    private INFManagerToManagerJpaConvertor managerToManagerJpaConvertor;

    private INFStaffJpaToStaffConvertor staffJpaToStaffConvertor;
    private INFStaffRepository staffRepository;
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private Environment environment;
    private RabbitTemplate sender;
    private ObjectMapper mapper;


    @Override
    public void createCategory(INFCreateCategoryCommand createCategoryCommand) {
        Identity identity = UniqueIDFactory.createID();

        CreateCategoryEvent categoryEvent = new CreateCategoryEvent();
        categoryEvent.setId(identity.id());
        categoryEvent.setName(createCategoryCommand.getName());

        try {
            String eventAsJson = mapper.writeValueAsString(categoryEvent);
            sender.convertAndSend(environment.getProperty("rabbitmq.exchange"),
                    environment.getProperty("rabbitmq.createCategoryQueueRoutingKey"),
                    eventAsJson);

        } catch (JsonProcessingException e) {
            LOG.error(e.getMessage());
        }
    }

    @Override
    public void editCategory(INFEditCategoryCommand editCategoryCommand) {

        EditCategoryEvent categoryEvent = new EditCategoryEvent();
        categoryEvent.setId(editCategoryCommand.getCategoryId());
        categoryEvent.setName(editCategoryCommand.getName());

        try {
            String eventAsJson = mapper.writeValueAsString(categoryEvent);
            sender.convertAndSend(environment.getProperty("rabbitmq.exchange"),
                    environment.getProperty("rabbitmq.editCategoryQueueRoutingKey"),
                    eventAsJson);

        } catch (JsonProcessingException e) {
            LOG.error(e.getMessage());
        }

    }

    @Override
    public void deleteCategory(INFDeleteCategoryCommand deleteCategoryCommand) {

        DeleteCategoryEvent categoryEvent = new DeleteCategoryEvent();
        categoryEvent.setId(deleteCategoryCommand.getCategoryId());

        try {
            String eventAsJson = mapper.writeValueAsString(categoryEvent);
            sender.convertAndSend(environment.getProperty("rabbitmq.exchange"),
                    environment.getProperty("rabbitmq.deleteCategoryQueueRoutingKey"),
                    eventAsJson);

        } catch (JsonProcessingException e) {
            LOG.error(e.getMessage());
        }
    }

    @Override
    public void createSkill(INFCreateSkillCommand createSkillCommand) {

        Identity identity = UniqueIDFactory.createID();

        CreateSkillEvent skillEvent = new CreateSkillEvent();
        skillEvent.setId(identity.id());
        skillEvent.setName(createSkillCommand.getName());
        skillEvent.setCategoryId(createSkillCommand.getCategoryId());

        try {
            String eventAsJson = mapper.writeValueAsString(skillEvent);
            sender.convertAndSend(environment.getProperty("rabbitmq.exchange"),
                    environment.getProperty("rabbitmq.createSkillQueueRoutingKey"),
                    eventAsJson);

        } catch (JsonProcessingException e) {
            LOG.error(e.getMessage());
        }

    }

    @Override
    public void editSkill(INFEditSkillCommand editSkillCommand) {

        EditSkillCommand skillEvent = new EditSkillCommand();
        skillEvent.setId(editSkillCommand.getSkillId());
        skillEvent.setName(editSkillCommand.getName());

        try {
            String eventAsJson = mapper.writeValueAsString(skillEvent);
            sender.convertAndSend(environment.getProperty("rabbitmq.exchange"),
                    environment.getProperty("rabbitmq.editSkillQueueRoutingKey"),
                    eventAsJson);

        } catch (JsonProcessingException e) {
            LOG.error(e.getMessage());
        }
    }

    @Override
    public void deleteSkill(INFDeleteSkillCommand deleteSkillCommand) {

        boolean inUse = staffHasSkills(deleteSkillCommand);

        if(inUse){
            LOG.info("Skill in use, can not be deleted");
        }
        else{
            DeleteSkillEvent skillEvent = new DeleteSkillEvent();
            skillEvent.setId(deleteSkillCommand.getSkillId());

            try {
                String eventAsJson = mapper.writeValueAsString(skillEvent);
                sender.convertAndSend(environment.getProperty("rabbitmq.exchange"),
                        environment.getProperty("rabbitmq.deleteSkillQueueRoutingKey"),
                        eventAsJson);

            } catch (JsonProcessingException e) {
                LOG.error(e.getMessage());
            }
        }

    }

    private boolean staffHasSkills(INFDeleteSkillCommand deleteSkillCommand) {
        Iterable<StaffJpa> staffWithSkills = staffRepository.findAll();
        Staff staff;

        if(staffWithSkills != null){
            for(StaffJpa staffJpa : staffWithSkills) {
                staff = staffJpaToStaffConvertor.convert(staffJpa);
                if(staff.hasSkill(deleteSkillCommand.getSkillId())){
                   return true;
                }
            }
        }
        return false;
    }

    @Override
    public void addStaffToTeam(String managerId, String staffId) {

        Optional<ManagerJpa> managerJpa = managerRepository.findById(managerId);
        Optional<StaffJpa> staffJpa = staffRepository.findById(staffId);

        if (managerJpa.isPresent()) {

            if (staffJpa.isPresent()) {
                Manager manager = managerJpaToManagerConvertor.convert(managerJpa.get());

                ManagerTeam teamMember = ManagerTeam.managerTeamOf(staffId,
                        managerId, new FullName(staffJpa.get().getFullNameFirstname(), staffJpa.get().getFullNameSurname()));

                manager.addStaffToTeam(teamMember);

                ManagerJpa mJpa = managerToManagerJpaConvertor.convert(manager);
                mJpa.setTeam(managerJpa.get().getTeam());

                ManagerTeamJpa newTeamMember = new ManagerTeamJpa(teamMember.getId(), mJpa.getId(), staffJpa.get().getFullNameFirstname(), staffJpa.get().getFullNameSurname(), staffJpa.get());
                mJpa.addTeamMember(newTeamMember);

                managerRepository.save(mJpa);
            }
        }
    }
}
