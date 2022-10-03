package com.example.skillsauditor.user.domain.manager;

import com.example.skillsauditor.user.domain.common.Identity;
import com.example.skillsauditor.user.domain.common.JobRole;
import com.example.skillsauditor.user.domain.common.Staff;
import com.example.skillsauditor.user.domain.common.UniqueIDFactory;
import com.example.skillsauditor.user.domain.common.convertors.StaffJpaToStaffConvertor;
import com.example.skillsauditor.user.infrastructure.manager.ManagerJpa;
import com.example.skillsauditor.user.infrastructure.staff.StaffJpa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagerJpaToManagerConvertorTest {


    private ManagerJpaToManagerConvertor convertor;

    private ManagerJpa managerJpa;

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

        managerJpa = new ManagerJpa(ID.toString(), FIRST_NAME, SURNAME, USERNAME, PASSWORD, JOB_ROLE.toString(), HOUSE_NAME_NUMBER, STREET, TOWN, POSTCODE);
        convertor = new ManagerJpaToManagerConvertor();
    }

    @Test
    public void convert_When_Given_A_ManagerJpa_Return_A_Manager_With_The_Same_Data(){

        Manager manager = convertor.convert(managerJpa);

        assertEquals(ID.toString(), manager.id().toString());
        assertEquals(FIRST_NAME, manager.getFullName().getFirstName());
        assertEquals(SURNAME, manager.getFullName().getSurname());
        assertEquals(USERNAME, manager.getLoginDetails().getUsername());
        assertEquals(PASSWORD, manager.getLoginDetails().getPassword());
        assertEquals(JOB_ROLE, manager.getJobRole());
        assertEquals(HOUSE_NAME_NUMBER, manager.getAddress().getHouseNameNumber());
        assertEquals(STREET, manager.getAddress().getStreet());
        assertEquals(TOWN, manager.getAddress().getTown());
        assertEquals(POSTCODE, manager.getAddress().getPostcode());

    }
}
