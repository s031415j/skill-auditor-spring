package com.example.skillsauditor.user.application.staff.staffSkill.interfaces;

import com.example.skillsauditor.user.domain.common.staff.staffSkill.StaffSkill;
import com.example.skillsauditor.user.infrastructure.staff.StaffSkillJpa;
import org.springframework.stereotype.Component;

@Component
public interface INFStaffSkillJpaToStaffSkillConvertor {
    StaffSkill convert(StaffSkillJpa staffSkill);
}
