package com.example.skillsauditor.user.domain.common.staff.staffSkill;

import com.example.skillsauditor.user.domain.common.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ExpiryDate extends ValueObject {

    private int month;
    private int year;

    public ExpiryDate(){

    }
    private void setExpiryYear(int year) {
        if (year > LocalDate.now().getYear()) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("Skill has expired");
        }
    }

    private void setExpiryMonth(int month) {
        if (month > 1 && month < 12) {
            this.month = month;
        } else {
            throw new IllegalArgumentException("Invalid month");
        }
    }

    public void setExpiry(int month, int year) {
        this.month = month;
        this.year = year;
    }

//    public boolean equals(Object o){
//
//        if (o == null && o.getClass() != this.getClass()){
//            return false;
//        }
//
//        ExpiryDate expiryDate = (ExpiryDate) o;
//
//        boolean isExpiryMonth = expiryDate.month==this.month;
//        boolean isExpiryYear = expiryDate.year==this.year;
//
//        return isExpiryMonth && isExpiryYear;
//    }
}
