package com.example.skill.application.skill.events;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class NewSkillAddedDomainEvent extends ApplicationEvent {

    private String aggregateId;
    private String name;
    private String categoryId;

    public NewSkillAddedDomainEvent(Object source, String aggregateId, String name, String categoryId){
        super(source);
        this.aggregateId = aggregateId;
        this.name = name;
        this.categoryId = categoryId;
    }
}
