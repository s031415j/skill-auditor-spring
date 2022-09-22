package com.example.skill.application.skill;

import com.example.skill.application.category.events.DeleteCategoryEvent;
import com.example.skill.application.category.interfaces.INFCategoryRepository;
import com.example.skill.application.skill.events.CreateSkillEvent;
import com.example.skill.application.skill.events.EditSkillEvent;
import com.example.skill.application.skill.interfaces.INFSkillJpaToSkillConvertor;
import com.example.skill.application.skill.interfaces.INFSkillRepository;
import com.example.skill.application.skill.interfaces.INFSkillToSkillJpaConvertor;
import com.example.skill.domain.common.Identity;
import com.example.skill.domain.skill.Skill;
import com.example.skill.infrastructure.category.CategoryJpa;
import com.example.skill.infrastructure.skill.SkillJpa;
import com.example.skill.ui.skill.interfaces.INFSkillApplicationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class SkillApplicationService implements INFSkillApplicationService {

    private INFSkillRepository skillRepository;
    private INFCategoryRepository categoryRepository;
    private INFSkillToSkillJpaConvertor skillToSkillJpaConvertor;
    private INFSkillJpaToSkillConvertor skillJpaToSkillConvertor;
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private ObjectMapper mapper;

    @RabbitListener(queues = "createSkillQueue")
    @RabbitHandler
    public void createSkillListener(String event) {

        try {
            CreateSkillEvent createSkillEvent = mapper.readValue(event, CreateSkillEvent.class);

            Optional<SkillJpa> skillJpa = skillRepository.findByName(createSkillEvent.getName());

            if (skillJpa.isPresent()) {
                LOG.info("Skill already exists");

            } else {
                checkCategory(createSkillEvent);
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @RabbitListener(queues = "editSkillQueue")
    @RabbitHandler
    public void editSkillListener(String event) {

        try {
            EditSkillEvent editSkillEvent = mapper.readValue(event, EditSkillEvent.class);

            Optional<SkillJpa> skillJpa = skillRepository.findById(editSkillEvent.getId());

            if (skillJpa.isPresent()) {
                editSkill(editSkillEvent, skillJpa);
            } else {
                LOG.info("Skill does not exist");
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }

    @RabbitListener(queues = "deleteSkillQueue")
    @RabbitHandler
    public void deleteSkillListener(String event) {

        try {
            DeleteCategoryEvent deleteCategoryEvent = mapper.readValue(event, DeleteCategoryEvent.class);

            Optional<SkillJpa> skillJpa = skillRepository.findById(deleteCategoryEvent.getId());

                 if (skillJpa.isPresent()) {
                    skillRepository.delete(skillJpa.get());
                    LOG.info("Skill was successfully deleted");
                } else {
                    LOG.info("Skill does not exist");
                }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void checkCategory(CreateSkillEvent event) {
        Optional<CategoryJpa> category = categoryRepository.findById(event.getCategoryId());

        if (category.isPresent()) {
            createNewSkill(event, category);
        } else {
            LOG.error("Invalid category");
        }
    }

    private void createNewSkill(CreateSkillEvent event, Optional<CategoryJpa> category) {

        Identity identity = new Identity(event.getId());

        Skill skill = Skill.skillOf(identity, event.getName(), event.getCategoryId());
        skillRepository.save(skillToSkillJpaConvertor.convert(skill, category.get()));
        LOG.info("New skill added successfully");
    }

    private void editSkill(EditSkillEvent event, Optional<SkillJpa> skillJpa) {

        Skill skill = skillJpaToSkillConvertor.convert(skillJpa.get());
        skill.editName(event.getName());

        Optional<CategoryJpa> categoryJpa = getSkillCategory(skill);

        skillRepository.save(skillToSkillJpaConvertor.convert(skill, categoryJpa.get()));

        LOG.info("Skill changes were successful");

    }

    private Optional<CategoryJpa> getSkillCategory(Skill skill) {

        Optional<CategoryJpa> category = categoryRepository.findById(skill.getCategoryId());
        return category;

    }

}
