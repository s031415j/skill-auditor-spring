package com.example.skillsauditor.user.application.staff.staffSkill.commands;

import com.example.skillsauditor.user.domain.common.staffSkill.ExpiryDate;
import com.example.skillsauditor.user.domain.common.staffSkill.interfaces.INFEditStaffSkillCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EditStaffSkillCommand implements INFEditStaffSkillCommand {

    private String userId;
    private String token;
    private String username;

    private String staffId;
    private String skillId;
    private String strengthOfSkill;
    private ExpiryDate expiryDate;
}
