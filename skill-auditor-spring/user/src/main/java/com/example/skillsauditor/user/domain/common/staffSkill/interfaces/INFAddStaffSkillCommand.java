package com.example.skillsauditor.user.domain.common.staffSkill.interfaces;

import com.example.skillsauditor.user.domain.common.staffSkill.ExpiryDate;

public interface INFAddStaffSkillCommand {

    String getStaffId();
    String getSkillId();
    String getStrengthOfSkill();
    ExpiryDate getExpiryDate();
}
