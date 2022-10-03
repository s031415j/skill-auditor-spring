package com.example.skillsauditor.user.domain.common.staff.convertors;

import com.example.skillsauditor.user.domain.common.Identity;
import com.example.skillsauditor.user.domain.common.JobRole;
import com.example.skillsauditor.user.domain.common.Staff;
import com.example.skillsauditor.user.domain.common.UniqueIDFactory;
import com.example.skillsauditor.user.domain.common.convertors.StaffJpaToStaffConvertor;
import com.example.skillsauditor.user.infrastructure.staff.StaffJpa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StaffJpaToStaffConvertorTest {

    private StaffJpaToStaffConvertor convertor;

    private StaffJpa staffJpa;

    private final Identity ID = UniqueIDFactory.createID();
    private final String FIRST_NAME = "FirstTest";
    private final String SURNAME = "SurnameTest";
    private final String USERNAME = "UsernameTest";
    private final String PASSWORD = "PasswordTest";
    private final String HOUSE_NAME_NUMBER = "HouseTest";
    private final String STREET = "StreetTest";
    private final String TOWN = "TownTest";
    private final String POSTCODE = "PostcodeTest";
    private final JobRole JOB_ROLE = JobRole.STAFF;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);

        staffJpa = new StaffJpa(ID.toString(), FIRST_NAME, SURNAME, USERNAME, PASSWORD, JOB_ROLE.toString(), HOUSE_NAME_NUMBER, STREET, TOWN, POSTCODE);
        convertor = new StaffJpaToStaffConvertor();
    }

    @Test
    public void convert_When_Given_A_StaffJpa_Return_A_Staff_With_The_Same_Data(){

        Staff staff = convertor.convert(staffJpa);

        assertEquals(ID.toString(), staff.id().toString());
        assertEquals(FIRST_NAME, staff.getFullName().getFirstName());
        assertEquals(SURNAME, staff.getFullName().getSurname());
        assertEquals(USERNAME, staff.getLoginDetails().getUsername());
        assertEquals(PASSWORD, staff.getLoginDetails().getPassword());
        assertEquals(JOB_ROLE, staff.getJobRole());
        assertEquals(HOUSE_NAME_NUMBER, staff.getAddress().getHouseNameNumber());
        assertEquals(STREET, staff.getAddress().getStreet());
        assertEquals(TOWN, staff.getAddress().getTown());
        assertEquals(POSTCODE, staff.getAddress().getPostcode());

    }

}
