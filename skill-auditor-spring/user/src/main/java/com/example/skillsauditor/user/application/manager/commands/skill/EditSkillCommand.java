package com.example.skillsauditor.user.application.manager.commands.skill;

import com.example.skillsauditor.user.domain.manager.interfaces.commands.skill.INFEditSkillCommand;

public class EditSkillCommand implements INFEditSkillCommand {

    private String id;
    private String token;
    private String username;

    private String skillId;
    private String name;
}
