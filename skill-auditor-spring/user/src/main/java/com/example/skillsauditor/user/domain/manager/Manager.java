package com.example.skillsauditor.user.domain.manager;

import com.example.skillsauditor.user.domain.common.Identity;
import com.example.skillsauditor.user.domain.common.staff.Address;
import com.example.skillsauditor.user.domain.common.staff.FullName;
import com.example.skillsauditor.user.domain.common.staff.LoginDetails;
import com.example.skillsauditor.user.domain.common.staff.Staff;
import com.example.skillsauditor.user.domain.common.staffSkill.StaffSkill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Manager extends Staff {

    private List<Staff> team;
    private List<StaffSkill> staffSkillList;


    public Manager(Identity id, FullName fullName, LoginDetails loginDetails, String jobRole, String manager, Address address) {
        super(id, fullName, loginDetails, jobRole, manager, address);
        this.staffSkillList = new ArrayList<>();
        this.team = new ArrayList<>();
    }

    public static Manager managerOf(Identity id, FullName fullName, LoginDetails loginDetails, String jobRole, String manager, Address address){
        return new Manager(id,fullName, loginDetails, jobRole, manager, address);
    }

    public StaffSkill addStaffSkill(StaffSkill staffSkill){
        if(!staffSkillList.contains(staffSkill)){
            this.staffSkillList.add(staffSkill);
        }
        return staffSkill;
    }

    public Staff addStaffToTeam(Staff staff){
        if(!team.contains(staff)){
            this.team.add(staff);
        }
        return staff;
    }

    public List<StaffSkill> retrieveAllStaffSkills(){
        return Collections.unmodifiableList(staffSkillList);
    }

    public List<Staff> retrieveTeam(){
        return Collections.unmodifiableList(team);
    }

}
