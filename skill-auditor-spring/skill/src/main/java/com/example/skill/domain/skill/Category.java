package com.example.skill.domain.skill;

import com.example.skill.application.category.events.DeleteCategoryDomainEvent;
import com.example.skill.application.category.events.NewCategoryAddedDomainEvent;
import com.example.skill.domain.common.Entity;
import com.example.skill.domain.common.Identity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category extends Entity {

    private String name;

    public Category(Identity id){
        super(id);
        this.addDomainEvent(new DeleteCategoryDomainEvent(this, id.id()));
    }
    public Category(Identity id, String name){
        super(id);
        setName(name);
        this.addDomainEvent(new NewCategoryAddedDomainEvent(this, id.id(), name));
    }

    public static Category categoryOf(Identity id, String name){
        return new Category(id, name);
    }

    private void setName(String name) {
        assertArgumentNotEmpty(name, "Category name must not be null");
        this.name = name;
    }

    public static Category delete(Identity identity){
        return new Category(identity);
    }

    public Identity id(){
        return this.id();
    }

    public String getName(){
        return this.name;
    }
}
