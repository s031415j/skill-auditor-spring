package com.example.skillsauditor.user.application.manager.DTO;

import com.example.skillsauditor.user.application.staff.DTO.StaffDTO;
import com.example.skillsauditor.user.application.staff.staffSkill.DTO.StaffSkillDTO;
import com.example.skillsauditor.user.domain.common.JobRole;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
public class ManagerDTO extends StaffDTO {

    private List<TeamMemberDTO> team;

    private ManagerDTO(String id, String fullNameFirstname, String fullNameSurname, String loginDetailsUsername, String loginDetailsPassword, JobRole jobRole, String addressHouseNameNumber, String addressStreet, String addressTown, String addressPostcode, List<StaffSkillDTO> skills) {
        super(id, fullNameFirstname, fullNameSurname, loginDetailsUsername, loginDetailsPassword, jobRole, addressHouseNameNumber, addressStreet, addressTown, addressPostcode, skills);
        this.team = team;
    }

}
