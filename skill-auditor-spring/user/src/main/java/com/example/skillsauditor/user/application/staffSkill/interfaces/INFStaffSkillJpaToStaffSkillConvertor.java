package com.example.skillsauditor.user.application.staffSkill.interfaces;

import com.example.skillsauditor.user.domain.common.staffSkill.StaffSkill;

public interface INFStaffSkillJpaToStaffSkillConvertor {

    StaffSkill convert(INFStaffSkillJpa staffSkill);
}
