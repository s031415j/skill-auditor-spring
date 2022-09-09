package com.example.skillsauditor.user.domain.common.staff.staffSkill;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StrengthOfSkill {

    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    PROFESSIONAL("Professional");

    private final String strengthOfSkill;

    public String getStrength() {
        return strengthOfSkill;
    }
}

