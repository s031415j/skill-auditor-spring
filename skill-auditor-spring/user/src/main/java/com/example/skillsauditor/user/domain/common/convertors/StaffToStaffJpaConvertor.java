package com.example.skillsauditor.user.domain.common.convertors;

import com.example.skillsauditor.user.application.staff.interfaces.INFStaffToStaffJpaConvertor;
import com.example.skillsauditor.user.domain.common.Staff;
import com.example.skillsauditor.user.domain.common.staffSkill.StaffSkill;
import com.example.skillsauditor.user.infrastructure.staff.StaffJpa;
import com.example.skillsauditor.user.infrastructure.staff.StaffSkillJpa;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

@Component
public class StaffToStaffJpaConvertor implements INFStaffToStaffJpaConvertor {

    @Override
    public StaffJpa convert(Staff staff) {
        StaffJpa staffJpa = StaffJpa.staffJpaOf(staff.id().id(), staff.getFullName().getFirstName(), staff.getFullName().getSurname(), staff.getLoginDetails().getUsername(), staff.getLoginDetails().getPassword(), staff.getJobRole().toString(), staff.getAddress().getHouseNameNumber(), staff.getAddress().getStreet(), staff.getAddress().getTown(), staff.getAddress().getPostcode());

        for(StaffSkill staffSkill : staff.getAllSkills()){
            LocalDate expiryDate = convertExpiryDateToLocalDate(staffSkill);

            StaffSkillJpa staffSkillJpa = new StaffSkillJpa(staffSkill.getId(), staffSkill.getStaffId(), staffSkill.getSkillId(), staffSkill.getStrengthOfSkill().toString(), expiryDate);
            staffSkillJpa.setId(staffSkill.getId());
            staffSkillJpa.setStaffId(staffJpa.getId());

            staffJpa.addStaffSkill(staffSkillJpa);
        }
        return staffJpa;
    }

    private LocalDate convertExpiryDateToLocalDate(StaffSkill skill) {
        LocalDate expiryDate = LocalDate.of(skill.getExpiryDate().getYear(), skill.getExpiryDate().getMonth(),1);
        expiryDate.with(lastDayOfMonth());
        return expiryDate;
    }
}
