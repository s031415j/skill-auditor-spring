package com.example.skillsauditor.user.application.manager.events.skill;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EditSkillEvent {

    private String id;
    private String name;
    private String categoryId;
}
