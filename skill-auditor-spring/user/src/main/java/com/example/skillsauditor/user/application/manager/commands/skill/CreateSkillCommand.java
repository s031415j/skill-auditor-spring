package com.example.skillsauditor.user.application.manager.commands.skill;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateSkillCommand{

    private String id;
    private String username;
    private String token;

    private String description;
    private String categoryId;
}
