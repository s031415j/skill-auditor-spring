package com.example.skill.application.category.events;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
@ToString
public class NewCategoryAddedDomainEvent extends ApplicationEvent {

    private String aggregateId;
    private String name;
    private String categoryId;

    public NewCategoryAddedDomainEvent(Object source, String aggregateId, String name){
        super(source);
        this.aggregateId = aggregateId;
        this.name = name;
    }
}
