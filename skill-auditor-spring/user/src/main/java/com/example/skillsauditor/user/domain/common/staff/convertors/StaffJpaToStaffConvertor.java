package com.example.skillsauditor.user.domain.common.staff.convertors;


import com.example.skillsauditor.user.application.staff.interfaces.INFStaffJpaToStaffConvertor;
import com.example.skillsauditor.user.domain.common.Identity;
import com.example.skillsauditor.user.domain.common.staff.Address;
import com.example.skillsauditor.user.domain.common.staff.FullName;
import com.example.skillsauditor.user.domain.common.staff.LoginDetails;
import com.example.skillsauditor.user.domain.common.staff.Staff;
import com.example.skillsauditor.user.domain.common.staff.interfaces.INFStaffJpa;
import com.example.skillsauditor.user.domain.common.staffSkill.StaffSkill;
import com.example.skillsauditor.user.infrastructure.staff.StaffSkillJpaValueObject;
import org.springframework.stereotype.Component;

@Component
public class StaffJpaToStaffConvertor implements INFStaffJpaToStaffConvertor {

    public Staff convert(INFStaffJpa staffJpa) {
        Identity identity = new Identity(staffJpa.getId());
        FullName fullName = new FullName(staffJpa.getFullNameFirstname(), staffJpa.getFullNameSurname());
        Address address = new Address(staffJpa.getAddressHouseNameNumber(), staffJpa.getAddressStreet(),
                staffJpa.getAddressTown(), staffJpa.getAddressPostcode());
        LoginDetails loginDetails = new LoginDetails(staffJpa.getLoginDetailsUsername(), staffJpa.getLoginDetailsPassword());
        Staff staff = Staff.staffOf(identity, fullName, loginDetails, staffJpa.getJobRole(), staffJpa.getManager(), address);

        for(StaffSkillJpaValueObject staffSkillJpa : staffJpa.getStaffSkills()){
            StaffSkill staffSkill = new StaffSkill(identity, staffSkillJpa.getStaffId(), staffSkillJpa.getSkillId(), staffSkillJpa.getStrengthOfSkill(), staffSkillJpa.getExpiryDate());
            staff.addStaffSkill(staffSkill);
        }
        return staff;
    }
}
