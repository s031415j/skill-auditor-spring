package com.example.skillsauditor.user.application.staff.staffSkill.DTO;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
@ToString
@AllArgsConstructor
public class StaffSkillDTOList {

    private List<StaffSkillDTO> staffSkills;

    public StaffSkillDTOList() {
        this.staffSkills = new ArrayList<>();
    }

}
