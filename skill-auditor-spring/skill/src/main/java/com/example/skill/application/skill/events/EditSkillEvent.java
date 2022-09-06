package com.example.skill.application.skill.events;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditSkillEvent {

    private String id;
    private String name;
    private String categoryId;
}
