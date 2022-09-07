package com.example.skillsauditor.user.domain.common.staff.staffSkill;

import com.example.skillsauditor.user.domain.common.Entity;
import com.example.skillsauditor.user.domain.common.Identity;
import lombok.ToString;
import java.util.Date;

@ToString
public class StaffSkill extends Entity {

    private String staffId;
    private String skillId;
    private StrengthOfSkill strengthOfSkill;
    private Date expiryDate;

    public StaffSkill(Identity id, String staffId, String skillId, StrengthOfSkill strengthOfSkill, Date expiryDate) {
        super(id);
        this.staffId = staffId;
        this.skillId = skillId;
        this.strengthOfSkill = strengthOfSkill;
        this.expiryDate = expiryDate;
    }

    public static StaffSkill staffSkillOf(Identity id, String staffId, String skillId, StrengthOfSkill strengthOfSkill, Date expiryDate){
        return new StaffSkill(id, staffId, skillId, strengthOfSkill, expiryDate);
    }

    public Identity getId(){
        return id;
    }


    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getSkillId() {
        return skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }

    public StrengthOfSkill getStrengthOfSkill() {
        return strengthOfSkill;
    }

    public void setStrengthOfSkill(StrengthOfSkill strengthOfSkill) {
        this.strengthOfSkill = strengthOfSkill;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
