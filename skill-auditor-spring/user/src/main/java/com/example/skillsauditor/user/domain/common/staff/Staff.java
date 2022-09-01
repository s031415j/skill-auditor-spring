package com.example.skillsauditor.user.domain.common.staff;

import com.example.skillsauditor.user.domain.common.Entity;
import com.example.skillsauditor.user.domain.common.Identity;
import com.example.skillsauditor.user.domain.common.staffSkill.StaffSkill;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ToString
public class Staff extends Entity {

    private FullName fullName;
    private LoginDetails loginDetails;
    private String jobRole;
    private String manager;
    private Address address;
    private List<StaffSkill> staffSkillList;



    public Staff(Identity id, FullName fullName, LoginDetails loginDetails, String jobRole, String manager, Address address ) {
        super(id);
        this.fullName = fullName;
        this.loginDetails = loginDetails;
        this.jobRole = jobRole;
        this.manager = manager;
        this.address = address;
        this.staffSkillList = new ArrayList<>();

    }

    public static Staff staffOf(Identity id, FullName fullName, LoginDetails loginDetails, String jobRole, String manager, Address address){
        return new Staff(id,fullName, loginDetails, jobRole, manager, address);
    }

    public StaffSkill addStaffSkill(StaffSkill staffSkill){
        if(!staffSkillList.contains(staffSkill)){
            this.staffSkillList.add(staffSkill);
        }
        return staffSkill;
    }


    public void updateFullName(FullName fullName){
        this.fullName = fullName;
    }

    public Identity getId(){
        return id;
    }

    public FullName getFullName() {
        return fullName;
    }

    public LoginDetails getLoginDetails() {
        return loginDetails;
    }

    public String getJobRole() {
        return jobRole;
    }

    public String getManager() {
        return manager;
    }

    public Address getFullAddress() {
        return address;
    }

    public List<StaffSkill> retrieveAllStaffSkills(){
        return Collections.unmodifiableList(staffSkillList);
    }


}
