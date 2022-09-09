package com.example.skillsauditor.user.application.staff.staffSkill.DTO;

import com.example.skillsauditor.user.domain.common.staff.staffSkill.ExpiryDate;
import com.example.skillsauditor.user.domain.common.staff.staffSkill.StrengthOfSkill;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class StaffSkillDTO {

    private String skillId;
    private StrengthOfSkill strengthOfSkill;
    private ExpiryDate expiryDate;

}
