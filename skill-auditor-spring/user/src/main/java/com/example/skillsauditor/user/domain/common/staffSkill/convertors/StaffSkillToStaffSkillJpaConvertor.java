package com.example.skillsauditor.user.domain.common.staffSkill.convertors;

import com.example.skillsauditor.user.application.staffSkill.interfaces.INFStaffSkillJpa;
import com.example.skillsauditor.user.application.staffSkill.interfaces.INFStaffSkillToStaffSkillJpaConvertor;
import com.example.skillsauditor.user.domain.common.staffSkill.StaffSkill;
import com.example.skillsauditor.user.infrastructure.staffSkill.StaffSkillJpa;
import org.springframework.stereotype.Component;

@Component
public class StaffSkillToStaffSkillJpaConvertor implements INFStaffSkillToStaffSkillJpaConvertor {

    public INFStaffSkillJpa convert(StaffSkill staffSkill){
        INFStaffSkillJpa staffSkillJpa = StaffSkillJpa.staffSkillOf(staffSkill.getId().toString(), staffSkill.getStaffId(), staffSkill.getSkillId(), staffSkill.getStrengthOfSkill(), staffSkill.getExpiryDate());

        return staffSkillJpa;
    }
}
