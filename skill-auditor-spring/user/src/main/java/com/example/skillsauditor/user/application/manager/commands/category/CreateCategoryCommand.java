package com.example.skillsauditor.user.application.manager.commands.category;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateCategoryCommand {

    private String id;
    private String username;
    private String token;

    private String name;
}
