package com.example.skillsauditor.user.application.staff.DTO;

import com.example.skillsauditor.user.application.manager.DTO.TeamMemberDTO;
import com.example.skillsauditor.user.application.staffSkill.DTO.StaffSkillDTO;
import com.example.skillsauditor.user.domain.common.staff.JobRole;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class StaffDTO{

    private String id;
    private String full_name_first_name;
    private String full_name_surname;
    private String login_details_username;
    private String login_details_password;
    private JobRole job_role;
    private String address_house_name_number;
    private String address_street;
    private String address_town;
    private String address_postcode;
    private List<StaffSkillDTO> skills;

    public StaffDTO(String id,
                    String fullNameFirstname,
                    String fullNameSurname,
                    String loginDetailsUsername,
                    String loginDetailsPassword,
                    JobRole jobRole,
                    String addressHouseNameNumber,
                    String addressStreet,
                    String addressTown,
                    String addressPostcode,
                    List<StaffSkillDTO> skills){
        this.id = id;
        this.full_name_first_name = fullNameFirstname;
        this.full_name_surname = fullNameSurname;
        this.login_details_username = loginDetailsUsername;
        this.login_details_password = loginDetailsPassword;
        this.job_role = jobRole;
        this.address_house_name_number = addressHouseNameNumber;
        this.address_street = addressStreet;
        this.address_town = addressTown;
        this.address_postcode = addressPostcode;
        this.skills = skills;
    }

}
