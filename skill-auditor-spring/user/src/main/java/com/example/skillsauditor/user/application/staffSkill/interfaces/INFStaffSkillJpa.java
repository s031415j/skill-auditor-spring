package com.example.skillsauditor.user.application.staffSkill.interfaces;

import com.example.skillsauditor.user.domain.common.staff.interfaces.INFStaffJpa;
import com.example.skillsauditor.user.domain.common.staffSkill.StrengthOfSkill;
import com.example.skillsauditor.user.infrastructure.staffSkill.StaffSkillJpa;

import java.util.Date;

public interface INFStaffSkillJpa {

    String getId();
    String getStaffId();
    String getSkillId();
    StrengthOfSkill getStrengthOfSkill();
    Date getExpiryDate();

//    void setId(String id);
//    void setStaffId(String staffId);

}
