package com.example.skillsauditor.user.application.manager.commands.category;

import com.example.skillsauditor.user.domain.manager.interfaces.commands.category.INFDeleteCategoryCommand;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteCategoryCommand implements INFDeleteCategoryCommand {

    private String id;
    private String token;
    private String username;

    private String categoryId;
}
