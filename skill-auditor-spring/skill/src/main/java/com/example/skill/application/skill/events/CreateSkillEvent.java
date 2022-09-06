package com.example.skill.application.skill.events;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSkillEvent {

    private String id;
    private String name;
    private String categoryId;

}
