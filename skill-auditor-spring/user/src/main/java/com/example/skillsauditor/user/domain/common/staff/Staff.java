package com.example.skillsauditor.user.domain.common.staff;

import com.example.skillsauditor.user.domain.common.Entity;
import com.example.skillsauditor.user.domain.common.Identity;
import com.example.skillsauditor.user.domain.common.staff.interfaces.INFEditStaffCommand;
import com.example.skillsauditor.user.domain.common.staff.staffSkill.StaffSkill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
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

    public boolean getStaffSkillsBySkillById(String id) {
        for(StaffSkill staffSkill : staffSkills) {
            if(staffSkill.getSkillId().equals(id)) {
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

    public void editStaffDetails(INFEditStaffCommand editStaffCommand) {
        this.fullName = editStaffCommand.getFullName();
        this.address = editStaffCommand.getAddress();
        this.jobRole = JobRole.valueOf(editStaffCommand.getJobRole());
        this.loginDetails = editStaffCommand.getLoginDetails();
    }

}
