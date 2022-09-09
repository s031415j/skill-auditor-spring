package com.example.skillsauditor.user.domain.common.staff.convertors;

import com.example.skillsauditor.user.application.staff.DTO.StaffDTO;
import com.example.skillsauditor.user.application.staff.staffSkill.DTO.StaffSkillDTO;
import com.example.skillsauditor.user.domain.common.staff.JobRole;
import com.example.skillsauditor.user.domain.common.staff.interfaces.INFStaffJpa;
import com.example.skillsauditor.user.domain.common.staff.staffSkill.ExpiryDate;
import com.example.skillsauditor.user.domain.common.staff.staffSkill.StrengthOfSkill;
import com.example.skillsauditor.user.infrastructure.staff.StaffJpa;
import com.example.skillsauditor.user.infrastructure.staff.StaffSkillJpa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StaffJpaToDTOConvertor {

    public static List<StaffSkillDTO> convertStaffSkillsToDTO(INFStaffJpa staffJpa) {
        List<StaffSkillDTO> skills = new ArrayList<>();

        for (StaffSkillJpa staffSkillJpa : staffJpa.getStaffSkills()) {
            ExpiryDate expiryDate = new ExpiryDate(staffSkillJpa.getExpiryDate().getMonthValue(), staffSkillJpa.getExpiryDate().getYear());
            StaffSkillDTO skill = new StaffSkillDTO(staffSkillJpa.getSkillId(), StrengthOfSkill.valueOf(staffSkillJpa.getStrengthOfSkill().toUpperCase()), expiryDate);
            skills.add(skill);
        }
        return skills;
    }

    public static List<StaffDTO> convertStaffJpaListToDTO(Iterable<StaffJpa> result) {
        List<StaffDTO> staff = new ArrayList<>();

        for (StaffJpa staffJpa : result) {
            List<StaffSkillDTO> skills = getListOfExpiredSkills(staffJpa);
            JobRole jobRole = JobRole.valueOf(staffJpa.getJobRole());
            StaffDTO staffDTO = new StaffDTO(staffJpa.getId(), staffJpa.getFullNameFirstname(), staffJpa.getFullNameSurname(), staffJpa.getLoginDetailsUsername(), staffJpa.getLoginDetailsPassword(), jobRole, staffJpa.getAddressHouseNameNumber(), staffJpa.getAddressStreet(), staffJpa.getAddressTown(), staffJpa.getAddressPostcode(), skills);
            staff.add(staffDTO);
        }
        return staff;
    }

    public static List<StaffSkillDTO> getListOfExpiredSkills(StaffJpa staffJpa) {
        List<StaffSkillDTO> staffSkills = new ArrayList<>();

        for (StaffSkillJpa staffSkillJpa : staffJpa.getStaffSkills()) {
            if (skillExpired(staffSkillJpa)) {
                ExpiryDate expiryDate = setExpiryDate(staffSkillJpa);

                StaffSkillDTO skill = new StaffSkillDTO(staffSkillJpa.getSkillId(), StrengthOfSkill.valueOf(staffSkillJpa.getStrengthOfSkill()), expiryDate);
                staffSkills.add(skill);
            }
        }
        return staffSkills;
    }


    private static boolean skillExpired(StaffSkillJpa staffSkillJpa) {
        return staffSkillJpa.getExpiryDate().isBefore(LocalDate.now());
    }

    private static ExpiryDate setExpiryDate(StaffSkillJpa staffSkillJpa) {

        ExpiryDate expiryDate = new ExpiryDate();
        expiryDate.setExpiry(staffSkillJpa.getExpiryDate().getMonthValue(), staffSkillJpa.getExpiryDate().getYear());
        return expiryDate;
    }

}
