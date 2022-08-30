package com.example.skillsauditor.user.application.employee.DTO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@Setter
@ToString
public class EmployeeDTO {
    //COMMON BETWEEN STAFF AND MANAGER

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
