package com.example.skill.domain.skill;

import com.example.skill.application.skill.events.NewSkillAddedDomainEvent;
import com.example.skill.domain.common.Entity;
import com.example.skill.domain.common.Identity;
import lombok.ToString;

@ToString
public class Skill extends Entity {

    private String name;
    private String categoryId;


    public Skill(Identity id, String name, String categoryId){
        super(id);
        setName(name);
        this.categoryId = categoryId;
        this.addDomainEvent(new NewSkillAddedDomainEvent(this, id.id(), name, categoryId));
    }

    public static Skill skillOf(Identity id, String name, String categoryId){
        return new Skill(id, name, categoryId);
    }

    private void setName(String name){
        this.assertArgumentNotEmpty(name, "Skill name cannot be empty.");
        this.name = name;
    }

    public Identity id(){
        return this.id();
    }

    public String getName(){
        return this.name;
    }

    public String getCategoryId(){
        return this.categoryId;
    }

    public void editName(String name){
        this.name = name;
    }

    public void editCategory(String categoryId){
        this.categoryId = categoryId;
    }

}
