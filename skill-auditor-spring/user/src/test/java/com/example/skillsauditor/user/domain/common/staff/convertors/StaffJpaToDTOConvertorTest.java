package com.example.skillsauditor.user.domain.common.staff.convertors;

import com.example.skillsauditor.user.domain.common.Identity;
import com.example.skillsauditor.user.domain.common.UniqueIDFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.MockitoAnnotations.openMocks;

public class StaffJpaToDTOConvertorTest {

    private AutoCloseable closeable;

    private final Identity ID = UniqueIDFactory.createID();
    private final String FIRST_NAME = "FirstTest";
    private final String SURNAME = "SurTest";
    private final String LOG_IN_DETAILS_USERNAME = "UserTest";
    private final String LOG_IN_DETAILS_PASSWORD = "PassTest";
    private final String JOB_ROLE = "STAFF";
    private final String HOUSE_NAME_NUMBER = "1";
    private final String STREET = "StreetTest";
    private final String TOWN = "TownTest";
    private final String POSTCODE = "PostcodeTest";


    @BeforeEach
    public void init(){
        closeable = openMocks(this);
    }

    @Test
    public void test01_When_Given_StaffJpa_Return_List_Of_StaffDTO(){

    }

    @Test
    public void test02_When_Given_StaffJpa_Return_List_Of_StaffDTO(){

    }

    @Test
    public void test03_When_Given_StaffJpa_Return_List_Of_StaffSkillDTO(){

    }

    @Test
    public void test04_When_Given_StaffSkillJpa_If_Skill_Expired_Return_True(){

    }

    @Test
    public void test05_When_Given_StaffSkillJpa_If_Skill_Not_Expired_Return_False(){

    }

    @Test
    public void test06_When_Given_StaffSkillJpa_Return_ExpiryDate(){

    }
}
