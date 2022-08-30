package com.example.skillsauditor.user.ui.staffSkill;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/staffSkill")
@RestController
@AllArgsConstructor
@Controller
public class StaffSkillController {

    private INFStaffSkillQueryHandler queryHandler;

    @GetMapping("findAll")
    public Iterable<?> getAllStaffStaffSkills(){
        return queryHandler.findAllStaffSkill();
    }


//    @GetMapping("{id}")
//    public Optional<?> getStaffSkillByStaffSkillId(@PathVariable(value = "id") UUID id){
//        Optional<?> result = queryHandler.findStaffSkillByStaffId(id);
//
//        if(result.isPresent()){
//            return result;
//        }else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found");
//        }
//    }
    @GetMapping("staff/{staffId}")
    public List<?> getStaffSkillByStaffId(@PathVariable(value = "staffId") String staffId){
//        Optional<?> result = queryHandler.findStaffSkillByStaffId(staffId);

        List<?> result = queryHandler.findStaffSkillsByStaffId(staffId);

        if(!result.isEmpty()){
            return result;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found");
        }
    }

    @GetMapping("skill/{skillId}")
    public Optional<?> getStaffSkillBySkillId(@PathVariable(value = "skillId") UUID skillId){
        Optional<?> result = queryHandler.findStaffSkillBySkillId(skillId);

        if(result.isPresent()){
            return result;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found");
        }
    }
}
