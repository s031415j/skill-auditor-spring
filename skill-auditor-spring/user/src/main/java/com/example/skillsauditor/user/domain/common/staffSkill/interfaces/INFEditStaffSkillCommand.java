package com.example.skillsauditor.user.domain.common.staffSkill.interfaces;

import com.example.skillsauditor.user.domain.common.staffSkill.ExpiryDate;

public interface INFEditStaffSkillCommand {

    String getStaffId();
    String getSkillId();
    String getStrengthOfSkill();
    ExpiryDate getExpiryDate();

}
