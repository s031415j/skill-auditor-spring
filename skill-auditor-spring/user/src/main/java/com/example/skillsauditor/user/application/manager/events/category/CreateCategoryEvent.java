package com.example.skillsauditor.user.application.manager.events.category;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateCategoryEvent {

    private String id;
    private String name;
}
