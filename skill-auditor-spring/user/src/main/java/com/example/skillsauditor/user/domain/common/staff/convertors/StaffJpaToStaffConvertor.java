package com.example.skillsauditor.user.domain.common.staff.convertors;


import com.example.skillsauditor.user.application.staff.DTO.StaffDTO;
import com.example.skillsauditor.user.application.staff.interfaces.INFStaffJpaToStaffConvertor;
import com.example.skillsauditor.user.application.staff.staffSkill.DTO.StaffSkillDTO;
import com.example.skillsauditor.user.domain.common.Identity;
import com.example.skillsauditor.user.domain.common.staff.*;
import com.example.skillsauditor.user.domain.common.staff.interfaces.INFStaffJpa;
import com.example.skillsauditor.user.domain.common.staff.staffSkill.ExpiryDate;
import com.example.skillsauditor.user.domain.common.staff.staffSkill.StaffSkill;
import com.example.skillsauditor.user.domain.common.staff.staffSkill.StrengthOfSkill;
import com.example.skillsauditor.user.infrastructure.staff.StaffJpa;
import com.example.skillsauditor.user.infrastructure.staff.StaffSkillJpa;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class StaffJpaToStaffConvertor implements INFStaffJpaToStaffConvertor {

    public Staff convert(StaffJpa staffJpa) {
        Identity identity = new Identity(staffJpa.getId());
        FullName fullName = new FullName(staffJpa.getFullNameFirstname(), staffJpa.getFullNameSurname());
        LoginDetails loginDetails = new LoginDetails(staffJpa.getLoginDetailsUsername(), staffJpa.getLoginDetailsPassword());
        Address address = new Address(staffJpa.getAddressHouseNameNumber(), staffJpa.getAddressStreet(), staffJpa.getAddressTown(), staffJpa.getAddressPostcode());
        JobRole jobRole = JobRole.valueOf(staffJpa.getJobRole());

        Staff staff = Staff.staffOf(identity, fullName, loginDetails, jobRole , address);

        for (StaffSkillJpa staffSkillJpa : staffJpa.getStaffSkills()) {
            ExpiryDate expiryDate = new ExpiryDate(staffSkillJpa.getExpiryDate().getMonthValue(), staffSkillJpa.getExpiryDate().getYear());
            StrengthOfSkill strength = StrengthOfSkill.valueOf(staffSkillJpa.getStrengthOfSkill());
            StaffSkill staffSkill = new StaffSkill(staffSkillJpa.getStaffId(), staffSkillJpa.getSkillId(), strength, expiryDate);

            staffSkill.setId(staffSkillJpa.getId());
            staff.addStaffSkill(staffSkill);
        }
        return staff;
    }
}

