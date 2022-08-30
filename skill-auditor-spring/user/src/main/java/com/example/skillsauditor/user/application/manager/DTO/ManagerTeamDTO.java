package com.example.skillsauditor.user.application.manager.DTO;

import com.example.skillsauditor.user.application.staffSkill.DTO.StaffSkillDTO;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class ManagerTeamDTO {

    private String staffId;
    private String staffFirstName;
    private String staffSurname;
    private List<StaffSkillDTO> skills;
}
