package com.example.skillsauditor.user.application.staff.staffSkill.DTO;

import com.example.skillsauditor.user.domain.common.staffSkill.ExpiryDate;
import com.example.skillsauditor.user.domain.common.staffSkill.StrengthOfSkill;
import lombok.*;

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
