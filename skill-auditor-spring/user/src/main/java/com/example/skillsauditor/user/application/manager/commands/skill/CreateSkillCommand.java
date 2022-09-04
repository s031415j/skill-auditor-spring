package com.example.skillsauditor.user.application.manager.commands.skill;

import com.example.skillsauditor.user.domain.manager.interfaces.commands.skill.INFCreateSkillCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateSkillCommand implements INFCreateSkillCommand {

    private String id;
    private String username;
    private String token;

    private String name;
    private String categoryId;
}
