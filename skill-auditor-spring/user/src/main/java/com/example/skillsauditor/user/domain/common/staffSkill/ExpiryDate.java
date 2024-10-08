package com.example.skillsauditor.user.domain.common.staffSkill;

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

    public boolean equals(Object o){
        if (o == null && o.getClass() != this.getClass()){
            return false;
        }
        ExpiryDate expirationDate = (ExpiryDate) o;

        return expirationDate.month==this.month &&
                expirationDate.year==this.year;
    }

    public void setExpiry(int month, int year) {
        this.month = month;
        this.year = year;
    }
}
