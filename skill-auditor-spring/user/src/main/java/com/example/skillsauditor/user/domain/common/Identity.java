package com.example.skillsauditor.user.domain.common;

public class Identity extends ValueObject {

    protected String id;

    public Identity(String id){
        setID(id);
    }

    private void setID(String id){
        this.assertArgumentNotEmpty(id,"id cannot be empty");
        this.id = id;
    }

    public String id(){
        return id;
    }

    public String toString(){
        return id;
    }
}
