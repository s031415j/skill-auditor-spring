package com.example.skillsauditor.user.application.manager.commands.skill;

import com.example.skillsauditor.user.domain.manager.interfaces.commands.skill.INFEditSkillCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EditSkillCommand implements INFEditSkillCommand {

    private String id;
    private String token;
    private String username;

    private String skillId;
    private String name;

}
