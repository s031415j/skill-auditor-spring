package com.example.skillsauditor.user.infrastructure.staffSkill;

import com.example.skillsauditor.user.application.staffSkill.interfaces.INFStaffSkillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class StaffSkillRepository implements INFStaffSkillRepository {

    private CrudStaffSkillRepository repository;

    public Iterable<StaffSkillJpa> findAllStaffSkill(){
        return repository.findAll();
    }

    public Optional<StaffSkillJpa> findStaffSkillByStaffId(UUID staffId){
        return repository.findById(staffId.toString());
    }

    public Optional<StaffSkillJpa> findStaffSkillBySkillId(UUID skillId){
        return repository.findById(skillId.toString());
    }

    public StaffSkillJpa save(StaffSkillJpa staffSkill){
        return repository.save(staffSkill);
    }
}
