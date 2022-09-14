package com.example.skillsauditor.user.application.staff;

import com.example.skillsauditor.user.application.staff.interfaces.INFStaffJpaToStaffConvertor;
import com.example.skillsauditor.user.application.staff.interfaces.INFStaffRepository;
import com.example.skillsauditor.user.application.staff.interfaces.INFStaffToStaffJpaConvertor;
import com.example.skillsauditor.user.domain.common.staff.Staff;
import com.example.skillsauditor.user.domain.common.staff.interfaces.INFEditStaffCommand;
import com.example.skillsauditor.user.domain.common.staff.staffSkill.StaffSkill;
import com.example.skillsauditor.user.domain.common.staff.staffSkill.StrengthOfSkill;
import com.example.skillsauditor.user.domain.common.staff.staffSkill.interfaces.INFAddStaffSkillCommand;
import com.example.skillsauditor.user.domain.common.staff.staffSkill.interfaces.INFDeleteStaffSkillCommand;
import com.example.skillsauditor.user.domain.common.staff.staffSkill.interfaces.INFEditStaffSkillCommand;
import com.example.skillsauditor.user.infrastructure.staff.StaffJpa;
import com.example.skillsauditor.user.ui.staff.interfaces.INFStaffApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StaffApplicationService implements INFStaffApplicationService {
    private INFStaffRepository staffRepository;
    private INFStaffJpaToStaffConvertor staffJpaToStaffConvertor;
    private INFStaffToStaffJpaConvertor staffToStaffJpaConvertor;


    @Override
    public void deleteStaffSkill(INFDeleteStaffSkillCommand deleteStaffSkillCommand) {
        Optional<StaffJpa> staffJpa = staffRepository.findById(deleteStaffSkillCommand.getStaffId());

        //validate
        if(staffJpa.isPresent()) {
            Staff staff = staffJpaToStaffConvertor.convert(staffJpa.get());
            staff.deleteStaffSkill(deleteStaffSkillCommand.getSkillId());
            StaffJpa updatedStaff = staffToStaffJpaConvertor.convert(staff);
            staffRepository.save(updatedStaff);
        } else {
            throw new IllegalArgumentException("Staff not recognised");
        }
    }

    @Override
    public void addStaffSkill(INFAddStaffSkillCommand addStaffSkillCommand) {
        Optional<StaffJpa> staffJpa = staffRepository.findById(addStaffSkillCommand.getStaffId());

        if(staffJpa.isPresent()) {
            Staff staff = staffJpaToStaffConvertor.convert(staffJpa.get());
            StaffSkill staffSkill = new StaffSkill(addStaffSkillCommand.getStaffId(),
                    addStaffSkillCommand.getSkillId(),
                    StrengthOfSkill.valueOf(addStaffSkillCommand.getStrengthOfSkill()),
                    addStaffSkillCommand.getExpiryDate());

            staff.addStaffSkill(staffSkill);
            staffRepository.save(staffToStaffJpaConvertor.convert(staff));

        } else {
            throw new IllegalArgumentException("Staff not recognised");
        }
    }

    @Override
    public void editStaffSkill(INFEditStaffSkillCommand editStaffSkillCommand) {
        Optional<StaffJpa> staffJpa = staffRepository.findById(editStaffSkillCommand.getStaffId());
        if(staffJpa.isPresent()) {
            Staff staff = staffJpaToStaffConvertor.convert(staffJpa.get());
            staff.editAStaffSkill(editStaffSkillCommand);
            StaffJpa updatedStaffJpa = staffToStaffJpaConvertor.convert(staff);
            staffRepository.save(updatedStaffJpa);
        } else {
            throw new IllegalArgumentException("Staff not recognised");
        }
    }

    @Override
    public void editStaff(INFEditStaffCommand editStaffCommand) {
        Optional<StaffJpa> staffJpa = staffRepository.findById(editStaffCommand.getStaffId());
        if (staffJpa.isPresent()) {
            Staff staff = staffJpaToStaffConvertor.convert(staffJpa.get());
            staff.editStaffDetails(editStaffCommand);
            staffRepository.save(staffToStaffJpaConvertor.convert(staff));
        } else {
            throw new IllegalArgumentException("Staff not recognised");
        }
    }
}
