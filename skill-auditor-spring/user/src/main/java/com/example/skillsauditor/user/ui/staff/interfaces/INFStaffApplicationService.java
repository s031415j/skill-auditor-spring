package com.example.skillsauditor.user.ui.staff.interfaces;

import com.example.skillsauditor.user.domain.common.staff.interfaces.INFEditStaffCommand;
import com.example.skillsauditor.user.domain.common.staff.staffSkill.interfaces.INFAddStaffSkillCommand;
import com.example.skillsauditor.user.domain.common.staff.staffSkill.interfaces.INFDeleteStaffSkillCommand;
import com.example.skillsauditor.user.domain.common.staff.staffSkill.interfaces.INFEditStaffSkillCommand;

public interface INFStaffApplicationService {

    void deleteStaffSkill(INFDeleteStaffSkillCommand deleteStaffSkillCommand);
    void addStaffSkill(INFAddStaffSkillCommand addStaffSkillCommand);
    void editStaffSkill(INFEditStaffSkillCommand editStaffSkillCommand);
    void editStaff(INFEditStaffCommand updateStaffCommand);
}
