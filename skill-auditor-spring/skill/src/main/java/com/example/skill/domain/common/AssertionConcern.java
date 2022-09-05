package com.example.skill.domain.common;

import java.time.LocalDate;
import java.util.UUID;

public class AssertionConcern {

    protected AssertionConcern(){
        super();
    }

    //IllegalArgumentException if not valid
    protected void assertArgumentIsUUID(String id) throws IllegalArgumentException{
        UUID.fromString(id.trim());
    }

    protected void assertArgumentLength(String aString, int aMaximum, String aMessage){
        int length = aString.trim().length();

        if(length > aMaximum) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    protected void assertArgumentNotEmpty(String aString, String aMessage){
        if(aString == null || aString.trim().isEmpty()){
            throw new IllegalArgumentException(aMessage);
        }
    }

    protected void assertDateIsBefore(LocalDate dataBeingChecked, LocalDate dataMustBeBefore, String aMessage){
        if(dataBeingChecked.isBefore(dataMustBeBefore)){
            throw new IllegalArgumentException(aMessage);
        }
    }

    protected void assertMatches(String aString, String aPattern, String aMessage){
        if(!aString.matches(aPattern)){
            throw new IllegalArgumentException(aMessage);
        }
    }
}
