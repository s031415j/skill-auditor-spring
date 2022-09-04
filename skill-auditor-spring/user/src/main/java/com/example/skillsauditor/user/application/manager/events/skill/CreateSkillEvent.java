package com.example.skillsauditor.user.application.manager.events.skill;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateSkillEvent {

    String id;
    String name;
    String categoryId;
}
