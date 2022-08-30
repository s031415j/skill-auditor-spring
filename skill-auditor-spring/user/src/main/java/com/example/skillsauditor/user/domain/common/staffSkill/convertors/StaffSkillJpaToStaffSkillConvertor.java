package com.example.skillsauditor.user.domain.common.staffSkill.convertors;

import com.example.skillsauditor.user.application.staffSkill.interfaces.INFStaffSkillJpaToStaffSkillConvertor;
import com.example.skillsauditor.user.domain.common.Identity;
import com.example.skillsauditor.user.domain.common.staffSkill.StaffSkill;
import com.example.skillsauditor.user.application.staffSkill.interfaces.INFStaffSkillJpa;
import org.springframework.stereotype.Component;

@Component
public class StaffSkillJpaToStaffSkillConvertor implements INFStaffSkillJpaToStaffSkillConvertor {

    public StaffSkill convert(INFStaffSkillJpa staffSkillJpa) {
        Identity identity = new Identity(staffSkillJpa.getId());
        StaffSkill staffSkill = StaffSkill.staffSkillOf(identity, staffSkillJpa.getStaffId(), staffSkillJpa.getSkillId(), staffSkillJpa.getStrengthOfSkill(), staffSkillJpa.getExpiryDate());

        return staffSkill;
    }
}
