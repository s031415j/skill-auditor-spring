package com.example.skillsauditor.user.domain.common.staff.convertors;

import com.example.skillsauditor.user.application.staff.interfaces.INFStaffToStaffJpaConvertor;
import com.example.skillsauditor.user.domain.common.staff.Staff;
import com.example.skillsauditor.user.domain.common.staff.interfaces.INFStaffJpa;
import com.example.skillsauditor.user.domain.common.staffSkill.StaffSkill;
import com.example.skillsauditor.user.infrastructure.staff.StaffJpa;
import com.example.skillsauditor.user.infrastructure.staffSkill.StaffSkillJpa;
import org.springframework.stereotype.Component;

@Component
public class StaffToStaffJpaConvertor implements INFStaffToStaffJpaConvertor {

    public INFStaffJpa convert(Staff staff) {

        INFStaffJpa staffJpa = StaffJpa.staffJpaOf(staff.getId().toString(), staff.getFullName().getFirstName(), staff.getFullName().getSurname(),
              staff.getLoginDetails().getUsername(), staff.getLoginDetails().getPassword(), staff.getJobRole(), staff.getManager(), staff.getFullAddress().getHouseNameNumber(),
               staff.getFullAddress().getStreet(), staff.getFullAddress().getTown(), staff.getFullAddress().getPostcode());

        for(StaffSkill staffSkill : staff.retrieveAllStaffSkills()){
            StaffSkillJpa staffSkillJpa = new StaffSkillJpa(staffSkill.getId().toString(), staffSkill.getStaffId(), staffSkill.getSkillId(), staffSkill.getStrengthOfSkill(), staffSkill.getExpiryDate());

            staffSkillJpa.setId(staffSkill.getId().toString());
            staffSkillJpa.setStaffId(staffSkill.getStaffId());

            staffJpa.addStaffSkill(staffSkillJpa);
        }

        return staffJpa;
    }
}
