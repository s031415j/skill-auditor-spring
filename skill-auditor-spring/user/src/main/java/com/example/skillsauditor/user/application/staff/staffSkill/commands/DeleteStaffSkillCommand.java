package com.example.skillsauditor.user.application.staff.staffSkill.commands;

import com.example.skillsauditor.user.domain.common.staff.staffSkill.interfaces.INFDeleteStaffSkillCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeleteStaffSkillCommand implements INFDeleteStaffSkillCommand {

    private String userId;
    private String token;
    private String username;

    private String staffId;
    private String skillId;

}
