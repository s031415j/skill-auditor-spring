package com.example.skillsauditor.user.application.manager.commands.category;

import com.example.skillsauditor.user.domain.manager.interfaces.commands.category.INFCreateCategoryCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateCategoryCommand implements INFCreateCategoryCommand {

    private String id;
    private String username;
    private String token;

    private String name;
}
