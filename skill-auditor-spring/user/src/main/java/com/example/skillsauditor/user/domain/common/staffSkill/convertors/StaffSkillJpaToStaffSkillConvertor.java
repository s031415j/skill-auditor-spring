package com.example.skillsauditor.user.domain.common.staffSkill.convertors;

import com.example.skillsauditor.user.application.staff.staffSkill.interfaces.INFStaffSkillJpaToStaffSkillConvertor;
import com.example.skillsauditor.user.domain.common.staffSkill.ExpiryDate;
import com.example.skillsauditor.user.domain.common.staffSkill.StaffSkill;
import com.example.skillsauditor.user.domain.common.staffSkill.StrengthOfSkill;
import com.example.skillsauditor.user.infrastructure.staff.StaffSkillJpa;
import org.springframework.stereotype.Component;

@Component
public class StaffSkillJpaToStaffSkillConvertor implements INFStaffSkillJpaToStaffSkillConvertor {

    @Override
    public StaffSkill convert(StaffSkillJpa staffSkillJpa) {
        ExpiryDate expiryDate = new ExpiryDate(staffSkillJpa.getExpiryDate().getMonthValue(), staffSkillJpa.getExpiryDate().getYear());
        StrengthOfSkill strengthOfSkill = StrengthOfSkill.valueOf(staffSkillJpa.getStrengthOfSkill());

        StaffSkill staffSkill = StaffSkill.staffSkillOf(staffSkillJpa.getStaffId(), staffSkillJpa.getSkillId(), strengthOfSkill, expiryDate);

        staffSkill.setId(staffSkillJpa.getId());

        return staffSkill;
    }
}
