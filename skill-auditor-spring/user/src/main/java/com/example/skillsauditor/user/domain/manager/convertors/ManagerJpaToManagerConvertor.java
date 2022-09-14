package com.example.skillsauditor.user.domain.manager.convertors;

import com.example.skillsauditor.user.application.manager.interfaces.INFManagerJpaToManagerConvertor;
import com.example.skillsauditor.user.domain.common.Identity;
import com.example.skillsauditor.user.domain.common.staff.Address;
import com.example.skillsauditor.user.domain.common.staff.FullName;
import com.example.skillsauditor.user.domain.common.staff.JobRole;
import com.example.skillsauditor.user.domain.common.staff.LoginDetails;
import com.example.skillsauditor.user.domain.manager.Manager;
import com.example.skillsauditor.user.domain.manager.ManagerTeam;
import com.example.skillsauditor.user.infrastructure.manager.ManagerJpa;
import com.example.skillsauditor.user.infrastructure.manager.ManagerTeamJpa;
import org.springframework.stereotype.Component;

@Component
public class ManagerJpaToManagerConvertor implements INFManagerJpaToManagerConvertor {
    @Override
    public Manager convert(ManagerJpa managerJpa) {

        Identity identity = new Identity(managerJpa.getId());
        FullName fullName = new FullName(managerJpa.getFullNameFirstname(), managerJpa.getFullNameSurname());
        LoginDetails loginDetails = new LoginDetails(managerJpa.getLoginDetailsUsername(), managerJpa.getLoginDetailsPassword());
        Address address = new Address(managerJpa.getAddressHouseNameNumber(), managerJpa.getAddressStreet(), managerJpa.getAddressTown(), managerJpa.getAddressPostcode());
        JobRole jobRole = JobRole.valueOf(managerJpa.getJobRole());

        Manager manager = Manager.managerOf(identity, fullName, loginDetails, jobRole, address);

        for(ManagerTeamJpa mTeam : managerJpa.getTeam()){
            ManagerTeam teamMember = ManagerTeam.managerTeamOf( mTeam.getManager(), mTeam.getStaff().getId(), fullName);
            manager.addStaffToTeam(teamMember);
        }

        return manager;
    }

}
