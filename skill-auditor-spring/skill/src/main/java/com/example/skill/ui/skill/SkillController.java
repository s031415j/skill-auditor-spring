package com.example.skill.ui.skill;

import com.example.skill.application.skill.DTO.SkillDTOList;
import com.example.skill.ui.skill.interfaces.INFSkillQueryHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@RestController
@RequestMapping("/skill")
@AllArgsConstructor
public class SkillController {

    private INFSkillQueryHandler queryHandler;

    @GetMapping("/findAll")
    public Iterable<?> findAll(){
        return queryHandler.findAll();
    }

    @GetMapping("/{skill_id}")
    public Optional<?> getSkillById(@PathVariable(name = "skill_id") String skillId){
        Optional<?> result = queryHandler.findBySkillId(skillId);

        if(result.isPresent()){
            return result;
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found.");
        }
    }

    @GetMapping("/findSkillsByCategory/{category_id}")
    public SkillDTOList getSkillsByCategoryId(@PathVariable(name = "category_id") String categoryId){
        SkillDTOList result = queryHandler.findByCategoryId(categoryId);

        if(!result.getSkills().isEmpty()){
            return result;
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found.");
        }
    }
}
