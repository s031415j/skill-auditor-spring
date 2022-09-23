package com.example.skillsauditor.user.domain.common;

import com.example.skillsauditor.user.domain.common.interfaces.INFEditStaffCommand;
import com.example.skillsauditor.user.domain.common.staffSkill.StaffSkill;
import com.example.skillsauditor.user.domain.common.staffSkill.StrengthOfSkill;
import com.example.skillsauditor.user.domain.common.staffSkill.interfaces.INFEditStaffSkillCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Staff extends Entity {

    private FullName fullName;
    private LoginDetails loginDetails;
    private JobRole jobRole;
    private Address address;
    private List<StaffSkill> staffSkills;

    public Staff(Identity id, FullName fullName, LoginDetails loginDetails, JobRole jobRole, Address address) {
        super(id);
        this.fullName = fullName;
        this.loginDetails = loginDetails;
        this.jobRole = jobRole;
        this.address = address;
        this.staffSkills = new ArrayList<>();
    }

    public static Staff staffOf(Identity id, FullName fullName, LoginDetails loginDetails, JobRole jobRole, Address address){
        return new Staff(id,fullName, loginDetails, jobRole, address);
    }

    public StaffSkill addStaffSkill(StaffSkill staffSkill){
        if(!staffSkills.contains(staffSkill)){
            this.staffSkills.add(staffSkill);
        }
        return staffSkill;
    }

    public void deleteStaffSkill(String staffSkillId){
        for(StaffSkill staffSkill : staffSkills) {
            if(staffSkill.getSkillId().equals(staffSkillId)){
                staffSkills.remove(staffSkill);
                break;
            }
        }
    }

    public void editAStaffSkill(INFEditStaffSkillCommand staffSkillCommand) {
        for(StaffSkill staffSkill : staffSkills) {
            if(staffSkill.getSkillId().equals(staffSkill.getSkillId())) {
                staffSkill.setSkillId(staffSkill.getSkillId());
                staffSkill.setStrengthOfSkill(StrengthOfSkill.valueOf(staffSkill.getStrengthOfSkill().toString()));
                staffSkill.setExpiryDate(staffSkill.getExpiryDate());
                break;
            }
        }
    }

    public void editStaffDetails(INFEditStaffCommand editStaffCommand) {
        this.fullName = editStaffCommand.getFullName();
        this.address = editStaffCommand.getAddress();
        this.jobRole = JobRole.valueOf(editStaffCommand.getJobRole());
        this.loginDetails = editStaffCommand.getLoginDetails();
    }

    public boolean getStaffSkillById(String id) {
        for(StaffSkill staffSkill : staffSkills) {
            if(staffSkill.getStaffId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public List<StaffSkill> getAllSkills() {
        return staffSkills;
    }

    public Identity id(){
        return id;
    }

    public boolean hasSkill(String skillId) {
        for(StaffSkill staffSkill : staffSkills){
            if(staffSkill.getSkillId().equals(skillId)){
                return true;
            }
        }
        return false;
    }
}
