package com.example.skillsauditor.user.domain.common.staff.staffSkill.convertors;

import com.example.skillsauditor.user.application.staff.staffSkill.interfaces.INFStaffSkillJpaToStaffSkillConvertor;
import com.example.skillsauditor.user.domain.common.Identity;
import com.example.skillsauditor.user.domain.common.staff.staffSkill.StaffSkill;
import org.springframework.stereotype.Component;

@Component
public class StaffSkillJpaToStaffSkillConvertor implements INFStaffSkillJpaToStaffSkillConvertor {

    public StaffSkill convert(INFStaffSkillJpa staffSkillJpa) {
        Identity identity = new Identity(staffSkillJpa.getId());
        StaffSkill staffSkill = StaffSkill.staffSkillOf(identity, staffSkillJpa.getStaffId(), staffSkillJpa.getSkillId(), staffSkillJpa.getStrengthOfSkill(), staffSkillJpa.getExpiryDate());

        return staffSkill;
    }
}
