package com.example.skill.domain.common;

import lombok.ToString;

@ToString
public class Identity extends ValueObject{

    protected String id;

    public Identity(String id){
        setId(id);
    }

    public void setId(String id){
        this.assertArgumentNotEmpty(id, "id cannot be empty");
        this.id = id;
    }

    public String id(){
        return id;
    }

}
