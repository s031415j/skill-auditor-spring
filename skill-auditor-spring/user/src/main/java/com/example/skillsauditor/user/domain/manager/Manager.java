package com.example.skillsauditor.user.domain.manager;

import com.example.skillsauditor.user.domain.common.*;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Staff {

    private List<ManagerTeam> team;

    public Manager(Identity id, FullName fullName, LoginDetails loginDetails, JobRole jobRole, Address address) {
        super(id, fullName, loginDetails, jobRole, address);
        this.team = new ArrayList<>();
    }

    public static Manager managerOf(Identity id, FullName fullName, LoginDetails loginDetails, JobRole jobRole, Address address){
        return new Manager(id,fullName, loginDetails, jobRole, address);
    }

    public void addStaffToTeam(ManagerTeam teamMember){
        if(!team.contains(teamMember)){
            this.team.add(teamMember);
        }
        else{
            throw new IllegalArgumentException("Staff member already exists in this team");
        }
    }

    public List<ManagerTeam> getTeam(){
        return team;
    }
}
