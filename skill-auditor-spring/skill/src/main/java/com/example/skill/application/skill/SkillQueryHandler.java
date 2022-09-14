package com.example.skill.application.skill;

import com.example.skill.application.category.DTO.CategoryDTO;
import com.example.skill.application.skill.DTO.SkillDTO;
import com.example.skill.application.skill.DTO.SkillDTOList;
import com.example.skill.application.skill.interfaces.INFSkillRepository;
import com.example.skill.application.skill.interfaces.INFSkillJpa;
import com.example.skill.infrastructure.skill.SkillJpa;
import com.example.skill.ui.skill.interfaces.INFSkillQueryHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SkillQueryHandler implements INFSkillQueryHandler {

    private INFSkillRepository repository;

    @Override
    public Iterable<SkillJpa> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<SkillDTO> findBySkillId(String skillId) {
        Optional<SkillJpa> result = repository.findById(skillId);

        if(result.isPresent()){
            return convertSkillToDTO(result.get());
        }
        else {
            throw new IllegalArgumentException("Skill id does not exist");
        }
    }

    @Override
    public SkillDTOList findByCategoryId(String categoryId) {
        List<SkillJpa> result = repository.findByCategoryId(categoryId);
        SkillDTOList skillDTOList = new SkillDTOList();

        if(!result.isEmpty()){
            skillDTOList = convertSkillListToDTO(result, categoryId);
            return skillDTOList;
        }
        return skillDTOList;
    }


    private Optional<SkillDTO> convertSkillToDTO(INFSkillJpa skill) {
        SkillDTO skillDTO = new SkillDTO(skill.getId(), skill.getName(), new CategoryDTO(skill.getCategory().getId(), skill.getCategory().getName()));
        return Optional.of(skillDTO);
    }

    private SkillDTOList convertSkillListToDTO(List<SkillJpa> result, String categoryId) {
        SkillDTOList skillDTOList = new SkillDTOList();

        for(SkillJpa sk : result){
            if(sk.getCategory().getId().equals(categoryId)){
                SkillDTO skill = new SkillDTO(sk.getId(), sk.getName(),
                        new CategoryDTO(sk.getCategory().getId(), sk.getCategory().getName()));
                skillDTOList.getSkills().add(skill);
            }
        }
        return skillDTOList;
    }
}
