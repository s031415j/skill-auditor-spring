package com.example.skillsauditor.user.application.staff;

import com.example.skillsauditor.user.domain.common.staff.interfaces.INFEditStaffCommand;
import com.example.skillsauditor.user.domain.common.staff.staffSkill.interfaces.INFAddStaffSkillCommand;
import com.example.skillsauditor.user.domain.common.staff.staffSkill.interfaces.INFDeleteStaffSkillCommand;
import com.example.skillsauditor.user.domain.common.staff.staffSkill.interfaces.INFEditStaffSkillCommand;
import com.example.skillsauditor.user.ui.staff.interfaces.INFStaffApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StaffApplicationService implements INFStaffApplicationService {
    @Override
    public void deleteStaffSkill(INFDeleteStaffSkillCommand deleteStaffSkillCommand) {

    }

    @Override
    public void addStaffSkill(INFAddStaffSkillCommand addStaffSkillCommand) {

    }

    @Override
    public void editStaffSkill(INFEditStaffSkillCommand editStaffSkillCommand) {

    }

    @Override
    public void editStaff(INFEditStaffCommand updateStaffCommand) {

    }
}
