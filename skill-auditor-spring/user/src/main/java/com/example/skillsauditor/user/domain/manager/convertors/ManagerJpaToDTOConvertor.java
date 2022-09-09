package com.example.skillsauditor.user.domain.manager.convertors;

import com.example.skillsauditor.user.application.manager.DTO.TeamMemberDTO;
import com.example.skillsauditor.user.application.staff.staffSkill.DTO.StaffSkillDTO;
import com.example.skillsauditor.user.domain.common.staff.convertors.StaffJpaToDTOConvertor;
import com.example.skillsauditor.user.domain.manager.interfaces.INFManagerJpa;
import com.example.skillsauditor.user.infrastructure.manager.ManagerTeamJpa;

import java.util.ArrayList;
import java.util.List;

public class ManagerJpaToDTOConvertor {

    private ManagerJpaToDTOConvertor(){

    }

    public static List<TeamMemberDTO> convertManagerTeamToDTO(INFManagerJpa managerJpa) {
        List<TeamMemberDTO> team = new ArrayList<>();
        for (ManagerTeamJpa mTeam: managerJpa.getTeam()) {

            List<StaffSkillDTO> staffSkills = StaffJpaToDTOConvertor.convertStaffSkillsToDTO(mTeam.getStaff());
            TeamMemberDTO managerTeamDTO = new TeamMemberDTO(
                    mTeam.getStaff().getId(),
                    mTeam.getStaff().getFullNameFirstname(),
                    mTeam.getStaff().getFullNameSurname(),
                    staffSkills);

            team.add(managerTeamDTO);
        }
        return team;
    }
}
