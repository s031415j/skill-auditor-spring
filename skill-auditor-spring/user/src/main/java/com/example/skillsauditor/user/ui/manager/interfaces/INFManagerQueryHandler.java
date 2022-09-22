package com.example.skillsauditor.user.ui.manager.interfaces;

import com.example.skillsauditor.user.application.manager.DTO.TeamMemberDTO;
import com.example.skillsauditor.user.application.staff.staffSkill.DTO.StaffSkillDTOList;
import com.example.skillsauditor.user.domain.manager.ManagerTeam;

import java.util.List;

public interface INFManagerQueryHandler {

    StaffSkillDTOList findSkillsByCategory(String categoryId);

    List<?> findAllWithExpiredSkills();
    List<ManagerTeam> findTeamMembersByManagerId(String managerId);

    List<TeamMemberDTO> findTeamMembersBySkillId(String managerId, String skillId);


}
