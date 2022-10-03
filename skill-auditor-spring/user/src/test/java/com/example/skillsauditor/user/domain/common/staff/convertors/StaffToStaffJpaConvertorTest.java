package com.example.skillsauditor.user.domain.common.staff.convertors;

import com.example.skillsauditor.user.domain.common.*;
import com.example.skillsauditor.user.domain.common.convertors.StaffToStaffJpaConvertor;
import com.example.skillsauditor.user.infrastructure.staff.StaffJpa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class StaffToStaffJpaConvertorTest {

    private StaffToStaffJpaConvertor convertor;

    private Staff staff;

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

        FullName fullName = new FullName(FIRST_NAME, SURNAME);
        LoginDetails loginDetails = new LoginDetails(USERNAME, PASSWORD);
        Address address = new Address(HOUSE_NAME_NUMBER, STREET, TOWN, POSTCODE);

        staff = new Staff(ID, fullName, loginDetails, JOB_ROLE, address);
        convertor = new StaffToStaffJpaConvertor();
    }


    @Test
    public void convert_When_Given_A_Staff_Return_A_StaffJpa_With_The_Same_Data(){

        StaffJpa staffJpa= convertor.convert(staff);

        assertEquals(ID.toString(), staffJpa.getId());
        assertEquals(FIRST_NAME, staffJpa.getFullNameFirstname());
        assertEquals(SURNAME, staffJpa.getFullNameSurname());
        assertEquals(USERNAME, staffJpa.getLoginDetailsUsername());
        assertEquals(PASSWORD, staffJpa.getLoginDetailsPassword());
        assertEquals(JOB_ROLE.toString(), staffJpa.getJobRole());
        assertEquals(HOUSE_NAME_NUMBER, staffJpa.getAddressHouseNameNumber());
        assertEquals(STREET, staffJpa.getAddressStreet());
        assertEquals(TOWN, staffJpa.getAddressTown());
        assertEquals(POSTCODE, staffJpa.getAddressPostcode());

    }
}
