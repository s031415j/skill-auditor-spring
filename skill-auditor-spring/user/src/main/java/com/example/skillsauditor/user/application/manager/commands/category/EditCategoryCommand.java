package com.example.skillsauditor.user.application.manager.commands.category;

import com.example.skillsauditor.user.domain.manager.interfaces.commands.category.INFEditCategoryCommand;

public class EditCategoryCommand implements INFEditCategoryCommand {

    private String id;
    private String token;
    private String username;

    private String categoryId;
    private String name;
}
