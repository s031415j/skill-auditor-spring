package com.example.skillsauditor.user.domain.common.staff.staffSkill.convertors;

import com.example.skillsauditor.user.application.staff.staffSkill.interfaces.INFStaffSkillToStaffSkillJpaConvertor;
import com.example.skillsauditor.user.domain.common.staff.staffSkill.StaffSkill;
import com.example.skillsauditor.user.infrastructure.staff.StaffSkillJpa;
import org.hibernate.boot.jaxb.internal.stax.LocalSchemaLocator;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

@Component
public class StaffSkillToStaffSkillJpaConvertor implements INFStaffSkillToStaffSkillJpaConvertor {


    @Override
    public StaffSkillJpa convert(String staffId, StaffSkill skill) {
        LocalDate expiryDate = convertExpiryDateToLocalDate(skill);

        StaffSkillJpa staffSkillJpa = StaffSkillJpa.staffSkillJpaOf(skill.getId(), staffId, skill.getSkillId(), skill.getStrengthOfSkill().toString(), expiryDate);
        staffSkillJpa.setId(skill.getId());
        staffSkillJpa.setStaffId(staffId);

        return staffSkillJpa;

    }

    private LocalDate convertExpiryDateToLocalDate(StaffSkill skill) {
        LocalDate expiryDate = LocalDate.of(skill.getExpiryDate().getYear(), skill.getExpiryDate().getMonth(), 1);

        expiryDate.with(lastDayOfMonth());
        return expiryDate;
    }
}
