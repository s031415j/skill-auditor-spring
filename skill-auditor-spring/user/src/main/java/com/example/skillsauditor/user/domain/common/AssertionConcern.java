package com.example.skillsauditor.user.domain.common;


import java.time.LocalDate;

//validation
public class AssertionConcern {

    protected AssertionConcern(){
        super();
    }

    protected void assertArgumentLength(String aString, int aMinimum, int aMaximum, String aMessage) {
        int length = aString.trim().length();
        if (length < aMinimum || length > aMaximum) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    protected void assertArgumentNotEmpty(String aString, String aMessage) {
        if (aString == null || aString.trim().isEmpty()) {
            throw new IllegalArgumentException(aMessage);
        }
    }

    protected void assertDateIsBefore(LocalDate dateBeingChecked, LocalDate dateMustBeBefore, String aMessage) {
        if (dateBeingChecked.isBefore(dateMustBeBefore)) {
            throw new IllegalArgumentException(aMessage);
        }
    }

}
