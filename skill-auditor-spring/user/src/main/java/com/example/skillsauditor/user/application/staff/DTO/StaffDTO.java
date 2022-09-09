package com.example.skillsauditor.user.application.staff.DTO;

import com.example.skillsauditor.user.application.staff.staffSkill.DTO.StaffSkillDTO;
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

}
