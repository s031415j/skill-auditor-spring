package com.example.skillsauditor.user.application.staff.staffSkill.commands;

import com.example.skillsauditor.user.domain.common.staff.staffSkill.ExpiryDate;
import com.example.skillsauditor.user.domain.common.staff.staffSkill.StrengthOfSkill;
import com.example.skillsauditor.user.domain.common.staff.staffSkill.interfaces.INFAddStaffSkillCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddStaffSkillCommand implements INFAddStaffSkillCommand {

    private String userId;
    private String token;
    private String username;

    private String staffId;
    private String skillId;
    private String strengthOfSkill;
    private ExpiryDate expiryDate;


}
