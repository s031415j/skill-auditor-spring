package com.example.skillsauditor.user.application.manager;

import com.example.skillsauditor.user.application.manager.DTO.TeamMemberDTO;
import com.example.skillsauditor.user.application.manager.interfaces.INFManagerJpaToManagerConvertor;
import com.example.skillsauditor.user.application.manager.interfaces.INFManagerRepository;
import com.example.skillsauditor.user.application.staff.DTO.StaffDTO;
import com.example.skillsauditor.user.application.staff.staffSkill.DTO.StaffSkillDTO;
import com.example.skillsauditor.user.application.staff.staffSkill.DTO.StaffSkillDTOList;
import com.example.skillsauditor.user.domain.common.staff.staffSkill.ExpiryDate;
import com.example.skillsauditor.user.domain.common.staff.staffSkill.StrengthOfSkill;
import com.example.skillsauditor.user.domain.manager.Manager;
import com.example.skillsauditor.user.domain.manager.ManagerTeam;
import com.example.skillsauditor.user.infrastructure.manager.ManagerJpa;
import com.example.skillsauditor.user.infrastructure.manager.ManagerTeamJpa;
import com.example.skillsauditor.user.infrastructure.staff.StaffSkillJpa;
import com.example.skillsauditor.user.ui.manager.interfaces.INFManagerQueryHandler;
import com.example.skillsauditor.user.ui.staff.interfaces.INFStaffQueryHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ManagerQueryHandler implements INFManagerQueryHandler {

    private INFStaffQueryHandler queryHandler;
    private INFManagerRepository managerRepository;
    private INFManagerJpaToManagerConvertor managerJpaToManagerConvertor;



    @Override
    public StaffSkillDTOList findSkillsByCategory(String categoryId) {
        return null;
    }

    @Override
    public List<?> findAllWithExpiredSkills() {
       List<StaffDTO> staff = queryHandler.findAllStaffWithExpiredSkills();

       if(!staff.isEmpty()){
           return staff;
       }else{
           return new ArrayList<>();
       }
    }

    @Override
    public List<ManagerTeam> findTeamMembersByManagerId(String managerId) {
        Optional<ManagerJpa> managerJpa = managerRepository.findById(managerId);
        if(managerJpa.isPresent()) {
            Manager manager = managerJpaToManagerConvertor.convert(managerJpa.get());
            return manager.getTeam();
        }
        return new ArrayList<>();
    }

    @Override
    public List<TeamMemberDTO> findTeamMembersBySkillId(String managerId, String skillId) {
        Optional<ManagerJpa> managerJpa = managerRepository.findById(managerId);

        if(managerJpa.isPresent()){
            List<TeamMemberDTO> teamMember = convertManagerTeamJpaToDTO(managerJpa.get());
            List<TeamMemberDTO> teamMembersWithSkill = new ArrayList<>();

            teamMember.forEach(team -> team.getSkills().forEach(skill -> {
                if(skill.getSkillId().equals(skillId)) {
                    teamMembersWithSkill.add(team);
                }
            } ));
            return teamMembersWithSkill;
        }
        return new ArrayList<>();
    }
    private List<TeamMemberDTO> convertManagerTeamJpaToDTO(ManagerJpa managerJpa) {
        List<TeamMemberDTO> team = new ArrayList<>();

        for (ManagerTeamJpa mtj : managerJpa.getTeam()) {
            List<StaffSkillDTO> staffSkills = convertStaffSkillsToDTO(mtj);
            TeamMemberDTO teamMember = new TeamMemberDTO(
                    String.valueOf(mtj.getId()),
                    mtj.getFullNameFirstname(),
                    mtj.getFullNameSurname(),
                    staffSkills
            );
            team.add(teamMember);
        }
        return team;
    }



    private List<StaffSkillDTO> convertStaffSkillsToDTO(ManagerTeamJpa mtj) {

        List<StaffSkillDTO> skills = new ArrayList<>();

        for (StaffSkillJpa staffSkillJpa : mtj.getStaff().getStaffSkills()) {
            ExpiryDate expiryDate = new ExpiryDate(staffSkillJpa.getExpiryDate().getMonthValue(), staffSkillJpa.getExpiryDate().getYear());
            StaffSkillDTO skill = new StaffSkillDTO(staffSkillJpa.getSkillId(), StrengthOfSkill.valueOf(staffSkillJpa.getStrengthOfSkill().toUpperCase()), expiryDate);
            skills.add(skill);
        }
        return skills;
    }

}
