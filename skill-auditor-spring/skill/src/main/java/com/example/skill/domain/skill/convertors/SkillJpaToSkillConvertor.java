package com.example.skill.domain.skill.convertors;

import com.example.skill.application.skill.interfaces.INFSkillJpaToSkillConvertor;
import com.example.skill.domain.common.Identity;
import com.example.skill.domain.skill.Skill;
import com.example.skill.infrastructure.skill.SkillJpa;
import org.springframework.stereotype.Component;

@Component
public class SkillJpaToSkillConvertor implements INFSkillJpaToSkillConvertor {

    @Override
    public Skill convert(SkillJpa skillJpa) {
        Identity identity = new Identity(skillJpa.getId());

        return Skill.skillOf(identity, skillJpa.getName(), skillJpa.getCategory().getId());
    }
}
