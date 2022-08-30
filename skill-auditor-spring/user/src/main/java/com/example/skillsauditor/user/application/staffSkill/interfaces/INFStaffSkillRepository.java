package com.example.skillsauditor.user.application.staffSkill.interfaces;

import com.example.skillsauditor.user.infrastructure.staffSkill.StaffSkillJpa;
import java.util.Optional;
import java.util.UUID;

public interface INFStaffSkillRepository {

    Iterable<StaffSkillJpa> findAllStaffSkill();
    Optional<StaffSkillJpa> findStaffSkillByStaffId(UUID staffId);

    Optional<StaffSkillJpa> findStaffSkillBySkillId(UUID skillId);

    StaffSkillJpa save(StaffSkillJpa staffSkill);
}
