package com.example.skillsauditor.user.domain.common.staff.staffSkill.interfaces;

import com.example.skillsauditor.user.domain.common.staff.staffSkill.ExpiryDate;

public interface INFEditStaffSkillCommand {

    String getStaffId();
    String getSkillId();
    String getStrengthOfSkill();
    ExpiryDate getExpiryDate();

}
