package com.example.skillsauditor.user.domain.common.staff.staffSkill.convertors;

import com.example.skillsauditor.user.application.staff.staffSkill.interfaces.INFStaffSkillToStaffSkillJpaConvertor;
import com.example.skillsauditor.user.domain.common.staff.staffSkill.StaffSkill;
import com.example.skillsauditor.user.infrastructure.staff.StaffSkillJpa;
import org.springframework.stereotype.Component;

@Component
public class StaffSkillToStaffSkillJpaConvertor implements INFStaffSkillToStaffSkillJpaConvertor {

    public INFStaffSkillJpa convert(StaffSkill staffSkill){
        INFStaffSkillJpa staffSkillJpa = StaffSkillJpa.staffSkillOf(staffSkill.getId().toString(), staffSkill.getStaffId(), staffSkill.getSkillId(), staffSkill.getStrengthOfSkill(), staffSkill.getExpiryDate());

        return staffSkillJpa;
    }
}
