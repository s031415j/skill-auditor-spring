package com.example.skillsauditor.user.application.staffSkill.DTO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class StaffSkillDTO {

    private String id;
    private String staffId;
    private String skillId;
    private String strengthOfSkill;
    private String expiryDate;
}
