package com.example.skillsauditor.user.domain.manager.interfaces;

import com.example.skillsauditor.user.infrastructure.manager.ManagerTeamJpa;
import com.example.skillsauditor.user.infrastructure.staff.StaffSkillJpa;
import java.util.List;

public interface INFManagerJpa {

    String getId();
    String getFullNameFirstname();
    String getFullNameSurname();
    String getLoginDetailsUsername();
    String getLoginDetailsPassword();
    String getJobRole();
    String getAddressHouseNameNumber();
    String getAddressStreet();
    String getAddressTown();
    String getAddressPostcode();
    List<StaffSkillJpa> getStaffSkills();
    List<ManagerTeamJpa> getTeam();


    void setId(String id);
    void setFullNameFirstname(String fullNameFirstname);
    void setFullNameSurname(String fullNameSurname);
    void setLoginDetailsUsername(String loginDetailsUsername);
    void setLoginDetailsPassword(String loginDetailsPassword);
    void setJobRole(String jobRole);
    void setAddressHouseNameNumber(String addressHouseNameNumber);
    void setAddressStreet(String addressStreet);
    void setAddressTown(String addressTown);
    void setAddressPostcode(String addressPostcode);
    void setStaffSkills(List<StaffSkillJpa> staffSkills);
    void setTeam(List<ManagerTeamJpa> team);
    void deleteTeamMember(ManagerTeamJpa teamMember);
}
