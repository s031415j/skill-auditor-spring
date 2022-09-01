package com.example.skillsauditor.user.infrastructure.staff;

import com.example.skillsauditor.user.infrastructure.staffSkill.StaffSkillJpa;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity(name="staff")
@Table(name="staff")
@ToString
@Getter
@Setter
public class StaffJpa implements INFStaffJpa {

    @Id
    @Column(name="id")
    private String id;

    @Column(name="fullname_first_name")
    private String fullNameFirstname;

    @Column(name="fullname_surname")
    private String fullNameSurname;

    @Column(name="logindetails_username")
    private String loginDetailsUsername;

    @Column(name="logindetails_password")
    private String loginDetailsPassword;

    @Column(name="job_role")
    private String jobRole;

    @Column(name="manager")
    private String manager;

    @Column(name="address_house_name_number")
    private String addressHouseNameNumber;

    @Column(name="address_street")
    private String addressStreet;

    @Column(name="address_town")
    private String addressTown;

    @Column(name="address_postcode")
    private String addressPostcode;

    @OneToMany(mappedBy = "staffId", cascade = {CascadeType.ALL})
    private List<StaffSkillJpa> staffSkillJpaList;

   protected StaffJpa(){

   }

    protected StaffJpa(String id, String fullName_firstname,
                    String fullName_surname, String loginDetails_username,
                    String loginDetails_password, String job_role, String manager,
                    String address_houseNameNumber, String address_street,
                    String address_town, String address_postcode) {
        this.id = id;
        this.fullNameFirstname = fullName_firstname;
        this.fullNameSurname = fullName_surname;
        this.loginDetailsUsername = loginDetails_username;
        this.loginDetailsPassword = loginDetails_password;
        this.jobRole = job_role;
        this.manager = manager;
        this.addressHouseNameNumber = address_houseNameNumber;
        this.addressStreet = address_street;
        this.addressTown = address_town;
        this.addressPostcode = address_postcode;
        staffSkillJpaList = new ArrayList<>();

    }

    public static StaffJpa staffJpaOf(String id, String fullNameFirstname,
                                      String fullNameSurname, String loginDetailsUsername,
                                      String loginDetailsPassword, String jobRole, String manager,
                                      String addressHouseNameNumber, String addressStreet,
                                      String addressTown, String addressPostcode){
       return new StaffJpa(id, fullNameFirstname, fullNameSurname, loginDetailsUsername, loginDetailsPassword,
               jobRole, manager, addressHouseNameNumber, addressStreet, addressTown, addressPostcode);
    }

    @Override
    public List<StaffSkillJpa> getStaffSkills() {
        return null;
    }

    public void addStaffSkill(StaffSkillJpa staffSkillJpa) {
        staffSkillJpaList.add(staffSkillJpa);
   }

}