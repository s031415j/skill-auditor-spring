package com.example.skillsauditor.user.domain.common.staff.staffSkill;

import com.example.skillsauditor.user.domain.common.IdentifiedValueObject;
import com.example.skillsauditor.user.domain.common.Identity;
import com.example.skillsauditor.user.domain.common.staff.staffSkill.interfaces.INFEditStaffSkillCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class StaffSkill extends IdentifiedValueObject {

    private String staffId;
    private String skillId;
    private StrengthOfSkill strengthOfSkill;
    private ExpiryDate expiryDate;

    public static StaffSkill staffSkillOf(String staffId, String skillId, StrengthOfSkill strengthOfSkill, ExpiryDate expiryDate) {
        return new StaffSkill(staffId,skillId, strengthOfSkill, expiryDate);
    }
    
    public void editStaffSkill(INFEditStaffSkillCommand editStaffSkillCommand) {
        this.strengthOfSkill = StrengthOfSkill.valueOf(editStaffSkillCommand.getStrengthOfSkill());
        this.skillId = editStaffSkillCommand.getSkillId();
        this.expiryDate = editStaffSkillCommand.getExpiryDate();
    }
}
