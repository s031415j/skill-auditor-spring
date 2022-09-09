package com.example.skillsauditor.user.application.staff.staffSkill.interfaces;

import com.example.skillsauditor.user.domain.common.staff.staffSkill.StaffSkill;
import com.example.skillsauditor.user.infrastructure.staff.StaffSkillJpa;

public interface INFStaffSkillToStaffSkillJpaConvertor {

    StaffSkillJpa convert(String staffId, StaffSkill skill);

}
