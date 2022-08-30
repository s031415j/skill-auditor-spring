package com.example.skillsauditor.user.application.staff.DTO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class StaffDTO {

    private String id;
    private String fullname_first_name;
    private String fullname_surname;
    private String logindetails_username;
    private String logindetails_password;
    private String job_role;
    private String manager;
    private String address_house_name_number;
    private String address_street;
    private String address_town;
    private String address_postcode;
}
