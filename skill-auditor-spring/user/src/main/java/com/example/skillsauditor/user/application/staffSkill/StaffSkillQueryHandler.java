package com.example.skillsauditor.user.application.staffSkill;

import com.example.skillsauditor.user.application.staffSkill.DTO.StaffSkillDTO;
import com.example.skillsauditor.user.application.staffSkill.interfaces.INFStaffSkillRepository;
import com.example.skillsauditor.user.application.staffSkill.interfaces.INFStaffSkillJpa;
import com.example.skillsauditor.user.infrastructure.staffSkill.StaffSkillJpa;
import com.example.skillsauditor.user.ui.staffSkill.INFStaffSkillQueryHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class StaffSkillQueryHandler implements INFStaffSkillQueryHandler {

    private INFStaffSkillRepository staffSkillRepository;

    public Iterable<StaffSkillJpa> findAllStaffSkill(){
        return staffSkillRepository.findAllStaffSkill();
    }

    public Optional<StaffSkillDTO> findStaffSkillByStaffId(UUID staffId) {
        Optional<StaffSkillJpa> result = staffSkillRepository.findStaffSkillByStaffId(staffId);
        if(result.isPresent()){
            return convertStaffSkillDetailsToDTO(result.get());
        }
        return Optional.empty();
    }

    public Optional<StaffSkillDTO> findStaffSkillBySkillId(UUID skillId) {
        Optional<StaffSkillJpa> result = staffSkillRepository.findStaffSkillBySkillId(skillId);
        if(result.isPresent()){
            return convertStaffSkillDetailsToDTO(result.get());
        }
        return Optional.empty();
    }

    @Override
    public List<?> findStaffSkillsByStaffId(String staffId) {
        List<StaffSkillJpa> result = staffSkillRepository.findStaffSkillsByStaffId(staffId);
    }

    public Optional<StaffSkillDTO> convertStaffSkillDetailsToDTO(INFStaffSkillJpa staffSkill) {
        StaffSkillDTO staffSkillDTO = new StaffSkillDTO(staffSkill.getId(), staffSkill.getStaffId(), staffSkill.getSkillId(), staffSkill.getStrengthOfSkill().toString(), staffSkill.getExpiryDate().toString());
        return Optional.of(staffSkillDTO);
    }
}
