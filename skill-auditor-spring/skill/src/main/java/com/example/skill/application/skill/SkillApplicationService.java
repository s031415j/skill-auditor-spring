package com.example.skill.application.skill;

import com.example.skill.application.category.interfaces.INFCategoryRepository;
import com.example.skill.application.skill.events.CreateSkillEvent;
import com.example.skill.application.skill.events.DeleteSkillEvent;
import com.example.skill.application.skill.events.EditSkillEvent;
import com.example.skill.application.skill.interfaces.INFSkillJpaToSkillConvertor;
import com.example.skill.application.skill.interfaces.INFSkillRepository;
import com.example.skill.application.skill.interfaces.INFSkillToSkillJpaConvertor;
import com.example.skill.domain.common.Identity;
import com.example.skill.domain.skill.Skill;
import com.example.skill.infrastructure.category.CategoryJpa;
import com.example.skill.infrastructure.skill.SkillJpa;
import com.example.skill.ui.skill.interfaces.INFSkillApplicationService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SkillApplicationService implements INFSkillApplicationService {

    private INFSkillRepository skillRepository;
    private INFCategoryRepository categoryRepository;
    private INFSkillToSkillJpaConvertor skillToSkillJpaConvertor;
    private INFSkillJpaToSkillConvertor skillJpaToSkillConvertor;

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createNewSkillListener(CreateSkillEvent event) {

        Optional<SkillJpa> skillJpa = skillRepository.findByName(event.getName());

        if (skillJpa.isPresent()) {

            LOG.info("Skill already exists");

        }else{
            checkCategory(event);
        }
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void editSkillListener(EditSkillEvent event) {

        Optional<SkillJpa> skillJpa = skillRepository.findById(event.getId());

        if(skillJpa.isPresent()){
            editSkill(event, skillJpa);
        }
        else{
            LOG.info("Skill does not exist");
        }

    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteSkillListener(DeleteSkillEvent event) {
        Optional<SkillJpa> skillJpa = skillRepository.findById(event.getId());

        if(skillJpa.isPresent()){
            skillRepository.delete(skillJpa.get());
            LOG.info("Skill was successfully deleted");
        }
        else{
            LOG.info("Skill does not exist");
        }

    }

    private void checkCategory(CreateSkillEvent event) {
        Optional<CategoryJpa> category = categoryRepository.findById(event.getCategoryId());

        if(category.isPresent()){
            createNewSkill(event, category);
        }
        else{
            LOG.error("Invalid category");
        }
    }

    private void createNewSkill(CreateSkillEvent event, Optional<CategoryJpa> category){

        Identity identity = new Identity(event.getId());

        Skill skill = Skill.skillOf(identity, event.getName(), event.getCategoryId());
        skillRepository.save(skillToSkillJpaConvertor.convert(skill, category.get()));
        LOG.info("New skill added successfully");
    }

    private void editSkill(EditSkillEvent event, Optional<SkillJpa> skillJpa){

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
