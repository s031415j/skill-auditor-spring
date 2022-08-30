package com.example.skillsauditor.user.ui.staffSkill;

import com.example.skillsauditor.user.application.staffSkill.DTO.StaffSkillDTO;
import com.example.skillsauditor.user.infrastructure.staffSkill.StaffSkillJpa;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface INFStaffSkillQueryHandler {

    Iterable<StaffSkillJpa> findAllStaffSkill();
    Optional<StaffSkillDTO> findStaffSkillByStaffId(UUID staffId);
    Optional<StaffSkillDTO> findStaffSkillBySkillId(UUID skillId);


    List<?> findStaffSkillsByStaffId(String staffId);
}
