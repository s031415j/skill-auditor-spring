package com.example.skillsauditor.user.domain.common.staff.interfaces;

import com.example.skillsauditor.user.domain.common.staffSkill.StaffSkill;
import com.example.skillsauditor.user.infrastructure.staff.StaffSkillJpaValueObject;

import java.util.List;

public interface INFStaffJpa {
    String getId();
    String getFullNameFirstname();
    String getFullNameSurname();
    String getLoginDetailsUsername();
    String getLoginDetailsPassword();
    String getJobRole();
    String getManager();
    String getAddressHouseNameNumber();
    String getAddressStreet();
    String getAddressTown();
    String getAddressPostcode();
    List<StaffSkillJpaValueObject> getStaffSkills();

    void addStaffSkill(StaffSkillJpa staffSkillJpa);

//    void setId(String id);
//
//    void setFullname_firstname(String fullname_firstname);
//    void setFullname_surname(String fullname_surname);
//    void setLogindetails_username(String logindetails_username);
//    void setLogindetails_password(String logindetails_password);
//    void setJob_role(String job_role);
//    void setManager(String manager);
//    void setAddress_houseNameNumber(String address_houseNameNumber);
//    void setAddress_street(String address_street);
//    void setAddress_town(String address_town);
//    void setAddress_postcode(String address_postcode);

}
