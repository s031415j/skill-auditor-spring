package com.example.skillsauditor.user.application.manager;

import com.example.skillsauditor.user.application.manager.DTO.TeamMemberDTO;
import com.example.skillsauditor.user.application.staff.staffSkill.DTO.StaffSkillDTOList;
import com.example.skillsauditor.user.domain.manager.ManagerTeam;
import com.example.skillsauditor.user.ui.manager.interfaces.INFManagerQueryHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ManagerQueryHandler implements INFManagerQueryHandler {

    @Override
    public List<ManagerTeam> findTeamMembersByManagerId(String managerId) {
        return null;
    }

    @Override
    public List<TeamMemberDTO> findTeamMembersBySkillId(String managerId, String skillId) {
        return null;
    }

    @Override
    public StaffSkillDTOList findSkillsByCategory(String categoryId) {
        return null;
    }

    @Override
    public List<?> findAllWithExpiredSkills() {
        return null;
    }
}
